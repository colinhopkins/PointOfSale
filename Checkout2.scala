package store.model.checkout

import store.model.items.LoyaltySale
import store.model.items.Item


class Checkout2(theCheckout: SelfCheckout) extends States(theCheckout) {

  override def numberPressed(number: Int): Unit = {
    this.theCheckout.display = this.theCheckout.display + number.toString
    this.theCheckout.core = this.theCheckout.display
  }

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

  override def checkoutPressed(): Unit = {
    this.theCheckout.display = "cash or credit"
    this.theCheckout.state = new Payment2(this.theCheckout)

  }

  override def clearPressed(): Unit = {
    this.checkout.display = ""
  }

  override def cashPressed(): Unit = {}

  override def creditPressed(): Unit = {}

  override def loyaltyCardPressed(): Unit = {}

}
