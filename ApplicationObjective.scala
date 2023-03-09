package tests

import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items.{Item, LoyaltySale, Sale, SalesTax}

class ApplicationObjective extends FunSuite {
  val testItem: Item = new Item("test item", 1000.0)
  val testItem2: Item = new Item("apple", 10.0)

  val testSelfCheckout: SelfCheckout = new SelfCheckout()
  testSelfCheckout.addItemToStore("012", testItem)
  testSelfCheckout.addItemToStore("111", testItem2)


  test("Test 1") {

    val epsilon:Double = .001
    val testItem: Item = new Item("test item", 1000.0)
    val testItem2: Item = new Item("apple", 10.0)
    val testSelfCheckout: SelfCheckout = new SelfCheckout()

    val loyaltySale : LoyaltySale = new LoyaltySale(20)
    testItem.addModifier(loyaltySale)

    testSelfCheckout.addItemToStore("012", testItem)
    testSelfCheckout.addItemToStore("111", testItem2)

    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.enterPressed()
    testSelfCheckout.loyaltyCardPressed()
    assert(Math.abs(testSelfCheckout.total() - 800.0) < epsilon)



  }


  test("Test 2") {

    val epsilon:Double = .001
    val testItem: Item = new Item("test item", 1000.0)
    val testItem2: Item = new Item("apple", 10.0)
    val testSelfCheckout: SelfCheckout = new SelfCheckout()

    val sale : Sale = new Sale(10)
    val salesTax : SalesTax = new SalesTax(8)
    val loyaltySale : LoyaltySale = new LoyaltySale(20)
    testItem.addModifier(loyaltySale)

    testSelfCheckout.addItemToStore("012", testItem)
    testSelfCheckout.addItemToStore("111", testItem2)

    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.enterPressed()
    testSelfCheckout.loyaltyCardPressed()
    testSelfCheckout.checkoutPressed()
    testSelfCheckout.cashPressed()
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.enterPressed()
    assert(Math.abs(testSelfCheckout.total() - 1000.0) < epsilon)





  }

  test("Test 3") {

    val epsilon:Double = .001
    val testItem: Item = new Item("test item", 1000.0)
    val testItem2: Item = new Item("apple", 10.0)
    val testSelfCheckout: SelfCheckout = new SelfCheckout()

    val sale : Sale = new Sale(10)
    val salesTax : SalesTax = new SalesTax(8)
    val loyaltySale : LoyaltySale = new LoyaltySale(20)
    testItem.addModifier(loyaltySale)
    testItem.addModifier(sale)
    testItem.addModifier(salesTax)

    testSelfCheckout.addItemToStore("012", testItem)
    testSelfCheckout.addItemToStore("111", testItem2)

    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.enterPressed()
    testSelfCheckout.checkoutPressed()
    testSelfCheckout.loyaltyCardPressed()
    testSelfCheckout.loyaltyCardPressed()
    assert(Math.abs(testSelfCheckout.total() - 777.60) < epsilon)





  }
}




