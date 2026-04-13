# Shopping Cart Simulation

A robust, console-based retail application built in Java that demonstrates core Object-Oriented Programming (OOP) principles. The system manages a multi-category inventory, applies dynamic discounts, and simulates a multi-channel payment gateway.



## 🚀 Features

* **Categorized Inventory:** Organized products into Electronics, Clothing, Beauty, and Books using Class Inheritance.
* **Dynamic Pricing Engine:** Implements specialized discount logic for each category (e.g., 10% for Electronics, 12% for Clothing) using Method Overriding.
* **Cart Management:** Full CRUD (Create, Read, Update, Delete) functionality for managing items, quantities, and real-time total calculations.
* **Simulated Payment Gateway:** Supports multiple payment methods including:
    * **Cash on Delivery** 
    * **Credit/Debit Cards** (with 16-digit card and CVV validation).
    * **UPI Interface** 
* **Tax Calculation:** Automatic GST application (12%) during the checkout phase.

## 🛠️ Technical Highlights

* **Inheritance & Polymorphism:** Used a base `Product` class with specialized subclasses to handle category-specific behavior.
* **Data Validation:** Implemented robust input handling for mobile numbers, card details, and quantity limits.
* **Memory Management:** Managed dynamic cart sizing using array manipulation logic.

## 💻 How to Run

1. Ensure you have the Java Development Kit (JDK) installed.
2. Download `ShoppingCart.java`.
3. Compile the file:
   ```bash
   javac ShoppingCart.java
   java ShoppingCart