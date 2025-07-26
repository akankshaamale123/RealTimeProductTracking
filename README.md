🛒 Real-Time Product Monitoring and Alert System

The Real-Time Product Monitoring and Alert System is a web-based platform designed to streamline grocery and retail inventory operations. 
It helps store admins and customers manage product expiry, low stock alerts, order processing, and digital wallet payments in real time. 
This system improves efficiency, reduces waste, and supports seamless shopping experiences for small to medium-sized vendors.


👨‍💼 Admin Panel
- Manage product categories and seller/customer records.
- Add, update, and monitor products with expiry and stock details.
- Approve wallet top-ups and view payment records.
- Get alerts for low stock and near-expiry products.
- Generate reports on inventory, orders, and transactions.

🛍️ User Dashboard
- Register/login and view order history.
- Add products to cart and place orders using wallet balance.
- Upload receipts for wallet top-up requests.
- Receive alerts on product expiry and order updates.


🧱 System Architecture

The system consists of three main user types:
- Admin– Full control over users, inventory, orders, and alerts.
- Seller (optional scope)– Manages products and stock levels.
- Customer – Browses products, manages wallet, places orders.

System Modules:
- Inventory Monitoring Engine
- Expiry Detection Logic
- Wallet Management System
- Cart & Order Processor
- Email Notification Service

---

⚙️ Tech Stack

| Layer       | Technology                            |
|-------------|----------------------------------------|
| Frontend    | HTML5, CSS3, JavaScript, Bootstrap 5   |
| Backend     | Java EE (Servlets, JSP, JSTL), Spring Boot |
| Database    | MySQL Cloud DB with JDBC               |
| Server      | Apache Tomcat                          |
| Tools       | Eclipse IDE 2024.06, Git               |
| Notifications | Email Service (for alerts)           |


📈 Benefits

- 🔔 Automated Alerts for low stock and expiry products.
- 💳 Wallet System for quick and traceable transactions.
- 🔐 Role-Based Access for admin and users.
- 📦 Real-Time Stock Updates for all products.
- 📊 Dashboard Analytics for orders and stock.


📚 Modules Implemented

- Role-Based Authentication (Admin/User)
- Category & Product Registration
- Expiry Date Monitoring
- Minimum Stock Alerts
- Digital Wallet with Receipt Verification
- Cart & Order Management
- Admin and User Reporting Dashboards


📦 Future Enhancements

- 📱 Mobile App for Android/iOS  
- 🤖 AI-Based Stock Forecasting  
- 🌐 Multi-Store Vendor Integration  
- 🚚 Delivery Tracking API Integration  
- 🧠 OCR for Receipt Verification  
- 📊 Graphical Sales & Inventory Dashboards  
- 🔐 OTP-based Wallet Security  

⚙️ Local Setup & Deployment

> Prerequisites:
- JDK 17+
- Apache Tomcat 9+
- MySQL 8+
- Eclipse IDE (or IntelliJ)
- Git

🧾 Steps to Run the Project

```bash
# 1. Clone the repository
git clone https://github.com/yourusername/product-monitoring-system.git
cd product-monitoring-system

# 2. Import into Eclipse IDE
# File → Import → Existing Maven Project (if using Spring Boot)

# 3. Set up the MySQL database
# Import the provided SQL schema into MySQL

# 4. Configure DB credentials in application.properties (Spring Boot) or web.xml (JSP)

# 5. Deploy on Apache Tomcat Server

# 6. Access the application via
http://localhost:8080/RealTimeProductMonitor

This project is developed as part of the final year academic thesis for the Department of Computer Science & Engineering at P.R. Pote College of
Engineering and Management, Amravati.


👩‍💻 Developed By
Akanksha Amale
B.E. Computer Science & Engineering
PRPCEM, Amravati (2024–25)
Guided by: Prof. [Guide Name Here]

