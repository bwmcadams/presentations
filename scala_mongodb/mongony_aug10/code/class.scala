class MongoConnection(val underlying: Mongo) {
  // Register the core Serialization helpers.
  conversions.scala.RegisterConversionHelpers()
  /**
   * Apply method which proxies getDB, allowing you to call
   * <code>connInstance("dbName")</code>
   *
   * @param dbName A string for the database name
   * @return MongoDB A wrapped instance of a Mongo 'DB Class.
   */
  def apply(dbName: String) = underlying.getDB(dbName).asScala
  def getDB(dbName: String) = apply(dbName)
  def getDatabaseNames() = underlying.getDatabaseNames.asScala
  def dropDatabase(dbName: String) = underlying.dropDatabase(dbName)
  def getVersion() = underlying.getVersion
  def debugString() = underlying.debugString
  def getConnectPoint = underlying.getConnectPoint
  def getAddress = underlying.getAddress
}

// By way of demonstration, an overloaded constructor might look similar to...
class MongoConnection(val underlying: Mongo) {
  def this() = this(new Mongo)
 /* ... */ 
}

