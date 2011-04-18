log.debug("[%s] Querying for Collection Names with: %s", name, qMsg)
connection.send(qMsg, SimpleRequestFutures.find((cursor: Cursor) => {
  log.debug("Got a result from listing collections: %s", cursor)
  val b = Seq.newBuilder[String]

  Cursor.basicIter(cursor) { doc =>
    val n = doc.as[String]("name")
    if (!n.contains("$")) b += n.split(name + "\\.")(1)
  }

  callback(b.result())
}))

// The function helpers for iteration ...

protected[mongodb] def basicIter(cursor: Cursor)(f: BSONDocument => Unit) = {
  def next(op: Cursor.IterState): Cursor.IterCmd = op match {
    case Cursor.Entry(doc) =>  {
      f(doc)
      Cursor.Next(next)
    }
    case Cursor.Empty => {
      Cursor.NextBatch(next)
    }
    case Cursor.EOF => {
      Cursor.Done
    }
  }
  iterate(cursor)(next)
}

def iterate(cursor: Cursor)(op: (IterState) => IterCmd) {
  log.debug("Iterating '%s' with op: '%s'", cursor, op)
  @tailrec def next(f: (IterState) => IterCmd): Unit = op(cursor.next()) match {
    case Done => {
      log.info("Closing Cursor.")
      cursor.close()
    }
    case Next(tOp) => {
      log.debug("Next!")
      next(tOp)
    }
    case NextBatch(tOp) => cursor.nextBatch(() => {
      log.info("Next Batch Loaded.")
      next(tOp)
    })
  }
  next(op)
}
