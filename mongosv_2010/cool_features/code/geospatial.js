> db.stops.find({"stop_geo": {$near: [37.41331, -122.07098]}}, {"stop_name": 1, "stop_desc": 1}).limit(10)
{ "_id" : ObjectId("4cf976fb0dc7bf0c1d9eeef8"), "stop_desc" : "600 W. Evelyn Avenue, Mountain View", "stop_name" : "Mountain View Caltrain" }
{ "_id" : ObjectId("4cf976fb0dc7bf0c1d9eeefb"), "stop_desc" : "190 Showers Drive, Mountain View", "stop_name" : "San Antonio Caltrain" }
{ "_id" : ObjectId("4cf976fb0dc7bf0c1d9eef04"), "stop_desc" : "121 W. Evelyn Avenue, Sunnyvale", "stop_name" : "Sunnyvale Caltrain" }
{ "_id" : ObjectId("4cf976fb0dc7bf0c1d9eeeee"), "stop_desc" : "101 California Avenue,Palo Alto", "stop_name" : "California Ave Caltrain" }
{ "_id" : ObjectId("4cf976fb0dc7bf0c1d9eeef4"), "stop_desc" : "137 San Zeno Way, Sunnyvale", "stop_name" : "Lawrence Caltrain" }
{ "_id" : ObjectId("4cf976fb0dc7bf0c1d9eeef9"), "stop_desc" : "95 University Avenue,Palo Alto", "stop_name" : "Palo Alto Caltrain" }
{ "_id" : ObjectId("4cf976fb0dc7bf0c1d9eeef5"), "stop_desc" : "1120 Merrill Street,Menlo Park", "stop_name" : "Menlo Park Caltrain" }
{ "_id" : ObjectId("4cf976fb0dc7bf0c1d9eeee8"), "stop_desc" : "1 Dinkelspiel Station Lane, Atherton", "stop_name" : "Atherton Caltrain" }
{ "_id" : ObjectId("4cf976fb0dc7bf0c1d9eef02"), "stop_desc" : "1001 Railroad Avenue,Santa Clara", "stop_name" : "Santa Clara Caltrain" }
{ "_id" : ObjectId("4cf976fb0dc7bf0c1d9eeef0"), "stop_desc" : "780 Stockton Avenue,San Jose", "stop_name" : "College Park Caltrain" }