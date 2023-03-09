package tests

import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items.Item

class Task3 extends FunSuite {

  val testItem: Item = new Item("test item", 100.0)
  val testItem2: Item = new Item("apple", 10.0)

  val testSelfCheckout: SelfCheckout = new SelfCheckout()
  testSelfCheckout.addItemToStore("012", testItem)
  testSelfCheckout.addItemToStore("111", testItem2)

  test("Test Payment Methods") {
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(2)
    assert(testSelfCheckout.displayString() == "012")
    testSelfCheckout.cashPressed()
    assert(testSelfCheckout.displayString() == "012")
    testSelfCheckout.creditPressed()
    assert(testSelfCheckout.displayString() == "012")
    testSelfCheckout.enterPressed()
    assert(testSelfCheckout.itemsInCart() == List(testItem))
    testSelfCheckout.enterPressed()
    testSelfCheckout.enterPressed()
    assert(testSelfCheckout.itemsInCart() == List(testItem,testItem,testItem))
    assert(testSelfCheckout.displayString() == "")
    testSelfCheckout.enterPressed()
    testSelfCheckout.enterPressed()
    assert(testSelfCheckout.displayString() == "")
    assert(testSelfCheckout.itemsInCart() == List(testItem,testItem,testItem,testItem,testItem))
    testSelfCheckout.checkoutPressed()
    assert(testSelfCheckout.displayString() == "cash or credit")
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(2)
    assert(testSelfCheckout.displayString() == "cash or credit")
    testSelfCheckout.enterPressed()
    assert(testSelfCheckout.itemsInCart() == List(testItem,testItem,testItem,testItem,testItem))
    assert(testSelfCheckout.displayString() == "cash or credit")
    testSelfCheckout.clearPressed()
    assert(testSelfCheckout.displayString() == "cash or credit")
    testSelfCheckout.cashPressed()
    assert(testSelfCheckout.displayString() == "")
    assert(testSelfCheckout.itemsInCart() == List())
    testSelfCheckout.cashPressed()
    assert(testSelfCheckout.displayString() == "")
    testSelfCheckout.creditPressed()
    assert(testSelfCheckout.displayString() == "")








  }


}
