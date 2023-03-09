package tests

import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items.Item

class Task1 extends FunSuite {
  val testItem: Item = new Item("test item", 100.0)
  val testItem2: Item = new Item("apple", 10.0)

  val testSelfCheckout: SelfCheckout = new SelfCheckout()
  testSelfCheckout.addItemToStore("012", testItem)
  testSelfCheckout.addItemToStore("111", testItem2)


  test("Task 1") {

    assert(testSelfCheckout.displayString() == "")
    testSelfCheckout.numberPressed(4)
    testSelfCheckout.numberPressed(7)
    testSelfCheckout.numberPressed(2)
    assert(testSelfCheckout.displayString() == "472")
    testSelfCheckout.clearPressed()
    assert(testSelfCheckout.displayString() == "")
    testSelfCheckout.clearPressed()


    assert(testItem.description() == "test item")
    assert(testItem2.description() == "apple")

    val epsilon: Double = 0.001
    assert(Math.abs(testItem2.price() - 10.0) < epsilon)
    testItem2.setBasePrice(60.0)
    assert(Math.abs(testItem2.price() - 60.0) < epsilon)

    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.enterPressed()
    var cart: List[Item] = List(testItem)
    assert(testSelfCheckout.itemsInCart() == cart)

    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.enterPressed()
    cart = cart :+ testItem2
    assert(testSelfCheckout.itemsInCart() == cart)

    testSelfCheckout.numberPressed(0)
    testSelfCheckout.enterPressed()

    val errorObj: Item = testSelfCheckout.itemsInCart()(2)
    val priceError = errorObj.price()
    assert(errorObj.description() == "error")
    assert(Math.abs(priceError - 0.0) < epsilon)

    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(0)
    assert(testSelfCheckout.displayString() == "00")
    testSelfCheckout.enterPressed()

  }
}




