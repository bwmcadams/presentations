import pymongo
from pymongo import Connection

if float(pymongo.version) < 1.6:
    raise Exception("ERROR: This script requires PyMongo Version 1.6 or greater.")

connection = Connection()
db = connection['transit']
print "Indexing the Stops Data."
for row in db.stops.find():
    row['stop_geo'] = {'lat': row['stop_lat'], 'lon': row[
import pymongo
from pymongo import Connection

if float(pymongo.version) < 1.6:
    raise Exception("ERROR: This script requires PyMongo Version 1.6 or greater.")

connection = Connection()
db = connection['transit']
print "Indexing the Stops Data."
for row in db.stops.find():
    row['stop_geo'] = {'lat': row['stop_lat'], 'lon': row['stop_lon']}
    db.stops.save(row)

db.stops.ensure_index([('stop_geo', pymongo.GEO2D)])
print "Reindexed stops with Geospatial data."

print "Indexing the Shapes data"
for row in db.shapes.find():
    row['shape_pt_geo'] = {'lat': row['shape_pt_lat'], 'lon': row['shape_pt_lon']}
    db.shapes.save(row)

db.shapes.ensure_index([('shape_pt_geo', pymongo.GEO2D)])
print "Reindexed shapes with Geospatial data."

print "Done."