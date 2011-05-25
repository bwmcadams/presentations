MongoDB.defineDb(DefaultMongoIdentifier, 
                MongoAddress(MongoHost("localhost", 27017)), "test")
                
MongoDB.useCollection(collectionName) ( coll => {
  val doc = new BasicDBObject
  doc.put("name", "MongoDB")
  doc.put("type", "database")
  doc.put("count", 1)
  // save the doc to the db
  coll.save(doc)
})                

// Alternately, do everything in a single thread...
MongoDB.useSession ( db => {
  val coll = db.getCollection("testCollection") 
  val doc = new BasicDBObject 
  doc.put("name", "MongoSession") 
  doc.put("type", "db") 
  doc.put("count", 1) 
  coll.save(doc) 
})