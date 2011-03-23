> db.stops.find({"stop_geo": {$near: [40.749992, -73.991160]}}, {"stop_name": 1, "stop_desc": 1}).limit(5)
{ "_id" : ObjectId("4d8a1ccbe289ae2897caf365"), "stop_name" : "34 St - Penn Station" }
{ "_id" : ObjectId("4d8a1ccbe289ae2897caf413"), "stop_name" : "34 St - Penn Station" }
{ "_id" : ObjectId("4d8a1ccbe289ae2897caf505"), "stop_name" : "34 St - Herald Sq" }
{ "_id" : ObjectId("4d8a1ccbe289ae2897caf451"), "stop_name" : "34 St - Herald Sq" }
{ "_id" : ObjectId("4d8a1ccbe289ae2897caf366"), "stop_name" : "28 St" }
