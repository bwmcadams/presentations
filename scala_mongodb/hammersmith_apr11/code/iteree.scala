connection.send(qMsg, SimpleRequestFutures.find((cursor: Cursor) => {
  val b = Seq.newBuilder[String]

  Cursor.basicIter(cursor) { doc =>
    val n = doc.as[String]("name")
    if (!n.contains("$")) b += n.split(name + "\\.")(1)
  }

  callback(b.result())
}))

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

def next() = 
  if (docs.length > 0) // docs is a Queue, each fetched batch is enqueued as docs.enqueue(docs: _*)
    Cursor.entry(docs.dequeue()) 
  else if (hasMore) // internal tracking of last batch fetch; mongo indicates if more results or not
    Cursor.Empty
  else 
    Cursor.EOF

