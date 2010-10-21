val mongoColl = MongoConnection()("casbah_test")("test_data")
val user1 = MongoDBObject("user" -> "bwmcadams",
                          "email" -> "~~bmcadams~~<AT>novusDOTcom")
val user2 = MongoDBObject("user" -> "someOtherUser")
mongoColl += user1
mongoColl += user2
mongoColl.find()
// com.novus.casbah.mongodb.MongoCursor =
// MongoCursor{Iterator[DBObject] with 2 objects.}

for { x <- mongoColl} yield x
/* Iterable[com.mongodb.DBObject] = List(
    { "_id" : { "$oid" : "4c3e2bec521142c87cc10fff"} ,
      "user" : "bwmcadams" ,
      "email" : "~~bmcadams~~<AT>novusDOTcom"},
     { "_id" : { "$oid" : "4c3e2bec521142c87dc10fff"} ,
      "user" : "someOtherUser"}
 ) */
 
mongoColl.findOne(q).foreach { x =>
   // do some work if you found the user...
   println("Found a user! %s".format(x("user")))
}

// Or limit the fields returned
val q  = MongoDBObject.empty
val fields = MongoDBObject("user" -> 1)
for (x <- mongoColl.find(q, fields)) println(x)