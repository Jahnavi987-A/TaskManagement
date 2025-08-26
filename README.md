# 📌 Task Management System

A **Spring Boot RESTful API** for managing tasks with CRUD operations, integrated with **MySQL database**, and documented using Swagger UI. It also includes a **Recommended Task Feature** that helps users prioritize tasks based on deadlines and priority.


## 🚀 Features

- ✅ Create, read, update, and delete tasks.

- ✅ Store task details: title, description, priority, status, deadline, createdAt, updatedAt.

- ✅ Recommended Task API → suggests which task should be completed next, considering earliest deadlines and highest priority.

- ✅ Swagger UI for API exploration and testing.

- ✅ Spring Data JPA + Hibernate for ORM.

- ✅ MySQL database integration for persistence.


## 🛠️ Tech Stack

**Backend**: Java 21, Spring Boot

**Database**: MySQL (via Spring Data JPA, Hibernate ORM)

**API Docs**: Swagger UI (Springdoc OpenAPI)

**Build Tool**: Maven


## ⚙️ Project Structure<br>

TaskManagement/<br>
├── src/main/java/com/example/taskmanagement/<br>
│ ├── controller/ # REST APIs<br>
│ ├── service/ # Business logic<br>
│ ├── repository/ # Data access layer<br>
│ ├── model/ # Entity classes<br>
│ ├── exceptionHandling/ # Custom exceptions & handlers<br>
│ └── TaskManagementApplication.java<br>
├── src/main/resources/<br>
│ ├── application.properties<br>
└── pom.xml<br>


## ⚙️ Installation & Setup<br>
1️⃣ Clone the repository<br>
 - git clone https://github.com/your-username/TaskManagement-SpringBoot.git<br>
 - cd TaskManagement-SpringBoot<br>



## 📖 API Endpoints

Base URL: http://localhost:8080<br>

- POST	 -       /tasks	        -     Create a new task <br>
- GET	-        /tasks	         -    Get all tasks<br>
- GET	 -       /tasks/{id}	 -    Get task by ID<br>
- PUT	 -       /tasks/{id}	-     Update a task<br>
- DELETE	-        /tasks/{id}	 -    Delete a task<br>
- GET	 -       /tasks/recommended  -  Get recommended task (next priority)<br>



## 🔍 Swagger UI

Once the app is running, open:
👉 http://localhost:8080/swagger-ui.html

Here, you can test all endpoints interactively.



## 🗄️ Database Configuration

Update your application.properties file with your MySQL credentials:

- spring.datasource.url=jdbc:mysql://localhost:3306/task_management_db
- spring.datasource.username=your_username
- spring.datasource.password=your_password
- spring.jpa.hibernate.ddl-auto=update
- spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect


## ✨ Future Improvements

- Add PATCH method for partial updates.

- Implement unit & integration tests.

- Add user authentication (Spring Security + JWT).



## 👨‍💻 Author

Developed by **Jahnavi Arthamuri** 💡<br>
[GitHub Profile](https://github.com/Jahnavi987-A)
