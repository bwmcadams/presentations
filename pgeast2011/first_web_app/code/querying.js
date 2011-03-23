> db.routes.findOne({"route_short_name": "E"})
{
	"_id" : ObjectId("4d8a1ccbe289ae2897caf547"),
	"route_id" : "E",
	"agency_id" : "MTA NYCT",
	"route_short_name" : "E",
	"route_long_name" : "8 Avenue Local",
	"route_desc" : "Trains operate between Jamaica Center (Parsons/Archer), Queens, and World Trade Center, Manhattan, at all times.",
	"route_type" : 1,
	"route_url" : "http://www.mta.info/nyct/service/pdf/tecur.pdf",
	"route_color" : "0039A6",
	"route_text_color" : "FFFFFF"
}

 
> db.routes.find({"route_long_name": /Local$/}, 
...              {"route_short_name": 1, "route_long_name": 1})

{ "_id" : ObjectId("4d8a1ccbe289ae2897caf539"), "route_short_name" : 1, "route_long_name" : "Broadway - 7 Avenue Local" }
{ "_id" : ObjectId("4d8a1ccbe289ae2897caf53e"), "route_short_name" : 6, "route_long_name" : "Lexington Avenue Local" }
{ "_id" : ObjectId("4d8a1ccbe289ae2897caf540"), "route_short_name" : 7, "route_long_name" : "Flushing Local" }
{ "_id" : ObjectId("4d8a1ccbe289ae2897caf545"), "route_short_name" : "C", "route_long_name" : "8 Avenue Local" }
{ "_id" : ObjectId("4d8a1ccbe289ae2897caf547"), "route_short_name" : "E", "route_long_name" : "8 Avenue Local" }
{ "_id" : ObjectId("4d8a1ccbe289ae2897caf548"), "route_short_name" : "F", "route_long_name" : "Queens Blvd Express/ 6 Av Local" }
{ "_id" : ObjectId("4d8a1ccbe289ae2897caf54b"), "route_short_name" : "J", "route_long_name" : "Nassau St Local" }
{ "_id" : ObjectId("4d8a1ccbe289ae2897caf54c"), "route_short_name" : "L", "route_long_name" : "14 St-Canarsie Local" }
{ "_id" : ObjectId("4d8a1ccbe289ae2897caf54d"), "route_short_name" : "M", "route_long_name" : "QNS BLVD-6th AVE/ Myrtle Local" }
{ "_id" : ObjectId("4d8a1ccbe289ae2897caf550"), "route_short_name" : "R", "route_long_name" : "Broadway Local" }
               
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
