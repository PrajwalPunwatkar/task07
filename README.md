# 📝 Task Management REST API

A complete Spring Boot REST API for managing tasks, built to demonstrate clean architecture, CRUD operations, JSON data exchange, and in‑memory persistence with H2.  
This project is perfect for learning backend development, showcasing portfolio work, or serving as a starter template for larger applications.

---

## 📖 Table of Contents
- About the Project
- Features
- Tech Stack
- Project Structure
- Getting Started
- Testing
- Running Unit Tests
- Test Coverage

---

## 📌 About the Project

This API allows you to **create, read, update, and delete tasks** via HTTP requests.  
It follows REST principles, uses JSON for data exchange, and is backed by an H2 in‑memory database for quick setup and testing.

**Why I built it:**
- To practice building robust, well‑documented REST APIs in Java/Spring Boot.
- To demonstrate clean layering: Controller → Service → Repository.
- To provide a reproducible, easy‑to‑run backend project for others to learn from.

---

## ✨ Features

- **CRUD Operations**: Create, Read, Update, Delete tasks.
- **JSON API**: Request and response bodies in JSON format.
- **In‑Memory Database**: H2 for zero‑config persistence during development.
- **Layered Architecture**: Separation of concerns for maintainability.
- **Testable**: Works with curl, Postman, or any HTTP client.
- **H2 Console**: Web UI to inspect and query the database.

---

## 🛠 Tech Stack

- **Language**: Java 17
- **Framework**: Spring Boot 3.x
- **Dependencies**:
  - Spring Web
  - Spring Data JPA
  - H2 Database
- **Build Tool**: Maven
- **Testing Tools**: curl, Postman

---

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Maven 3.8+
- Git

## 🛠️ curl tests (execute in terminal)

1. Create a task
    ```bash
    Invoke-RestMethod -Method Post -Uri "http://localhost:8080/api/tasks" `  
    -ContentType "application/json" `
    -Body '{"title":"Learn Spring Boot","description":"Build a REST API"}'

2. List all tasks
    ```bash
    Invoke-RestMethod -Method Get -Uri "http://localhost:8080/api/tasks"

3. List one task
    ```bash
    Invoke-RestMethod -Method Get -Uri "http://localhost:8080/api/tasks/1"

4. Update task
    ```bash
    Invoke-RestMethod -Method Put -Uri "http://localhost:8080/api/tasks/1" ` 
    -ContentType "application/json" `
    -Body '{"title":"Updated Title","description":"Updated"}'

5. Delete all tasks
    ```bash
    Invoke-RestMethod -Method Delete -Uri "http://localhost:8080/api/tasks"
    
## 🧪 Testing
  
  ### Running Unit Tests
 To run the test suite:
      ```bash
      mvn test

  ### Test Coverage
  A JaCoCo coverage report is generated automatically after tests. To view:
      ```bash
      mvn jacoco:report
      
  Open target/site/jacoco/index.html in your browser to inspect coverage metrics and ensure critical branches are covered.

