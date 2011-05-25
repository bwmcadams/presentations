#!/bin/sh
#
# Quick & dirty script to load the New York City Transit 
# Subway Data to mongo. Assumes mongo is running and such.
# 
# Data file is from: http://mta.info/developers/ 
# and freely available/redistributable.
# 
# Spec on the data format is available at: 
# http://code.google.com/transit/spec/transit_feed_specification.html
# 
# Not all optional (but all required) specification files are provided by 
# the MTA in the Subway files.
#

MONGO_IMPORT=/usr/local/bin/mongoimport
DOS2UNIX=
IMPORT_CMD="$MONGO_IMPORT -d transit --type csv --headerline --ignoreBlanks"

# Agency is malformed in current file release... Fix it

# add the missing endline character.
echo '\n' >> agency.txt

echo "Loading Agency file..."
perl -pi -e 's/\r\n|\n|\r/\n/g' agency.txt
$IMPORT_CMD -c agency agency.txt
echo "Loading Stops file..."
perl -pi -e 's/\r\n|\n|\r/\n/g' stops.txt
$IMPORT_CMD -c stops stops.txt
echo "Loading Routes file..."
perl -pi -e 's/\r\n|\n|\r/\n/g' routes.txt
$IMPORT_CMD -c routes routes.txt
echo "Loading Trips file..."
perl -pi -e 's/\r\n|\n|\r/\n/g' trips.txt
$IMPORT_CMD -c trips trips.txt
echo "Loading Stop Times file..."
perl -pi -e 's/\r\n|\n|\r/\n/g' stop_times.txt
$IMPORT_CMD -c stop_times stop_times.txt
echo "Loading Calendar file..."
perl -pi -e 's/\r\n|\n|\r/\n/g' calendar.txt
$IMPORT_CMD -c calendar calendar.txt
echo "Loading Calendar Dates File..."
perl -pi -e 's/\r\n|\n|\r/\n/g' calendar_dates.txt
$IMPORT_CMD -c calendar_dates calendar_dates.txt
echo "Loading Shapes file..." # For line drawing - might be usable by GeoMongo
perl -pi -e 's/\r\n|\n|\r/\n/g' shapes.txt
$IMPORT_CMD -c shapes shapes.txt
