# Self Checkout Kiosk

Welcome to the self checkout kiosk project! This project aims to develop software for a self checkout kiosk without the use of conditionals. The user/customer will input the numeric barcode for each item they want to purchase, and the items will be displayed along with their prices.

## Objectives

The main objectives of this project are:

Develop software for a self checkout kiosk
Apply object-oriented programming concepts
Implement a class to represent the types of items for sale in the store
Implement a class for the self checkout machine that can scan these items
Add modifiers to item prices, such as sales, taxes, and bottle deposits
Complete the customer experience of purchasing items using the self checkout machine
Implement a loyalty program where loyalty sales are active for all purchases of an item with a LoyaltySale added of a type, even if they were scanned before the loyalty card button was pressed.

## Usage

To use this self checkout kiosk, follow these steps:

Scan each item using its numeric barcode
The items and their prices will be displayed on the screen
The final price of each item will be computed based on any modifiers, such as sales, taxes, and bottle deposits
Once all items have been scanned, press the "Finish" button to complete the purchase
If you have a loyalty program card, press the "Loyalty Card" button to activate the loyalty sales for all eligible items

## Implementation

The self checkout kiosk software is developed without using any conditionals. Instead, object-oriented programming approaches are used to make decisions based on the types of objects stored in variables.

### Loyalty Sale Functionality
This project implements a loyalty sale functionality for a self-checkout kiosk. Customers can enter a loyalty program card, which activates a sale price for certain items. The sale price is a percentage discount specified for each item type.

#### Usage
To use the loyalty sale functionality, customers need to press the loyalty card button before scanning any items. Once the button is pressed, the sale prices will be activated for all purchases of the relevant item types, even if they were scanned before the button was pressed. Customers can then scan items as usual, and the loyalty sale prices will be reflected in the item prices.

Note that the loyalty sale prices are not applied to the base price of the items. Instead, they are applied as a separate modifier that is added to the price if the loyalty card button has been pressed.

#### Implementation
The loyalty sale functionality is implemented as a new class named LoyaltySale in the store.model.items package. This class extends the Modifier class and has a constructor that takes a Double argument representing the percentage of the sale price. The sale price is only applied to an item if the loyalty card button has been pressed by the current customer.

The loyalty card button is implemented in the GUI, and when it is pressed, a boolean flag is set to true indicating that the loyalty sale prices should be activated for the current customer. This flag is passed to the SelfCheckout class, which is responsible for keeping track of the items in the customer's cart and computing the final price.

When an item is scanned, the SelfCheckout class checks if the loyalty sale prices should be applied for the item type. If so, it adds a LoyaltySale modifier to the item. The loyalty sale modifiers are stored separately from other modifiers (such as taxes and discounts) and are only applied if the loyalty card button has been pressed.

#### Testing
The loyalty sale functionality is tested in a test suite named ApplicationObjective in the tests package. The tests cover scenarios such as:

Activating and deactivating the loyalty sale prices with the loyalty card button
Applying the loyalty sale prices to items in the customer's cart
Ensuring that the loyalty sale prices are not applied to items for the next customer
The tests use ScalaTest and can be run from an IDE or the command line using the sbt test command.






