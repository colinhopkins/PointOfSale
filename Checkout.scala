package store.model.checkout
import store.model.items.{BottleDeposit, Item, LoyaltyOn, LoyaltySale, Modifier, Sale, SalesTax}



class Checkout (theCheckout: SelfCheckout) extends States(theCheckout) {
  override def enterPressed(): Unit = {
    val store_items = this.theCheckout.items
    val Error: Item = new Item("error", 0.0)
    val error = Error
    val StringDisplay: String = this.theCheckout.core
    val x: Item = store_items.getOrElse(StringDisplay, error)
    this.theCheckout.cartItems = this.theCheckout.cartItems :+ x
    this.theCheckout.itemsInCart()
    this.theCheckout.clearPressed()
  }

  override def numberPressed(number: Int): Unit = {
    this.theCheckout.display = this.theCheckout.display + number.toString
    this.theCheckout.core = this.theCheckout.display
  }

  override def checkoutPressed(): Unit = {
    this.checkout.display = "cash or credit"
    this.theCheckout.state = new Payment(this.theCheckout)
  }

  override def clearPressed(): Unit = {
    this.theCheckout.display = ""
  }

  override def cashPressed(): Unit = {
  }

  override def creditPressed(): Unit = {
  }


  override def loyaltyCardPressed(): Unit = {
    for((string, item)<- this.theCheckout.items){
      val x : List[Modifier] = item.Mod_List
      for(second_item <- x){
        second_item.LoyaltyMode = new LoyaltyOn()
      }
    }
    this.theCheckout.state = new Checkout2(this.theCheckout)
  }
}
