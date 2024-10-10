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

## Spring Boot Integration

This project extensively utilizes Spring Boot's capabilities to create a maintainable and scalable backend system.

### 1. Spring Data JPA

- **Repository Management**: Leveraged `JpaRepository` for CRUD operations without boilerplate code.
- **Custom Queries**: Implemented method naming conventions and JPQL for specific data retrieval and updates.

  ```java
  @Repository
  public interface StudentRepository extends JpaRepository<Student, Integer> {
      List<Student> findBySituation(int situation);
      
      @Modifying
      @Transactional
      @Query("UPDATE Student s SET s.situation = 1 WHERE s.id = :studentId AND s.situation = 0")
      void activateStudentById(@Param("studentId") int studentId);
  }
