package store.model.checkout



abstract class States(val checkout: SelfCheckout) {

  def numberPressed(number: Int): Unit = {}

  def enterPressed(): Unit = {}

  def checkoutPressed(): Unit = {}

  def cashPressed(): Unit = {}

  def creditPressed(): Unit = {}

  def clearPressed(): Unit = {}

  def loyaltyCardPressed(): Unit = {}

}