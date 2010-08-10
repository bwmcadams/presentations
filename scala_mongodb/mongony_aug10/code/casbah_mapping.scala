import scala.reflect.BeanInfo

import com.novus.casbah.mongodb._

import Imports._
import Implicits._
import mapper._
import annotations._

trait Identified {
  @ID(auto = true) var id: ObjectId = _
}

@BeanInfo
class Agency extends Identified {
  @Key("agency_id")       var name:        String = _
  @Key("agency_name")     var description: String = _
  @Key("agency_url")      var url:         Option[String] = None
  @Key("agency_timezone") var tz:          String = _
  @Key("agency_lang")     var lang:        Option[String] = None
  @Key("agency_phone")    var phone:       String = _

  override def toString = "Agency(name = %s, description = %s, url = %s, tz = %s, lang = %s, phone = %s)".format(name, description, url, tz, lang, phone)
}



object Agency extends Mapper[Agency] {
  conn = MongoConnection()
  db = "nyct_subway"
  coll = "agency"
}

val mta = Agency.findOne(new ObjectId("4c61aecb6f9ee7cdad5b0073"))
// => Option[Agency] = Some(Agency(name = MTA NYCT, description = MTA New York City Transit, url = Some(http://www.mta.info), tz = America/New_York, lang = Some(en), phone = 718-330-1234\n))

val bart = new Agency
bart.name = "BART"
bart.tz = "Same as Twitter"
bart.description = "The subway in SF"
bart.lang = Some("pig latin")

val bart_as_dbobject = Agency.asDBObject(bart)
// => com.novus.casbah.mongodb.Imports.DBObject = { "agency_name" : "The subway in SF" , "agency_timezone" : "Same as Twitter" , "agency_id" : "BART" , "lang" : "pig latin" , "_id" : { "$oid" : "4c61b568b24ad2b175268dff"}}

val barts_new_id = bart.id
// => com.novus.casbah.mongodb.Imports.ObjectId = 4c61b568b24ad2b175268dff


val bart_saved = Agency.upsert(bart)
// => Agency = Agency(name = BART, description = The subway in SF, url = null, tz = Same as Twitter, lang = Some(pig latin), phone = null)

val bart_reloaded = Agency.findOne(new ObjectId("4c61b4bdb24ad2b172268dff"))
// => Option[Agency] = Some(Agency(name = BART, description = The subway in SF, url = null, tz = Same as Twitter, lang = Some(null), phone = null))

@BeanInfo
class Route extends Identified {
  @Key("route_id")                      var name:        String = _
  @Key /* infers key from field name */ var agency_id:   String = _
  @Key("route_short_name")              var short_name:  String = _
  @Key("route_long_name")               var long_name:   String = _
  @Key("route_desc")                    var description: String = _
  @Key                                  var route_type:  Int = _

  override def toString = "Agency(%s -> %s)".format(short_name, long_name)

  // foreign key, anyone?
  lazy val agency = MongoConnection()("nyct_subway").mapped[Agency].findOne("agency_id" -> agency_id).get
}

object Route extends Mapper[Route] {
  conn = MongoConnection()
  db = "nyct_subway"
  coll = "routes"
}

//val N_train = Route.findOne(new ObjectId("4c61aecb6f9ee7cdad5b0275"))
//val of_course_its_mta = N_train.get.agency

// EVEN MOAR! nested, optional documents? collections of nested documents?

@BeanInfo
class Address {
  @Key var street:  String = _ // required strings

  // optional strings and nulls are stripped from final output
  @Key var street2: Option[String] = _

  @Key var city:    String = _
  @Key var state:   String = _
  @Key var zip:     Int = _
}

@BeanInfo
class Person {
  // "_id" can be anything, not just ObjectId
  @ID  var unix_name:       String = _

  @Key var first_name:      String = _
  @Key var last_name:       String = _
  @Key var address:         Address = _

  // optional address. not everyone has a job!
  @Key var work_address:    Option[Address] = None

  // more addresses, a whole list, empty by default
  @Key var other_addresses: List[Address] = Nil
}

val home = new Address
home.street = "1 Main Street"
home.city = "Brooklyn"
home.state = "New York"
home.zip = 11201

val work = new Address

val joe_sixpack = new Person
joe_sixpack.unix_name = "jsixpack"
joe_sixpack.first_name = "Joe"
joe_sixpack.last_name = "Six Pack"
joe_sixpack.address = home

joe_sixpack.work_address = Some(new Address).map {
  work =>

  work.street = "25 Wall Street"
  work.city = "New York"
  work.state = "New York"
  work.zip = 10001

  work
}

joe_sixpack.other_addresses = home :: work :: Nil

object Person extends Mapper[Person]
Person.asDBObject(joe_sixpack)

/*
{
 "unix_name" : "jsixpack" ,
 "first_name" : "Joe" , "last_name" : "Six Pack" ,
 "address" : {
   "street" : "1 Main Street" ,
   "city" : "Brooklyn" ,
   "state" : "New York" ,
   "zip" : 11201
 },
 "work_address" : {
   "street" : "25 Wall Street" ,
   "city" : "New York" ,
   "state" : "New York" ,
   "zip" : 10001
 },
 "other_addresses" : [
   {
     "street" : "1 Main Street" ,
     "city" : "Brooklyn" ,
     "state" : "New York" ,
     "zip" : 11201
   },
   {
     "street" : "25 Wall Street" ,
     "city" : "New York" ,
     "state" : "New York" ,
     "zip" : 10001
   }
 ]
}*/
