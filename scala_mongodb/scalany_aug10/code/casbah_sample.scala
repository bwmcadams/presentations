import com.novus.casbah.mongodb.Imports._ 

val coll = MongoConnection()("test")("testData")

val builder = MongoDBObject.newBuilder
builder += "foo" -> "bar"
builder += "spam" -> "eggs"
builder += "up" -> "down"
builder += "pie" -> List("cherry", "blueberry", 
                         "apple", "rhubarb", "3.14")

coll += builder.result

