package store.model.checkout


import store.model.items.{BottleDeposit, Item, Sale, SalesTax,LoyaltySale}



class SelfCheckout{

  var state : States = new Checkout(this)


  var display: String = ""
  var core: String = ""
  var items: Map[String, Item] = Map()
  var cartItems: List[Item] = List()
  val RAM: Item = new Item("8G RAM", 45.59)
  val i9: Item = new Item("Intel Core i9", 408.59)
  val RTX: Item = new Item("RTX 3090", 900.59)
  var M1: Item = new Item("M1 Macbook Pro", 1948.00)



  var loyaltySale: LoyaltySale = new LoyaltySale(10.0)





  i9.addModifier(loyaltySale)









  this.addItemToStore("0012", RAM)
  this.addItemToStore("0013", i9)
  this.addItemToStore("0014", RTX)
  this.addItemToStore("0015", M1)

  def addItemToStore(barcode: String, item: Item): Unit = {
    this.items = items + (barcode -> item)
  }

  def numberPressed(number: Int): Unit = {
    this.state.numberPressed(number)
  }

  def clearPressed(): Unit = {
    this.state.clearPressed()
  }

  def enterPressed(): Unit = {
    this.state.enterPressed()
  }

  def checkoutPressed(): Unit = {
    this.state.checkoutPressed()
  }

  def cashPressed(): Unit = {
    this.state.cashPressed()



  }

  def creditPressed(): Unit = {
    this.state.creditPressed()



  }

  def loyaltyCardPressed(): Unit = {
    this.state.loyaltyCardPressed()

  }

  def displayString(): String = {
    this.display
  }

  def itemsInCart(): List[Item] = {
    this.cartItems
  }

  def subtotal(): Double = {
    var subTotal : Double = 0.0
    for ( x <- this.cartItems){
      subTotal += x.price()
    }
    subTotal
  }


  def tax(): Double = {
    var tax : Double = 0.0
    for ( i <- this.cartItems){
      tax += i.tax()
    }
    tax
  }

  def total(): Double = {
    this.tax() + this.subtotal()
  }




  def prepareStore(): Unit = {
    // Similar to openMap in the Pale Blue Dot assignment, this method is not required and is
    // meant to help you run manual tests.
    //
    // This method is called by the GUI during setup. Use this method to prepare your
    // items and call addItemToStore to add their barcodes. Also add any sales/tax/etc to your
    // items.
    //
    // This method will not be called during testing and you should not call it in your tests.
    // Each test must setup its own items to ensure compatibility in AutoLab. However, you can
    // write a similar method in your Test Suite classes.

    // Example usage:
    //val testItem: Item = new Item("test item", 100.0)
    //this.addItemToStore("472", testItem)

  }

}



