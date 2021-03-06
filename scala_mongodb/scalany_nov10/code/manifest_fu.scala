implicit def tupleToGeoCoords[T : Numeric : Manifest](coords: (T, T)) = GeoCoords(coords._1, coords._2)

trait PushAllOp extends BarewordQueryOperator {
  
   def $pushAll[A <: Any : Manifest](args: (String, A)*): DBObject = 
    if (manifest[A] <:< manifest[Iterable[_]]) 
      apply("$pushAll")(args.map(z => z._1 -> z._2.asInstanceOf[Iterable[_]]):_*)
    else if (manifest[A] <:< manifest[Product]) 
      apply("$pushAll")(args.map(z => z._1 -> z._2.asInstanceOf[Product].productIterator.toIterable): _*)
    else if (manifest[A].erasure.isArray) 
      apply("$pushAll")(args.map(z => z._1 -> z._2.asInstanceOf[Array[_]].toIterable): _*)
    else 
      throw new IllegalArgumentException("$pushAll may only be invoked with a (String, A) where String is the field name and A is an Iterable or Product/Tuple of values (got %s).".format(manifest[A]))
      
}