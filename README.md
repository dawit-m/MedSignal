# 🏥 MedSignal: Pharmacy Medicine Availability System

### 📌 Project Overview

**PharmaConnect** is a professional Java-based Web Application designed to solve a critical healthcare gap in Ethiopia: **medicine accessibility**. It provides a centralized digital bridge where pharmacies manage inventory and patients find life-saving medications instantly.

> **Architecture:** Built using **Spring Boot**, following the **MVC (Model-View-Controller)** design pattern.

---

### 🚀 Key Features

- **🏢 Pharmacy Ecosystem:** Secure registration and login for pharmacy owners.
- **💊 Smart Inventory:** Medicine posting with price, quantity, and expiry tracking.
- **🔍 Intelligent Search:** Patient-facing search with Case-Insensitive Keyword Matching.
- **📈 Demand Tracking:** Logic to track "Search Counts" to see which medicines are most needed.
- **📱 Universal Access (USSD):** Integrated logic for a text-based menu (simulating `*881#`).
- **📍 Geo-Location:** Integration with Google Maps for pharmacy navigation.

---

### 🛠️ Technical Stack & OOP Implementation

- **Language:** Java 21
- **Framework:** Spring Boot
- **Database:** MySQL
- **Frontend:** HTML5, CSS3, and Thymeleaf

**OOP Concepts Used:**

- **Encapsulation:** Using Private fields and Public Getters/Setters.
- **Relationships:** **One-to-Many** relationship between Pharmacies and Medicines.
- **Abstraction:** Using Repository Interfaces for database communication.

---

### 📂 Project Structure

- **Entity:** Defines the Database Models.
- **Repository:** The bridge between Java and MySQL.
- **Service:** The "Brain" for search logic and popularity tracking.
- **Controller:** Manages URLs and User requests.
- **Templates:** The HTML User Interface.

---

### ⚙️ Installation

1. Create a MySQL schema named `pharma_app`.
2. Update `application.properties` with your MySQL credentials.
3. Run `PharmaappApplication.java`.
4. Access at `http://localhost:8080`.

---
