val b = MongoDBObject.newBuilder
/* b: com.mongodb.casbah.commons.MongoDBObjectBuilder = com.mongodb.casbah.commons.MongoDBObjectBuilder@113f25e3 */
b += "x" -> 5
b += "y" -> 238.1
b += "foo" -> "bar"
val x: DBObject = b.result
/* x: com.mongodb.casbah.commons.Imports.DBObject = { "x" : 5 , "y" : 238.1 , "foo" : "bar"} */