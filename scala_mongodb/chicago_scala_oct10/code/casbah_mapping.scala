package subway.model

import scala.reflect.BeanInfo

import com.novus.casbah
import casbah.Imports._
import casbah.Implicits._

import casbah.mapper._
import annotations._

import subway.util.mongo

trait Identified {
  @ID(auto = true) var id: ObjectId = _
}

@BeanInfo
case class Agency(@Key("agency_id")       val name:        Int,
                  @Key("agency_name")     val description: String,
                  @Key("agency_url")      val url:         Option[String] = None,
                  @Key("agency_timezone") val tz:          String,
                  @Key("agency_lang")     val lang:        Option[String] = None,
                  @Key("agency_phone")    val phone:       String) extends Identified

object Agency extends Mapper[Agency]

@BeanInfo
case class Route(@Key("route_id")                      val name:        String,
                 @Key /* infers key from field name */ val agency_id:   Int,
                 @Key("route_short_name")              val short_name:  String,
                 @Key("route_long_name")               val long_name:   String,
                 @Key("route_desc")                    val description: String,
                 @Key                                  val route_type:  Int) extends Identified
{
  lazy val agency = mongo.queries.agency_by_id(agency_id).get
}

object Route extends Mapper[Route]

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


//val N_train = Route.findOne(new ObjectId("4c61aecb6f9ee7cdad5b0275"))
//val of_course_its_mta = N_train.get.agency

// EVEN MOAR! nested, optional documents? collections of nested documents?
