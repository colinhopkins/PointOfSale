package store.model.checkout
import store.model.items.{LoyaltyOff, LoyaltyOn, LoyaltySale, Modifier}

class Payment2(theCheckout: SelfCheckout) extends States(theCheckout) {

  override def numberPressed(number: Int): Unit = {}

  override def enterPressed(): Unit = {}

  override def checkoutPressed(): Unit = {}

  override def clearPressed(): Unit = {}

  override def cashPressed(): Unit = {
    this.checkout.display = ""
    this.checkout.core = ""
    this.checkout.cartItems = List()
    for ((string, item) <- this.checkout.items) {
      val x: List[Modifier] = item.Mod_List
      for (second_item <- x) {
        second_item.LoyaltyMode = new LoyaltyOff()
      }
    }
    this.theCheckout.state = new Checkout(this.theCheckout)
  }

  override def creditPressed(): Unit = {
    this.checkout.display = ""
    this.checkout.core = ""
    this.checkout.cartItems = List()
    for ((string, item) <- this.theCheckout.items) {
      val x: List[Modifier] = item.Mod_List
      for (second_item <- x) {
        second_item.LoyaltyMode = new LoyaltyOff()
      }
    }
      this.theCheckout.state = new Checkout(this.theCheckout)

  }

  override def loyaltyCardPressed(): Unit = {

  }


}

