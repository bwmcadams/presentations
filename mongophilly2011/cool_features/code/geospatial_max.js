> db.stops.find({"stop_geo": {$near: [39.946332, -75.144009],
                              $maxDistance: 5})
