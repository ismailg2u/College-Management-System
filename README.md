# College Management System

## Project Overview

The **College Management System** is a robust backend application developed using **Spring Boot**. This system manages essential college data, including students, teachers, courses, and departments. Leveraging Spring Boot's powerful features, the application ensures efficient data handling, seamless CRUD operations, and scalable architecture.

## Key Features

- **Student Management**: Create, read, update, and delete student records.
- **Teacher Management**: Manage teacher information and their associated departments.
- **Course Management**: Handle course details, including activation and deactivation.
- **Department and Faculty Definitions**: Maintain metadata for faculties, departments, terms, credits, and course statuses.
- **Active Records Filtering**: Fetch active students and courses based on specific criteria.
- **RESTful APIs**: Expose endpoints for all major operations, ensuring easy integration with frontend applications.

## Technologies Used

- **Spring Boot**: Core framework for building the application.
- **Spring Data JPA**: Simplifies database interactions and repository management.
- **MariaDB**: Relational database for data storage and management.
- **Lombok**: Reduces boilerplate code with annotations for getters, setters, constructors, etc.
- **Maven**: Manages project dependencies and builds the application.
- **Hibernate**: ORM tool for mapping Java objects to database tables.
- **Jakarta Persistence**: For defining entity relationships and data mapping.

## Database Structure

The database is designed to efficiently manage and relate various entities within the college system. Below is an overview of the primary tables and their relationships:

### Tables

1. **`student`**
   - **Fields**: ID, Name, Surname, Mail, Address, PhoneNumber, Faculty, Department, Situation
   - **Description**: Stores student information and associates each student with a faculty and department.

2. **`teacher`**
   - **Fields**: ID, Name, Surname, Mail, Address, PhoneNumber, Faculty, Department, Title, Situation
   - **Description**: Manages teacher details, including their academic titles and departmental affiliations.

3. **`course`**
   - **Fields**: ID, Name, Description, Quota, Teacher, Department, Faculty, Term, Credit, Coursestatus, Situation
   - **Description**: Contains course information and links each course to a teacher, department, faculty, term, and status.

4. **`courseselection`**
   - **Fields**: ID, StudentID, CourseID, Situation
   - **Description**: Links students to the courses they have selected.

5. **`define`**
   - **Fields**: ID, definetypeID, Name, Situation
   - **Description**: Stores various definitions such as faculties, departments, terms, etc.

6. **`definetype`**
   - **Fields**: ID, Name, Situation
   - **Description**: Categorizes the definitions in the `define` table (e.g., faculty, department, term).

### Entity Relationships

- **Student ↔ Faculty/Department**: Many-to-One relationship.
- **Teacher ↔ Faculty/Department/Title**: Many-to-One relationship.
- **Course ↔ Teacher/Department/Faculty/Term/Coursestatus**: Many-to-One relationship.
- **CourseSelection ↔ Student/Course**: Many-to-One relationship.
- **Define ↔ DefineType**: Many-to-One relationship.

# Project Structure

```plaintext
com.college
├── controller
│   ├── CourseController.java
│   ├── CourseSelectionController.java
│   ├── DefineController.java
│   ├── DefineTypeController.java
│   ├── StudentController.java
│   └── TeacherController.java
├── entity
│   ├── Course.java
│   ├── CourseSelection.java
│   ├── Define.java
│   ├── DefineType.java
│   ├── Student.java
│   └── Teacher.java
├── repository
│   ├── CourseRepository.java
│   ├── CourseSelectionRepository.java
│   ├── DefineRepository.java
│   ├── DefineTypeRepository.java
│   ├── StudentRepository.java
│   └── TeacherRepository.java
├── service
│   ├── CourseService.java
│   ├── CourseSelectionService.java
│   ├── DefineService.java
│   ├── DefineTypeService.java
│   ├── StudentService.java
│   └── TeacherService.java
└── CollegeManagementSystemApplication.java
```

## Getting Started

### Prerequisites

- **Java Development Kit (JDK) 17 or higher**
- **Maven**: For building the project.
- **MariaDB/MySQL**: For the database.

### Installation Steps

#### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/college-management-system.git
cd college-management-system
```

#### 2. Set Up the Database
Import the provided SQL dump (college.sql) into your MariaDB/MySQL server:
```bash
mysql -u root -p -h localhost -P 3307 < college.sql
```
#### 3. Configure Application Properties
Update the src/main/resources/application.properties file with your database credentials:
```bash
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3307/universitysystem?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=your_password

# JPA / Hibernate Settings
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Naming Strategy to preserve column names
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
```


#### 4. Build and Run the Project
Use Maven to build the project and run it:
```bash
mvn clean install
mvn spring-boot:run
```
#### 5. Access the API
The application will run on http://localhost:8080.



