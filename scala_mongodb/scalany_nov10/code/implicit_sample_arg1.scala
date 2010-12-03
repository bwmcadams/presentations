import com.mongodb._
import org.bson.types.ObjectId

def query(id: ObjectId)(implicit coll: DBCollection) = coll.findOne(id)

val conn = new Mongo()
val db = conn.getDB("test")
implicit val coll = db.getCollection("testData")

// coll is passed implicitly
query(new ObjectId())

// or we can override the argument
query(new ObjectId())(db.getCollection("testDataExplicit"))

// You can accept multiple implicits also
def query(id: ObjectId)(implicit conn: Mongo, coll: DBCollection) = {
  conn.slaveOk()
  coll.findOne(id)
}
// Scala prints this for the above method in console:
/* query: (id: ObjectId)(implicit conn: Mongo,implicit coll: DBCollection)DBObject */