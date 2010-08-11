trait MongoDBObject extends Map[String, AnyRef] with Logging {
  def +=(kv: (String, AnyRef)) = {
    put(kv._1, kv._2)
    this
  }

  def -=(key: String) = { 
    underlying.removeField(key)
    this
  }
}

val obj = new MongoDBObject {} 
obj += ("foo", "bar")
// Same as...
obj.+=(("foo", "bar"))
