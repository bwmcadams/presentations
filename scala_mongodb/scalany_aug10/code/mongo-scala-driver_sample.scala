import com.mongodb._
import com.osinka.mongodb._

val conn = new Mongo()
val db = conn.getDB("test")
val coll = db.getCollection("testData").asScala

coll << Map( 
  "foo" -> "bar",
  "spam" -> "eggs",
  "up" -> "down",
  "pie" -> List(
    "cherry",
    "blueberry",
    "apple",
    "rhubarb",
    "3.14"
  )
)

