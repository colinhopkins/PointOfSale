# Self Checkout Kiosk

Welcome to the self checkout kiosk project! This project aims to develop software for a self checkout kiosk without the use of conditionals. The user/customer will input the numeric barcode for each item they want to purchase, and the items will be displayed along with their prices.

<img width="524" alt="Screenshot 2023-03-09 at 4 40 00 PM" src="https://user-images.githubusercontent.com/111472051/224166271-d88d1737-264c-483c-a169-96281638a47c.png">

## Objectives

The main objectives of this project are:

Develop software for a self checkout kiosk
Apply object-oriented programming concepts
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

## Features

The program includes the following features:

Scanning items: Customers can scan items by typing in the barcode number and pressing enter. The program will then display the name and price of the item with tax applied. If there are any sales for that item it will automatically display.

Adding items to the cart: Once an item has been scanned, it is added to the customer's cart and the total cost is updated.

Clearing the cart: Customers can clear their cart at any time by pressing the "clear" button. This will remove all items from the cart and reset the total cost to zero.

Viewing the cart: Customers can view the items in their cart at any time by pressing the "view cart" button. The program will display the name, price, and quantity of each item, as well as the total cost.

Paying with cash: When the customer is ready to pay, they can press the "checkout" button. The program will then display the total cost and ask the customer to enter the amount of cash they are paying with. If the customer pays with more cash than the total cost, the program will calculate the change and display it.

Paying with credit: Customers can also pay with a credit card by pressing the "credit" button. The program will then display the total cost and ask the customer to swipe their credit card. If the transaction is approved, the program will display a message confirming the payment.

Loyalty card: Customers can enter their loyalty card number at any time by pressing the "loyalty card" button. This will apply any discounts or promotions associated with their card.

Rescanning items: Customers can rescan an item by pressing enter immediately after scanning the item. This will add another of the same item to the cart.

Error item: If no item has been scanned by this customer yet, or the clear button was pressed after the last item was scanned, the program will add an "error" item with a price of 0.0 to the cart.

### Loyalty Sale Functionality

This project implements a loyalty sale functionality for a self-checkout kiosk. Customers can enter a loyalty program card, which activates a sale price for certain items. The sale price is a percentage discount specified for each item type.

#### Usage

To use the loyalty sale functionality, customers need to press the loyalty card button before scanning any items. Once the button is pressed, the sale prices will be activated for all purchases of the relevant item types, even if they were scanned before the button was pressed. Customers can then scan items as usual, and the loyalty sale prices will be reflected in the item prices.

Note that the loyalty sale prices are not applied to the base price of the items. Instead, they are applied as a separate modifier that is added to the price if the loyalty card button has been pressed.
