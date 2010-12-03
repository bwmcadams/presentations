scala> implicit val x = 5
x: Int = 5

scala> implicit val y = 15
y: Int = 15

scala> implicit val y = 15.5
y: Double = 15.5

scala> def test(implicit value: AnyVal) = println("Test Value: %s".format(value))
test: (implicit value: AnyVal)Unit

scala> test
<console>:18: error: ambiguous implicit values:
 both value y in object $iw of type => Double
 and value x in object $iw of type => Int
 match expected type AnyVal
       test
       ^
