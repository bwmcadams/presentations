// FSMongoRecord extends "MongoRecord" to add a few methods
class Venue extends FSMongoRecord[Venue] {
  def meta = Venue

  object venuename extends FSStringField(this, 255)
  object keywords extends StringField(this, 255)
  object userid extends LongField(this)
  object closed extends BooleanField(this) with AuditableField[Venue]
  object mayor extends LegacyForeignKey(this, User) {
    override def optional_? = true
  }
  object mayor_count extends OptionalIntField(this)
  object aliases extends MongoListField[Venue, String](this)
  object popularity extends MongoListField[Venue, Int](this)
  object popularityUpdated extends OptionalJodaDateTimeField[Venue](this)

  object tags extends MongoListField[Venue, String](this)
  object categories extends MongoForeignObjectIdList(this, Category)
}

object Venue extends Venue with FSMetaRecord[Venue] {
  override def collectionName = "venues"
  def createRecord = new Venue
  override def mongoIdentifier = NamedMongoIdentifier.venue
}

// Foursquare's query engine allows for fluid queries in code
Venue where (_.venuename is "Starbucks") 
Venue where (_.venuename nin ("Starbucks", "Whole Foods")) 
Venue where (_.geolatlng near (40.72, -73.99))