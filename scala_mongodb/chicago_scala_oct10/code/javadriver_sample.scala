import com.mongodb._

val conn = new Mongo()
val db = conn.getDB("test")
val coll = db.getCollection("testData")

val pies = new BasicDBList()
pies.add("cherry")
pies.add("blueberry")
pies.add("apple")
pies.add("rhubarb")
pies.add("3.14")

val doc = new BasicDBObject()
doc.put("foo", "bar")
doc.put("spam", "eggs")
doc.put("up", "down")
doc.put("pie", pies)

coll.insert(doc)

