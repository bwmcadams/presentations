trait MongoConversionHelper extends Logging {
  def register() = {
    log.debug("Reached base registration method on MongoConversionHelper.")
  }

  def unregister() = {
    log.debug("Reached base de-registration method on MongoConversionHelper.")
  }
}



trait Serializers extends MongoConversionHelper 
                     with ScalaRegexSerializer 
                     with ScalaJCollectionSerializer {
  override def register() =  {
    log.debug("Serializers for Scala Conversions registering")
    super.register()
  }
  override def unregister() = {
    super.unregister()
  }
}

trait JodaDateTimeHelpers extends JodaDateTimeSerializer 
                             with JodaDateTimeDeserializer 

object RegisterConversionHelpers extends Serializers
                                    with Deserializers  {
 def apply() = {
   log.debug("Registering Scala Conversions.")
   super.register()
 }
}

