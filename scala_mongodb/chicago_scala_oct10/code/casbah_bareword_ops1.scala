val setMulti = $set ("foo" -> 5, "bar" -> "N", "spam" -> "eggs")
/* setMulti: DBObject = { "$set" : { "foo" : 5 , "bar" : "N" , "spam" : "eggs"}} */
val pushAll = $pushAll ("foo" -> (5, 10, 15, 20, 25, 38, 12, "bar", "spam", 86, "eggs", "omg", 412, "ponies"))
/* pushAll: DBObject = { "$pushAll" : { "foo" : [ 5 , 10 , 15 , 20 , 25 , 38 , 12 , "bar" , "spam" , 86 , "eggs" , "omg" , 412 , "ponies"]}} */
