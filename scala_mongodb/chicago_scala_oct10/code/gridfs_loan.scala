import com.novus.casbah.mongodb.gridfs._
val gridfs = GridFS(mongoConn) // creates a GridFS handle on ``fs``
val logo = new FileInputStream("src/test/resources/novus-logo.png")
gridfs(logo) { fh =>
  fh.filename = "novus-logo.png"
  fh.contentType = "image/png"
}

val file = gridfs.findOne("novus-logo.png")
