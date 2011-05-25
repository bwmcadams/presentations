> db.stops.ensureIndex({"location": "2d", "type": 1});

> db.stops.find({"stop_geo": {$near: [39.946332, -75.144009], 
                              "type": "bus"}});
/**
 *  Hypothetical results would include only bus stops
 */
