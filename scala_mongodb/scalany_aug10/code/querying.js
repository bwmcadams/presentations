> db.routes.findOne({"route_short_name": "E"})
 {
         "_id" : ObjectId("4c5f755608c3693f59580f8c"),
         "route_id" : "E",
         "agency_id" : "MTA NYCT",
         "route_short_name" : "E",
         "route_long_name" : "8 Avenue Local",
         "route_desc" : "Trains operate between Jamaica Center (Parsons/Archer), Queens, and World Trade Center, Manhattan, at all times.",
         "route_type" : 1,
         "route_url" : "http://www.mta.info/nyct/service/pdf/tecur.pdf"
 }
 
> db.routes.find({"route_long_name": /Local$/}, 
                 {"route_short_name": 1, "route_long_name": 1})

 { "_id" : ObjectId("4c5f755608c3693f59580f7f"), "route_short_name" : 1, "route_long_name" : "Broadway - 7 Avenue Local" }
 { "_id" : ObjectId("4c5f755608c3693f59580f84"), "route_short_name" : 6, "route_long_name" : "Lexington Avenue Local" }
 { "_id" : ObjectId("4c5f755608c3693f59580f86"), "route_short_name" : 7, "route_long_name" : "Flushing Local" }
 { "_id" : ObjectId("4c5f755608c3693f59580f8a"), "route_short_name" : "C", "route_long_name" : "8 Avenue Local" }
 { "_id" : ObjectId("4c5f755608c3693f59580f8c"), "route_short_name" : "E", "route_long_name" : "8 Avenue Local" }
 { "_id" : ObjectId("4c5f755608c3693f59580f8d"), "route_short_name" : "F", "route_long_name" : "Queens Blvd Express/ 6 Av Local" }
 { "_id" : ObjectId("4c5f755608c3693f59580f91"), "route_short_name" : "J", "route_long_name" : "Nassau St Local" }
 { "_id" : ObjectId("4c5f755608c3693f59580f92"), "route_short_name" : "L", "route_long_name" : "14 St-Canarsie Local" }
 { "_id" : ObjectId("4c5f755608c3693f59580f93"), "route_short_name" : "M", "route_long_name" : "Nassau St Local" }
 { "_id" : ObjectId("4c5f755608c3693f59580f96"), "route_short_name" : "R", "route_long_name" : "Broadway Local" }
 { "_id" : ObjectId("4c5f755608c3693f59580f99"), "route_short_name" : "V", "route_long_name" : "Queens Blvd/6 Av Local" }
 { "_id" : ObjectId("4c5f755608c3693f59580f9a"), "route_short_name" : "W", "route_long_name" : "Broadway Local" }                
               
> db.routes.distinct("route_short_name")
 [
         1,
         2,
         3,
         4,
         5,
         6,
         7,
         "A",
         "B",
         "C",
         "D",
         "E",
         "F",
         "G",
         "J",
    /*... */
 ]