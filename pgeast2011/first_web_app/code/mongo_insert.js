> db.testData.insert({"userCount": 5})
> x = db.testData.findOne({"userCount": 5})
{ "_id" : ObjectId("4c607f48150c335a4e187f41"), "userCount" : 5 }
> x.userCount
5
> x.userCount = 20
20
> db.testData.save(x)
> db.testData.findOne({_id: x._id})
{ "_id" : ObjectId("4c607f48150c335a4e187f41"), "userCount" : 20 }
> db.testData.update({_id: x._id}, {$inc: {"userCount": 12}})
> db.testData.findOne({_id: x._id})                          
{ "_id" : ObjectId("4c607f48150c335a4e187f41"), "userCount" : 32 }
// upsert
> db.testData.update({"userCount": 5}, {"userCount": 209}, true) 
> db.testData.findOne({"userCount": 209} )                      
{ "_id" : ObjectId("4c60800e08c3693f5962dda5"), "userCount" : 209 }