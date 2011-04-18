/** 
 * The request ID and callback will be stored in a ConcurrentMap when the write is sent and 
 * invoked when a reply for that request comes back
 */
def databaseNames(callback: Seq[String] => Unit) {
  runCommand("admin", Document("listDatabases" -> 1))(SimpleRequestFutures.command((doc: Document) => {
    log.debug("Got a result from 'listDatabases' command: %s", doc)
    if (!doc.isEmpty) {
      val dbs = doc.as[BSONList]("databases").asList.map(_.asInstanceOf[Document].as[String]("name"))
      callback(dbs)
    } else {
      log.warning("Command 'listDatabases' failed. Doc: %s", doc)
      callback(List.empty[String])
    }
  }))
}

/** 
 * SimpleRequestFutures "swallows" any exceptions, as many times people want to ignore them.
 * For those who want to handle any error by hand, the underlying code uses Either[Throwable, A].
 */
command(authCmd)(RequestFutures.findOne((result: Either[Throwable, Document]) => {
  result match {
    case Right(_doc) =>
      _doc.getAsOrElse[Int]("ok", 0) match {
        case 1 => {
          log.info("Authenticate succeeded.")
          login = Some(username)
          authHash = Some(hash)
        }
        case other => log.error("Authentication Failed. '%d' OK status. %s", other, _doc)
      }
    case Left(e) =>
      log.error(e, "Authentication Failed.")
      callback(this)
  }
}))

// A base trait for RequestFutures which handles the application.
sealed trait RequestFuture {
  type T
  val body: Either[Throwable, T] => Unit

  def apply(error: Throwable) = body(Left(error))

  def apply[A <% T](result: A) = body(Right(result.asInstanceOf[T]))
}

trait CursorQueryRequestFuture extends RequestFuture {
  type T <: Cursor
}

/**
 *
 * Used for findOne and commands
 * Items which return a single document, and not a cursor
 */
trait SingleDocQueryRequestFuture extends QueryRequestFuture {
  type T <: BSONDocument
}

// Finally, the helper methods just provide convenience
// "Simple" 
def command[A <: BSONDocument](f: A => Unit) =
  new SingleDocQueryRequestFuture {
    type T = A
    val body = (result: Either[Throwable, A]) => result match {
      case Right(doc) => f(doc)
      case Left(t) => log.error(t, "Command Failed.")
    }
  }
 
// "Handle your own damn errors"
def command[A <: BSONDocument](f: Either[Throwable, A] => Unit) =
  new SingleDocQueryRequestFuture {
    type T = A
    val body = f
  }
  
