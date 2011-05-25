> db.stops.find({"stop_geo": {$near: [39.946332, -75.144009]}},  
...             {"stop_name": 1, "stop_desc": 1}).limit(10)

{ "_id" : ObjectId("4db712934892e28e4f72cb78"), "stop_name" : "2nd St & Walnut St" }
{ "_id" : ObjectId("4db712934892e28e4f72cf36"), "stop_name" : "Dock St & Dock St" }
{ "_id" : ObjectId("4db712934892e28e4f72cb75"), "stop_name" : "Chestnut St & 2nd St" }
{ "_id" : ObjectId("4db712924892e28e4f72b43c"), "stop_name" : "Spruce St & 2nd St " }
{ "_id" : ObjectId("4db712934892e28e4f72cb79"), "stop_name" : "2nd St & Chestnut St" }
{ "_id" : ObjectId("4db712924892e28e4f72ba14"), "stop_name" : "Chestnut St & Front St " }
{ "_id" : ObjectId("4db712934892e28e4f72c17c"), "stop_name" : "3rd St & Walnut St" }
{ "_id" : ObjectId("4db712934892e28e4f72d5ea"), "stop_name" : "Columbus Blvd & Walnut St  " }
{ "_id" : ObjectId("4db712934892e28e4f72d620"), "stop_name" : "Columbus Blvd & Spruce St " }
{ "_id" : ObjectId("4db712934892e28e4f72cb76"), "stop_name" : "Walnut St & 3rd St - FS" }
