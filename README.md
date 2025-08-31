# StudySpot - Empty Classroom Finder

This is a simple Spring Boot application that provides a REST API to find available classrooms based on a given day and time. It is designed to be used with a web frontend to help students quickly locate empty rooms for study sessions.

## 🚀 Features

* **RESTful API:** Provides an endpoint to query for available classrooms.
* **Efficient Logic:** Uses a hash set data structure for fast lookup of occupied classrooms.
* **Database Integration:** Connects to a MySQL database to retrieve classroom schedules.
* **Web Frontend:** A simple HTML, CSS, and JavaScript interface for user interaction.

---

## 🛠️ Tech Stack

* **Backend:** Java 23, Spring Boot 3.5.3, Spring Data JPA
* **Database:** MySQL
* **Frontend:** HTML, CSS, JavaScript (Vanilla)

---

## 🔧 Setup and Installation

### 1. Database Setup

First, ensure you have a MySQL database running. The application expects a table named `classroom_timetable`. You can create this table and import your CSV data into it.

Your database table should have the following columns to match the `ClasRoom` entity:

| Column Name | Data Type | Description |
| :--- | :--- | :--- |
| `id` | `BIGINT` | Primary Key, auto-increment |
| `classroom` | `VARCHAR` | The room number (e.g., "4004") |
| `day` | `VARCHAR` | Day of the week (e.g., "Monday") |
| `time_slot` | `VARCHAR` | The time range (e.g., "09:00 - 10:00") |
| `class_info` | `VARCHAR` | The name of the class |

### 2. Backend Configuration

Update the `src/main/resources/application.properties` file with your MySQL database credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name?createDatabaseIfNotExist=true
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
