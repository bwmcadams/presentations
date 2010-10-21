object MongoConnection {
  def apply() = new MongoConnection(new Mongo())
  def apply(addr: DBAddress) = new MongoConnection(new Mongo(addr))
  def connect(addr: DBAddress) = new MongoDB(Mongo.connect(addr))
  def apply(left: DBAddress, right: DBAddress) = new MongoConnection(new Mongo(left, right))
  def apply(left: DBAddress, right: DBAddress, options: MongoOptions) = new MongoConnection(new Mongo(left, right, options))
  def apply(addr: DBAddress, options: MongoOptions) = new MongoConnection(new Mongo(addr, options))
  def apply(host: String) = new MongoConnection(new Mongo(host))
  def apply(host: String, port: Int) = new MongoConnection(new Mongo(host, port))
  //def apply(host: String, options: MongoOptions) = new MongoConnection(new Mongo(host, options))
}

// Based on context, Scala knows if you mean the "object" or the class...

val conn = MongoConnection()  // Invokes apply() on the Object.
val db = conn("testDB") // invokes apply() on the Class, as conn is instance...
