def $ne[T : ValidDateOrNumericType](target: T) = op(oper, target)

trait ValidDateOrNumericTypeHolder extends ValidDateTypeHolder with ValidNumericTypeHolder {
  implicit object JDKDateDoNOk extends JDKDateOk with ValidDateOrNumericType[java.util.Date]
  implicit object JodaDateTimeDoNOk extends JDKDateOk with ValidDateOrNumericType[org.joda.time.DateTime]
  implicit object BigIntDoNOk extends BigIntOk with ValidDateOrNumericType[BigInt]
  implicit object IntDoNOk extends IntOk with ValidDateOrNumericType[Int]
  implicit object ShortDoNOk extends ShortOk with ValidDateOrNumericType[Short]
  implicit object ByteDoNOk extends ByteOk with ValidDateOrNumericType[Byte]
  implicit object LongDoNOk extends LongOk with ValidDateOrNumericType[Long]
  implicit object FloatDoNOk extends FloatOk with ValidDateOrNumericType[Float]
  implicit object BigDecimalDoNOk extends BigDecimalOk with ValidDateOrNumericType[BigDecimal]
  implicit object DoubleDoNOk extends DoubleOk with ValidDateOrNumericType[Double]
}