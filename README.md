## Hi there 👋

### Student Management System (SMS)

A desktop-based **Student Management System** built using **Java Swing** and **Hibernate ORM**, designed with a clean layered architecture.

This project demonstrates how to build a real-world application with proper separation of concerns, validation handling, and scalable design patterns.

---

### Features

#### Student Management

* Add new students
* Update existing student records
* Delete students
* View all students in a structured table

### Course Management

* Add, update, and delete courses
* Reusable form dialogs for CRUD operations

### Authentication

* Role-based login system *(Admin / Staff / Student)*

### Validation & Error Handling

* Multi-layer validation (**UI + Service**)
* Custom exception handling system
* User-friendly error feedback in UI

---

### Tech Stack

| Layer      | Technology    |
| ---------- |---------------|
| Language   | Java (JDK 22) |
| UI         | Java Swing    |
| ORM        | Hibernate     |
| Database   | PostgreSQL    |
| Build Tool | Maven         |

---

### Architecture

This project follows a **layered architecture pattern**:

```text
UI → Controller → Service → DAO → Database
```

### 🔹 Layer Responsibilities

* **UI Layer**

    * Handles user interaction (Swing Panels & Dialogs)

* **Controller Layer**

    * Receives UI input and coordinates application flow

* **Service Layer**

    * Contains business logic and validation rules

* **DAO Layer**

    * Manages database operations using Hibernate

* **DTO Pattern**

    * Ensures safe data transfer between layers
    * Prevents lazy loading issues and tight coupling

---

### Project Structure

```text
me.nimeshdev.sms-demo
│
├── ui/              # Swing UI (Panels, Dialogs)
├── controller/      # Handles UI requests
├── service/         # Business logic
├── dao/             # Database operations
├── model/           # Entities (Student, Course)
  ├── embedded/        # Hibernate embedded property classes
  └── enums/           # Enumerations for models (Role)
├── dto/             # Data Transfer Objects
├── exception/       # Custom exceptions
├── session/         # Manage Sessions (logged in session)
├── config/          # Hibernate configuration
└── util/            # Utility classes
```

---

##  Setup & Run

### `[1]` Clone the Repository

```bash
git clone https://github.com/Sachi-404/me.nimesh.sms
```

### `[2]` Configure Database

* Create a database (e.g., `me.nimeshdev.sms-demo`)
* Update `hibernate.cfg.xml`:

    * hibernate.connection.driver_class
    * hibernate.connection.url
    * hibernate.connection.username
    * hibernate.connection.password

### `[3]`️ Run the Application

* Execute `Main.java`
* Hibernate initializes at startup
* Login screen will be displayed

---

### Key Design Decisions

* ✔ **SessionFactory initialized at startup**
  → Eliminates first-request delay

* ✔ **DTO Pattern implemented**
  → Avoids lazy loading issues
  → Decouples UI from persistence layer

* ✔ **Custom Exception Hierarchy**
  → Clean error handling across layers

* ✔ **Reusable UI Components**
  → Dialogs reused for Add & Update operations

* ✔ **Strict Separation of Concerns**
  → Improves maintainability and scalability

---

## Future Improvements

* Role-based dashboards *(Admin / Student / Staff)*
* Enhanced UI (JavaFX or modern UI frameworks)
* Password hashing & authentication security
* Reporting & analytics dashboard

---

## Author

* *| Sachi-404 | tgsnimesh |* 

---

###  Notes

This project is developed for learning purposes and demonstrates:

* Real-world application architecture
* Hibernate ORM usage
* Clean code practices in Java desktop applications

---

### ❤️ Contributions / Feedback

Feel free to fork this project, open issues, or suggest improvements!

