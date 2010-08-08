// Find any documents where "foo" is between 5 and 15
val findFoo: DBObject = "foo" $gte 5 $lte 15
/* findFoo: DBObject = { "foo" : { "$gte" : 5 , "$lte" : 15}} */
// Find any documents where "bar" contains 1, 8 or 12
val findIn: DBObject = "foo" $in (1, 8, 12)
/* findIn: DBObject = { "foo" : { "$in" : [ 1 , 8 , 12]}} */
