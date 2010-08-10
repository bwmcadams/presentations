class MainDoc extends MongoRecord[MainDoc] with MongoId[MainDoc] {
  def meta = MainDoc
  object name extends StringField(this, 12)
  object cnt extends IntField(this)
  object refdoc extends DBRefField[MainDoc, RefDoc](this, RefDoc)	
  object refdocId extends ObjectIdField(this) {
    def fetch = RefDoc.find(value)
  }
}
object MainDoc extends MainDoc with MongoMetaRecord[MainDoc] {
  def createRecord = new MainDoc
}
class RefDoc extends MongoRecord[RefDoc] with MongoId[RefDoc] {
  def meta = RefDoc
}
object RefDoc extends RefDoc with MongoMetaRecord[RefDoc] {
  def createRecord = new RefDoc
}

// Querying appears limited to constructing Mongo DBObjects 
val mdq1 = MainDoc.findAll(("name" -> "md1"))
