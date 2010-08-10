db.stops.find( { stop_geo: { $near: [40.726021, -73.99617] } }, {'stop_name': 1}).limit(5);
 
  { "_id" : ObjectId("4c5f755608c3693f59580e9b"), "stop_name" : "BROADWAY-LAFAYETTE    " }
  { "_id" : ObjectId("4c5f755608c3693f59580e29"), "stop_name" : "BLEECKER STREET-LEXINGTON" }
  { "_id" : ObjectId("4c5f755608c3693f59580f50"), "stop_name" : "PRINCE STREET         " }
  { "_id" : ObjectId("4c5f755608c3693f59580e2a"), "stop_name" : "SPRING STREET-LEXINGTON" }
  { "_id" : ObjectId("4c5f755608c3693f59580f4f"), "stop_name" : "8TH STREET (NYU)    " }