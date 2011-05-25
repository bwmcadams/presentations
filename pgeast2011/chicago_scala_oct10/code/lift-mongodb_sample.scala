import com.mongodb._

import net.liftweb.mongodb._
import net.liftweb.json._
import net.liftweb.json.JsonAST.JObject
import net.liftweb.json.JsonDSL._

implicit val formats = DefaultFormats.lossless

MongoDB.defineDb(DefaultMongoIdentifier, 
                MongoAddress(MongoHost("localhost", 27017)), "test")

val json = JsonParser.parse("""
{ "foo": "bar",
  "spam": "eggs",
  "up": "down",
  "pie": [
    "cherry",
    "blueberry",
    "apple",
    "rhubarb",
    "3.14"
  ]
}
""").asInstanceOf[JObject]

MongoDB.useCollection("testData")( coll => {
  coll.save(JObjectParser.parse(json))
})

