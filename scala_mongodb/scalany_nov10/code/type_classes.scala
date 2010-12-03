abstract class ValidVendingFunds[T]

object ValidVendingFunds {
  implicit object VisaOk extends ValidVendingFunds[VisaCard]
  implicit object AmexOk extends ValidVendingFunds[AmexCard]
  implicit object MCOk extends ValidVendingFunds[MastercardCard]
  implicit object PaperDollarOk extends ValidVendingFunds[DollarBill]
  implicit object PaperFiverOk extends ValidVendingFunds[FiveDollarBill]
  implicit object NickelOk extends ValidVendingFunds[NickelCoin]
  implicit object DimeOk extends ValidVendingFunds[DimeCoin]
  implicit object QuarterOk extends ValidVendingFunds[QuarterCoin]
  implicit object DollarCoinOk extends ValidVendingFunds[DollarCoin]
}

def addMoney[T : ValidVendingFunds](funding: T, amount: Double) = 
    println("Added $%2.2f funding from %s.".format(amount, funding))
  
import ValidVendingFunds._

scala> addMoney(citibankVisa, 5.0)                                       
Added $5.00 funding from Citibank Visa Card #4...

scala> addMoney(wellsFargoMastercard, 25.0)                                       
Added $5.00 funding from Wells Fargo Mastercard Card #5...

scala> addMoney(dollarCoin, 1.0)                                       
Added $1.00 funding from A Dollar coin
