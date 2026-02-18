# ShopForHome – Backend (Spring Boot + MySQL)

ShopForHome is a backend application for an online home décor store, built using **Spring Boot** and **MySQL**.  
The project was initiated to help a physical store move to an online platform after offline shopping was disrupted.

This repository currently contains the **core backend setup and database foundation**.  
The project is under active development and features will be added incrementally in sprints.

---

## 🛠 Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA (Hibernate)
- Spring Security (basic configuration)
- MySQL
- Maven (with Maven Wrapper)
- Git & GitHub

---

## 📁 Project Structure
```
shopforme-core/
│
├── src/main/java/com/shopforme/core
│ ├── entity
│ ├── repository
│ ├── service
│ └── config
│
├── src/main/resources
│ └── application.properties
│
├── db
│ └── schema.sql
│
├── pom.xml
├── mvnw
├── mvnw.cmd
└── .gitignore
```

## ✅ Completed Work (Sprint I)
- Spring Boot Maven project setup
- MySQL database integration
- Secure configuration using environment variables
- User entity with role-based design (USER, ADMIN)
- Hibernate auto table creation
- Database schema shared via `db/schema.sql`
- Clean Git repository with Maven Wrapper committed
- Project successfully pushed to GitHub

---

## 🔐 Environment Variables
Database credentials are **not hard-coded** and must be provided via environment variables:
```
DB_USERNAME=your_mysql_username
DB_PASSWORD=your_mysql_password
```

These can be configured in IntelliJ Run Configurations or your operating system.
---
## ▶️ Running the Application
```bash
./mvnw spring-boot:run
```

The application runs on: http://localhost:8080

Author: Obaro Aruotu
