"foo" $ne true
/* error: could not find implicit value for evidence parameter of type com.mongodb.casbah.query.ValidDateOrNumericType[Boolean]
       "foo" $ne true
             ^
*/

implicit object BoolOk extends com.mongodb.casbah.query.ValidDateOrNumericType[Boolean]
/* defined module BoolOk */

"foo" $ne true                                                                         
/* com.mongodb.DBObject with com.mongodb.casbah.query.DSLDBObject = { "foo" : { "$ne" : true}} */