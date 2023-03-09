package store.model.checkout

import store.model.items.{Item, LoyaltyOff, LoyaltyOn, LoyaltySale, Modifier}


class Payment (theCheckout : SelfCheckout) extends States(theCheckout){

  override def enterPressed(): Unit = {
  }

  override def numberPressed(number: Int): Unit = {
  }

  override def clearPressed(): Unit = {

  }

  override def checkoutPressed(): Unit = {
  }

  override def cashPressed(): Unit = {
    this.checkout.display = ""
    this.checkout.core = ""
    this.checkout.cartItems = List()
    this.theCheckout.state = new Checkout(this.theCheckout)
  }

  override def creditPressed(): Unit = {
    this.checkout.display = ""
    this.checkout.core = ""
    this.checkout.cartItems = List()
    this.theCheckout.state = new Checkout(this.theCheckout)
  }

  override def loyaltyCardPressed(): Unit = {
    for ((string, item) <- this.theCheckout.items) {
      val x: List[Modifier] = item.Mod_List
      for (second_item <- x) {
        second_item.LoyaltyMode = new LoyaltyOn()
      }
    }
    this.theCheckout.state = new Payment2(this.theCheckout)

  }
  }





