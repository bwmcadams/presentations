> db.stops.find({"stop_lat" : {$lt: 40.6}, {"stop_lon": {$gte: -73.8}}})
 { "_id" : ObjectId("4c5f755608c3693f59580ef0"), "stop_lat" : 40.590927, "stop_lon" : -73.796924, "stop_id" : "H06", "stop_name" : "BEACH 67TH ST - GASTON", "location_type" : 0, "stop_geo" : { "lat" : 40.590927, "lon" : -73.796924 } }
 { "_id" : ObjectId("4c5f755608c3693f59580ef1"), "stop_lat" : 40.592374, "stop_lon" : -73.788522, "stop_id" : "H07", "stop_name" : "BEACH 60TH ST - STRAITON AV", "location_type" : 0, "stop_geo" : { "lat" : 40.592374, "lon" : -73.788522 } }
 { "_id" : ObjectId("4c5f755608c3693f59580ef2"), "stop_lat" : 40.592943, "stop_lon" : -73.776013, "stop_id" : "H08", "stop_name" : "BEACH 44TH ST - FRANK AV", "location_type" : 0, "stop_geo" : { "lat" : 40.592943, "lon" : -73.776013 } }
 { "_id" : ObjectId("4c5f755608c3693f59580ef3"), "stop_lat" : 40.595398, "stop_lon" : -73.768175, "stop_id" : "H09", "stop_name" : "BEACH 36TH ST - EDGEMERE", "location_type" : 0, "stop_geo" : { "lat" : 40.595398, "lon" : -73.768175 } }


> db.trips.findOne({"route_id": {$in: ["E", "4", "5"]}})     
 {
         "_id" : ObjectId("4c5f755708c3693f59583400"),
         "route_id" : "E",
         "service_id" : "B20100308W",
         "trip_id" : "B20100308W_001350_E..S04R",
         "trip_headsign" : "To World Trade Ctr",
         "direction_id" : 1,
         "shape_id" : 177710
 }
 
> db.trips.find({"route_id": {$in: ["E", "4", "5"]}}).count()
928