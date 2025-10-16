# 🚗 Workshop 1 - Automobile Management System

A Java Web Application demonstrating CRUD operations with JSP, Servlet, and SQL Server following the MVC architecture pattern.

[![Java](https://img.shields.io/badge/Java-8-orange.svg)](https://www.oracle.com/java/)
[![Tomcat](https://img.shields.io/badge/Tomcat-9.0.108-yellow.svg)](https://tomcat.apache.org/)
[![SQL Server](https://img.shields.io/badge/SQL%20Server-2019-red.svg)](https://www.microsoft.com/sql-server/)

---

## 📄 Assignment Document

**⚠️ READ THE ASSIGNMENT FIRST**

The complete workshop requirements, database schema, and UI mockups are in:

📁 **[`docs/Workshop_01_AutomobileManagement.pdf`](docs/Workshop_01_AutomobileManagement.pdf)**

This document contains:
- ✅ Detailed requirements and objectives
- ✅ Database schema (MyStock database, Cars table)
- ✅ Complete UI mockups for all pages
- ✅ Expected functionality descriptions

**Start by reading the PDF to understand what you need to build.**

---

## 🎯 Quick Start

### What This Repository Contains

This is a **sample solution** for the Workshop 1 assignment. It demonstrates:

- ✅ Complete CRUD operations (Create, Read, Update, Delete)
- ✅ MVC architecture (Model-View-Controller)
- ✅ Front Controller pattern with MainController
- ✅ JDBC database connectivity
- ✅ JSP views with JSTL

**Purpose:** Educational reference for students learning Java web development.

---

## 🛠 Technologies Used

| Technology | Version | Purpose |
|------------|---------|---------|
| Java | 8 | Backend language |
| Apache Tomcat | 9.0.108 | Servlet container |
| SQL Server | 2019 | Database |
| JSP & Servlet | 3.1 | Web framework |
| JSTL | 1.2 | Tag library |
| MSSQL JDBC Driver | 9.4.1 | DB connectivity |

---

## 📦 Prerequisites

Install these before running the project:

1. **JDK 8** - [Download](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
2. **Apache Tomcat 9.0.108** - [Download](https://tomcat.apache.org/download-90.cgi)
3. **SQL Server 2019** - [Download](https://www.microsoft.com/sql-server/sql-server-downloads)
4. **SSMS** (optional but recommended) - [Download](https://docs.microsoft.com/sql/ssms/download-sql-server-management-studio-ssms)
5. **NetBeans IDE 13** (recommended) - [Download](https://netbeans.apache.org/download/)

---

## 🚀 Installation & Setup

### Step 1: Clone Repository
```bash
git clone https://github.com/LordV4D3R/WorkShop1_KiemHH.git
cd workshop1-automobile-management
```

### Step 2: Setup Database

#### Option A: Use SQL Script (Recommended)
```bash
# Execute the provided SQL script
database/MyStock-Create.sql
```

#### Option B: Manual Setup
```sql
-- 1. Create Database
CREATE DATABASE MyStock;
GO

USE MyStock;
GO

-- 2. Create Table
CREATE TABLE Cars (
    carID INT PRIMARY KEY,
    carName NVARCHAR(100) NOT NULL,
    manufacturer NVARCHAR(100) NOT NULL,
    price FLOAT NOT NULL,
    releasedYear INT NOT NULL
);
GO

-- 3. Insert Sample Data
INSERT INTO Cars VALUES
(1, 'Accord', 'Honda Motor Company', 24970.0, 2021),
(2, 'Civic', 'Honda Motor Company', 21250.0, 2021),
(3, 'Camry', 'Toyota Motor Corporation', 25965.0, 2021),
(4, 'Corolla', 'Toyota Motor Corporation', 20425.0, 2021),
(5, 'Model 3', 'Tesla, Inc.', 39990.0, 2021);
GO
```

### Step 3: Configure Database Connection

Edit `src/java/utils/DBUtils.java`:
```java
public class DBUtils {
    private static final String DB_NAME = "MyStock";
    private static final String DB_USER_NAME = "SA";          // ← Change this
    private static final String DB_PASSWORD = "your_password"; // ← Change this
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=" + DB_NAME;
        conn = DriverManager.getConnection(url, DB_USER_NAME, DB_PASSWORD);
        return conn;
    }
}
```

**Configuration Notes:**

- For **SQL Server Express**: Use `localhost\\SQLEXPRESS` instead of `localhost`
- For **Windows Authentication**: Add `;integratedSecurity=true;` to URL and remove username/password
- For **Custom Port**: Change `1433` to your port number

### Step 4: Import to NetBeans

1. Open NetBeans IDE
2. `File` → `Open Project`
3. Select the cloned folder
4. Right-click project → `Resolve Problems` (if any)
5. Add required JARs to Libraries:
   - `jstl-1.2.jar`
   - `mssql-jdbc-9.4.1.jre8.jar`

### Step 5: Configure Tomcat

1. `Tools` → `Servers` → `Add Server`
2. Select Apache Tomcat
3. Browse to Tomcat installation folder
4. Finish

---

## ▶️ How to Run

1. **Start SQL Server** (ensure service is running)
2. **Clean and Build** project in NetBeans
3. **Run** the project (F6 or Right-click → Run)
4. Browser opens automatically at:
```
http://localhost:8080/WorkShop1/MainController
```

---

## 📁 Project Structure
```
src/java/
├── controllers/              # 🎮 Servlets (Controller Layer)
│   ├── MainController.java       # Front controller - routes all requests
│   ├── LoadCarController.java    # View all cars
│   ├── CarDetailController.java  # View details + route to edit/delete
│   ├── AddCarController.java     # Create new car
│   ├── UpdateCarController.java  # Update car info
│   └── DeleteCarController.java  # Delete car
│
├── models/                   # 📊 Business Logic (Model Layer)
│   ├── CarDTO.java               # Data Transfer Object
│   └── CarDAO.java               # Database operations (CRUD)
│
└── utils/                    # 🔧 Utilities
    └── DBUtils.java              # Database connection manager

web/
├── car_management.jsp        # View: List all cars
├── car_detail.jsp            # View: Car details
├── car_update.jsp            # View: Edit car form
├── add_new_car.jsp           # View: Add car form
└── car_delete.jsp            # View: Delete confirmation
```

### MVC Flow Diagram
```
User Request → MainController → Specific Controller → DAO → Database
                                       ↓
User Browser ← JSP View ← setAttribute ← Return Data
```

---

## 🔄 Request Flow Example

**Example: Viewing Car List**

1. User accesses: `http://localhost:8080/WorkShop1/MainController`
2. `MainController` checks action parameter (null = default)
3. Forwards to `LoadCarController`
4. `LoadCarController` calls `CarDAO.getAllCars()`
5. `CarDAO` queries database via JDBC
6. Returns `List<CarDTO>` to controller
7. Controller sets `LIST_CAR` attribute
8. Forwards to `car_management.jsp`
9. JSP displays data using JSTL `<c:forEach>`

---

## 🔧 Common Issues & Solutions

### ❌ ClassNotFoundException: SQLServerDriver

**Solution:**
```
1. Check mssql-jdbc-9.4.1.jre8.jar is in WEB-INF/lib/
2. Right-click Libraries → Add JAR/Folder
3. Clean and Build project
```

### ❌ SQLException: Login failed

**Solution:**
```
1. Check SQL Server Authentication is enabled (Mixed Mode)
2. Verify username/password in DBUtils.java
3. Restart SQL Server service
```

### ❌ HTTP 404 - Not Found

**Solution:**
```
1. Check Tomcat started successfully
2. Verify URL: http://localhost:8080/WorkShop1/MainController
3. Check deployment in Tomcat manager
```

### ❌ Connection Timeout

**Solution:**
```
1. Enable TCP/IP in SQL Server Configuration Manager
2. Check firewall allows port 1433
3. Start SQL Server Browser service
```

### ❌ Empty Car List

**Solution:**
```sql
-- Verify database has data
USE MyStock;
SELECT * FROM Cars;

-- If empty, run sample data insert
INSERT INTO Cars VALUES
(1, 'Accord', 'Honda Motor Company', 24970.0, 2021),
(2, 'Civic', 'Honda Motor Company', 21250.0, 2021);
```

**Check Logs:**
- NetBeans Output window
- Tomcat logs: `tomcat/logs/catalina.out`
- SQL Server error log in SSMS

---

## ⚠️ IMPORTANT: Academic Integrity

### 🚨 READ THIS BEFORE USING

This code is **FOR EDUCATIONAL REFERENCE ONLY**.

### ✅ ALLOWED:
- Study and understand the code
- Learn MVC and CRUD concepts
- Use as reference when stuck
- Analyze architecture patterns

### ❌ PROHIBITED:
- Copy-paste for assignments
- Submit as your own work
- Share with classmates as solution
- Use without understanding

### 📚 Proper Usage:

1. **Read assignment PDF first** (`docs/Workshop_01_AutomobileManagement.pdf`)
2. **Attempt to build yourself** from scratch
3. **When stuck** → Look at relevant code section
4. **Understand the logic** → Close this code
5. **Implement in your own way**

### ⚖️ Consequences of Plagiarism:

- ❌ Zero on assignment
- ❌ Course failure
- ❌ Academic probation
- ❌ Permanent academic record

**Remember:** *Understanding > Grades*

---

## 🎓 Learning Objectives

Study this project to understand:

✅ MVC architecture in Java web apps  
✅ Front Controller pattern  
✅ CRUD operations with JDBC  
✅ JSP + JSTL for dynamic views  
✅ PreparedStatement (SQL injection prevention)  
✅ DAO and DTO patterns  
✅ Request/Response handling in Servlets  
✅ Database connection management  

---

## 📖 Additional Resources

- **Assignment PDF**: [`docs/Workshop_01_AutomobileManagement.pdf`](docs/Workshop_01_AutomobileManagement.pdf)
- **SQL Script**: [`database/MyStock-Create.sql`](database/MyStock-Create.sql)
- **Java EE Tutorial**: [Official Docs](https://javaee.github.io/tutorial/)
- **JDBC Guide**: [Oracle JDBC](https://docs.oracle.com/javase/tutorial/jdbc/)
- **JSP Specification**: [Jakarta EE](https://jakarta.ee/specifications/pages/)

---

## 👨‍💻 Credits

**Created by:** MindyCoding by TranAn aka Forty3

**Purpose:** Educational sample for teaching Java Web Development

**Institution:** FPT University - Java Web Development Course

**Contact:** antran4work@gmail.com

**Repository:** https://github.com/LordV4D3R/WorkShop1_KiemHH.git

---

## 📜 License

**Educational Use Only**

Copyright © 2025 MindyCoding by Tran. All rights reserved.

**Terms:**
- ✅ Study and learn
- ✅ Educational reference
- ❌ Commercial use prohibited
- ❌ Assignment submission prohibited
- ❌ Redistribution without credit prohibited

---

## 🙏 Acknowledgments

- FPT University - Workshop Assignment
- Java EE Community
- Apache Tomcat Project
- Microsoft SQL Server Documentation

---

**Happy Learning! 🎓**

*"The best way to learn is to build it yourself."*

---

**Made with ❤️ for education by MindyCoding**