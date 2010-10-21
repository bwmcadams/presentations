class ScalaMapReduceSpec extends FeatureSpec with GivenWhenThen with Logging {
  feature("The map/reduce engine works correctly") {
    val conn = new Mongo().asScala
    scenario("Error conditions such as a non-existant collection should not blow up but return an error-state result") {
      given("A Mongo object connected to the default [localhost]")
      assert(conn != null)
      implicit val mongo = conn("foo")("barBazFooBar") // should be nonexistant - @todo ensure it is random
      when("A Map Reduce is run, it doesn't explode despite failure")
      val keySet = distinctKeySet("Foo", "bar", "Baz")
      then("Iteration doesn't blow up either")
      for (x <- keySet) {
        log.info("Keyset entry: %s", x)
      }

    }
  }
  def distinctKeySet(keys: String*)(implicit mongo: MongoCollection): MapReduceResult = {

    val keySet = keys.flatMap(x => "'%s': this.%s, ".format(x, x)).mkString
    val map = "function () { emit({%s}, 1); }".format(keySet)
    val reduce = "function(k, v) { return 1; }"
    val mr = MapReduceCommand(mongo.getName, map, reduce, None, None, None, None, None)
    val result = mongo.mapReduce(mr)
    result
  }
}
