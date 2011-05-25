import com.novus.casbah.mongodb.Imports._  // Only import needed - mongoDB type aliases imported too

val coll = MongoConnection()("test")("testData")

// Map
val map: DBObject = Map( 
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

// 'Product'
val product: DBObject = 
( "foo" -> "bar",
  "spam" -> "eggs",
  "up" -> "down",
  "pie" -> List(
    "cherry",
    "blueberry",
    "apple",
    "rhubarb",
    "3.14"
  )
).asDBObject // Explicit conversion method

// "Factory" method
val constructed: DBObject = MongoDBObject(
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

// We showed the builder before
val builder = MongoDBObject.newBuilder
builder += "foo" -> "bar"
builder += "spam" -> "eggs"
builder += "up" -> "down"
builder += "pie" -> List("cherry", "blueberry", 
                         "apple", "rhubarb", "3.14")

val built: DBObject = builder.result

// Also responds to the 'Map' methods...
built += "x" -> "y"
built.getOrElse("x", throw new Error("Can't find value for X")) 
/* res15: AnyRef = y */
