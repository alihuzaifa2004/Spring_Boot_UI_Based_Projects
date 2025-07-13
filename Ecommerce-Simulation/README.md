# 🛒 Ecommerce Management System (Spring Boot)

This is a **Java Spring Boot** based simulation of an **Ecommerce Management System**. It includes a frontend using **HTML (Thymeleaf)**, backend RESTful services, and implementation of various **Data Structures** like Linked List, Queue, Graph, Array, and Binary Search Tree to manage internal operations.

---

## ✅ Features

### 👥 Customer Panel
- Register as a new customer
- View available products
- Place orders for selected products

### 🛠️ Admin Panel
- Add new products to inventory
- Maintain product catalog
- View placed orders (simulation logic)

---

## 🗂️ Project Structure

```

Ecommerce-Simulation/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.example.ecommerce/
│   │   │       ├── EcommerceSimulationApplication.java
│   │   │       ├── controller/
│   │   │       │   └── EcommerceController.java
│   │   │       ├── model/
│   │   │       │   ├── Order.java
│   │   │       │   ├── Product.java
│   │   │       │   └── User.java
│   │   │       ├── service/
│   │   │       │   └── SimulationService.java
│   │   │       └── structure/
│   │   │           ├── InventoryLinkedList.java
│   │   │           ├── OrderGraph.java
│   │   │           ├── OrderQueue.java
│   │   │           ├── ProductBST.java
│   │   │           └── UserArray.java
│   ├── resources/
│   │   ├── templates/
│   │   │   └── index.html
│   │   └── application.properties
├── pom.xml

````

---

## 🧠 Core Concepts

This project demonstrates the use of fundamental **Data Structures & Algorithms**:
- `LinkedList`: To store product inventory
- `Array`: For managing user data
- `Queue`: For order processing
- `Binary Search Tree (BST)`: For organizing product catalog
- `Graph`: To simulate order relations or dependencies

---

## 🚀 Getting Started

### 📋 Prerequisites
- Java 17+
- Maven
- Spring Boot
- Any IDE (IntelliJ / Eclipse)

### ▶️ Run the App

1. Clone the repo:
   ```bash
   git clone https://github.com/your-user/Ecommerce-Simulation.git
   cd Ecommerce-Simulation
````

2. Start SQL Server (if needed) and configure `application.properties` accordingly.

3. Build and run:

   ```bash
   mvn spring-boot:run
   ```

4. Open in browser:
   [http://localhost:8080](http://localhost:8080)

---

## 🧪 Example Use Cases

* A user opens the site, registers, and browses products.
* The admin adds new items to the system.
* The user selects a product and places an order.
* Data Structures process and simulate these actions behind the scenes.

---

## 🌐 UI Technology

* **Thymeleaf** (HTML templating engine)
* **Bootstrap** (optional: styling for UI)
* Static HTML (`index.html`) is used for front page and can be extended.

---

## 📦 Maven Dependencies

All required dependencies are listed in `pom.xml`. These include:

* Spring Boot Starter Web
* Spring Boot Starter Thymeleaf
* Lombok (if used)
* Validation and Web MVC

---

## 📌 Notes

* This is a **simulation system**, not connected to a real database unless extended.
* You can replace simulation data structures with real database operations as enhancement.
* Make sure to handle validations and edge cases for production.

---
## 👨‍🎓 Author

**Ali Huzaifa Nadeem**  
[GitHub Profile](https://github.com/alihuzaifa2004)


## 📜 License

This project is for **educational purposes** only.