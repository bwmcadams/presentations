val x: DBObject = MongoDBObject("foo" -> "bar", "x" -> 5, "y" -> 238.1)
/* x: com.mongodb.casbah.Imports.DBObject = { "foo" : "bar" , "x" : 5 , "y" : 238.1} */
val y = MongoDBObject("foo" -> "bar", "x" -> 5, "y" -> 238.1)
/* y: com.mongodb.casbah.commons.Imports.DBObject = { "foo" : "bar" , "x" : 5 , "y" : 238.1} */