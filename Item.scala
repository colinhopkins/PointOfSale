package store.model.items



class Item( var itemDescription: String, var itemBasePrice: Double) {

  var Mod_List: List[Modifier] = List()

  def description(): String = {
    val ItemDescription: String = this.itemDescription
    ItemDescription
  }

  def setBasePrice(item: Double): Unit = {
    this.itemBasePrice = item
  }

  def price(): Double = {
    var BasePrice = this.itemBasePrice
    for (i <- Mod_List) {
      BasePrice = i.updatePrice(BasePrice)
    }
    BasePrice
  }

  def addModifier(modifier: Modifier): Unit = {
    Mod_List = Mod_List :+ modifier
  }

  def tax(): Double = {
    var TaxPrice = 0.0
    for (i <- Mod_List) {
      TaxPrice += i.computeTax(price())
    }
    TaxPrice
  }
}

abstract class Modifier() {

  var LoyaltyMode : LoyaltyOn_LoyaltyOff = new LoyaltyOff

  def updatePrice(ItemPrice : Double): Double

  def computeTax(ItemPrice : Double) : Double

}

class Sale(var PercentSale : Double) extends Modifier() {
  LoyaltyMode = new LoyaltyOff()
  override def updatePrice(ItemPrice: Double): Double = {
    val sale: Double = 100 - this.PercentSale
    ItemPrice * (sale / 100)
  }

  override def computeTax(ItemPrice: Double): Double = {
    0.0
  }

}
class SalesTax(var PercentTax : Double ) extends Modifier() {
  LoyaltyMode = new LoyaltyOff()
  override def updatePrice(ItemPrice: Double): Double = {
    ItemPrice
  }

  override def computeTax(ItemPrice: Double): Double = {
    val tax: Double = (this.PercentTax / 100)
    ItemPrice * tax
  }

}

class BottleDeposit(var totalCharged : Double) extends Modifier() {
  LoyaltyMode = new LoyaltyOff()
  override def updatePrice(ItemPrice: Double): Double = {
    ItemPrice
  }

  override def computeTax(ItemPrice: Double): Double = {
    this.totalCharged
  }

}

class LoyaltySale(var PercentLoyaltySale : Double) extends Modifier(){
  LoyaltyMode = new LoyaltyOff()
  override def updatePrice(ItemPrice: Double): Double = {
    val discount: Double = 100 - this.PercentLoyaltySale
    val sale = ItemPrice * (discount / 100)
    LoyaltyMode.LoyaltySale(sale,ItemPrice)
  }

  override def computeTax(ItemPrice: Double): Double = {
    0.0
  }
}

abstract class LoyaltyOn_LoyaltyOff{
  def LoyaltySale (On : Double, Off : Double): Double
 }

class LoyaltyOn extends LoyaltyOn_LoyaltyOff {
  override def LoyaltySale (On : Double, Off : Double): Double = {
    On
  }
}

class LoyaltyOff extends LoyaltyOn_LoyaltyOff {
  override def LoyaltySale (On : Double, Off : Double): Double = {
    Off
  }
}


















