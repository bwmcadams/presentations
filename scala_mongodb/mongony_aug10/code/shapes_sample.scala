// Base representation
class SubwayStop extends MongoObject {
  var id: Int = _
  var name: String = _
  var locationType: Option[Int] = None
  var latitude: Double = _
  var longitude: Double = _
  
  override def toString: String = 
    "NYC Subway Stop at %s [Lat: %d, Lon: %d]".
      format(name, latitude, longitude)
}

// Factory object
object SubwayStop extends MongoObjectShape[SubwayStop] {
  lazy val id = Field.scalar("stop_id", _.id, 
                      (x: SubwayStop, v: Int) => x.id = v)
  lazy val name = Field.scalar("stop_name", _.name, 
                      (x: SubwayStop, v: String) => x.name = v)
  lazy val locationType = Field.optional(
                            "location_type", _.locationType,
                            (x: SubwayStop, v: Option[Int]) => 
                             x.locationType = v)
  lazy val latitude = Field.scalar("stop_lat", _.id,
                        (x: SubwayStop, v: Double) => x.latitude = v)
  lazy val longitude = Field.scalar("stop_lon", _.id,
                        (x: SubwayStop, v: Double) => x.longitude = v)          
  // per docs, you must define * with all fields or (de)serialization won't work.
  override lazy val * = id :: name :: locationType :: 
                        latitude :: longitude :: Nil       
                           
  override def factory(dbo: DBObject) = Some(new SubwayStop)
}

// retrieving items
val conn = new Mongo()
val db = conn.getDB("nyct_subway")
val coll = db.getCollection("stops")

val stopsColl = coll of SubwayStop 
/* stopsColl is a ShapedCollection[SubwayStop] */
SubwayStop where {
  SubwayStop.latitude < 40.6, 
  SubwayStop.longitude >= -73.8} sortBy SubwayStop.name descending
