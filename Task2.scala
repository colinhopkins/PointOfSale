package tests

import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items.{BottleDeposit, Item, Sale, SalesTax}

class Task2 extends FunSuite {





  test("Sale") {
    val testSelfCheckout: SelfCheckout = new SelfCheckout()

    val soap: Item = new Item("Soap", 10.0)
    val water: Item = new Item("Water", 1.00)
    val apple: Item = new Item("Apples", 10.0)
    val juice: Item = new Item("Juice", 2.50)

    var salesTax : SalesTax = new SalesTax(8.0)
    val sale : Sale = new Sale(10.0)
    val sale2 : Sale = new Sale(20.0)
    var bottleTax : BottleDeposit = new BottleDeposit(1.0)
    var eps : Double = 0.01

    juice.addModifier(sale)
    juice.addModifier(sale2)
    testSelfCheckout.addItemToStore("144", juice)
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(4)
    testSelfCheckout.numberPressed(4)
    testSelfCheckout.enterPressed()
    assert(Math.abs(testSelfCheckout.total() - 1.80) < eps)

  }

  test("Tax") {
    val testSelfCheckout: SelfCheckout = new SelfCheckout()

    val soap: Item = new Item("Soap", 10.0)
    val water: Item = new Item("Water", 1.00)
    val apple: Item = new Item("Apples", 10.0)
    val juice: Item = new Item("Juice", 2.50)

    var salesTax : SalesTax = new SalesTax(8.0)
    val sale : Sale = new Sale(10.0)
    val sale2 : Sale = new Sale(20.0)
    var bottleTax : BottleDeposit = new BottleDeposit(1.0)
    var eps : Double = 0.01

    juice.addModifier(salesTax)
    testSelfCheckout.addItemToStore("144", juice)
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(4)
    testSelfCheckout.numberPressed(4)
    testSelfCheckout.enterPressed()
    assert(Math.abs(testSelfCheckout.total() - 2.70) < eps)

  }

  test("BottleDeposit") {
    val testSelfCheckout: SelfCheckout = new SelfCheckout()

    val soap: Item = new Item("Soap", 10.0)
    val water: Item = new Item("Water", 1.00)
    val apple: Item = new Item("Apples", 10.0)
    val juice: Item = new Item("Juice", 2.50)

    var salesTax : SalesTax = new SalesTax(8.0)
    val sale : Sale = new Sale(10.0)
    val sale2 : Sale = new Sale(20.0)
    var bottleTax : BottleDeposit = new BottleDeposit(1.0)
    var eps : Double = 0.01

    juice.addModifier(bottleTax)
    testSelfCheckout.addItemToStore("144", juice)
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(4)
    testSelfCheckout.numberPressed(4)
    testSelfCheckout.enterPressed()
    assert(Math.abs(testSelfCheckout.total() - 3.50) < eps)

  }
  test("NoMod") {
    val testSelfCheckout: SelfCheckout = new SelfCheckout()

    val soap: Item = new Item("Soap", 10.0)
    val water: Item = new Item("Water", 1.00)
    val apple: Item = new Item("Apples", 10.0)
    val juice: Item = new Item("Juice", 2.50)

    var salesTax : SalesTax = new SalesTax(8.0)
    val sale : Sale = new Sale(10.0)
    val sale2 : Sale = new Sale(20.0)
    var bottleTax : BottleDeposit = new BottleDeposit(1.0)
    var eps : Double = 0.01

    testSelfCheckout.addItemToStore("144", juice)
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(4)
    testSelfCheckout.numberPressed(4)
    testSelfCheckout.enterPressed()
    assert(Math.abs(juice.price() - 2.50) < eps)
    assert(Math.abs(testSelfCheckout.total() - 2.50) < eps)

  }
}




