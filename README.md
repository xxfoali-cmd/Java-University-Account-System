# Java-University-Account-System

A Java console-based **Account Management System** developed as a CS102 project. The application demonstrates core **Object-Oriented Programming (OOP)** concepts by managing different types of university users, including students, faculty members, and support and services employees.

## Features

- User registration and sign-in
- Multiple account types:
  - Student
  - Faculty
  - Support and Services Employee
- Username validation
- Password validation
- Date-of-birth validation
- User profile management
- Password changes
- Student award management
- Award sorting by name and date
- File-based user data storage
- Automatic loading and saving of user accounts
- Sign-in attempt limitation

## Object-Oriented Programming Concepts

The project demonstrates several important Java OOP concepts:

- **Inheritance**
- **Polymorphism**
- **Encapsulation**
- **Abstraction**
- **Method overriding**
- **Interfaces through `Comparable`**
- **Collections and `ArrayList`**
- **Comparators and sorting**
- **Exception handling**
- **File input/output**

## Class Structure

```text
Person
├── Students
└── Employee
    ├── Faculty
    └── SupportAndServicesEmployee

Award
Main
```

### `Person`

The abstract base class for users in the system. It stores common information such as:

- First name
- Surname
- Username
- Password
- Date of birth

### `Students`

Extends `Person` and adds:

- Major
- Academic status
- Awards

Students can add awards and sort them by name or date.

### `Employee`

Extends `Person` and adds:

- Department
- Office number

### `Faculty`

Extends `Employee` and adds:

- Academic rank
- Specialization

Supported faculty ranks include:

- Lecturer
- Assistant Professor
- Associate Professor
- Professor

### `SupportAndServicesEmployee`

Extends `Employee` and adds a job description.

### `Award`

Represents an award belonging to a student.

Each award contains:

- Award name
- Issuer
- Date

Awards can be sorted using Java's `Comparable` and `Comparator` functionality.

### `Main`

Contains the console interface and controls the main application workflow, including:

- Sign up
- Sign in
- Student menu
- User menu
- Awards menu
- Loading users from a file
- Saving users to a file

## Main Menu

When the application starts, the following menu is displayed:

```text
==== PSU SYSTEM MENU ====
1. Sign Up
2. Sign In
3. Exit
```

Users can register as a student, faculty member, or support and services employee.

## Student Features

After signing in, students can:

```text
1. Show Info
2. Change First Name
3. Change Password
4. Awards Menu
5. Logout
```

The Awards Menu allows students to:

```text
1. Add Award
2. Show All Awards
3. Back to Student Menu
```

Awards can also be sorted by:

- Name ascending
- Name descending
- Date ascending
- Date descending

## Input Validation

The application validates several types of user input.

### Username

A username:

- Cannot be empty
- Must start with a letter
- Can contain only letters and numbers
- Must be unique

### Password

A password must:

- Be at least 6 characters long
- Contain an uppercase letter
- Contain a lowercase letter
- Contain a digit
- Contain a special character

### Date

Dates use the following format:

```text
dd/mm/yyyy
```

## Data Storage

User accounts are stored locally in:

```text
users.txt
```

The application loads existing users when it starts and saves registered users before the program exits.

The stored account types are represented as:

```text
Student|...
Faculty|...
Support|...
```

## Technologies

- Java
- Java Collections Framework
- File I/O
- Apache Ant
- NetBeans IDE

## Requirements

- JDK 23
- Apache Ant
- NetBeans IDE (recommended)

## Running the Project

### Using NetBeans

1. Clone or download this repository.
2. Open NetBeans.
3. Select **File → Open Project**.
4. Select the project folder.
5. Build the project.
6. Run the application.

### Using Ant

From the project directory, you can build the project with:

```bash
ant
```

## Project Structure

```text
CS102-Account-Management-System/
├── src/
│   └── project/
│       └── cs102/
│           └── account/
│               └── management/
│                   └── system/
│                       ├── Award.java
│                       ├── Employee.java
│                       ├── Faculty.java
│                       ├── Main.java
│                       ├── Person.java
│                       ├── Students.java
│                       └── SupportAndServicesEmployee.java
├── nbproject/
├── build.xml
├── manifest.mf
└── README.md
```

## Educational Purpose

This project was created as part of a **CS102 programming course** to practice Java programming and Object-Oriented Programming concepts.

The primary focus is on designing class hierarchies, validating user input, working with collections, implementing sorting, handling files, and building an interactive console application.

## Security Note

This project is intended for educational purposes only.

The password-handling implementation is not suitable for a production authentication system. A real application should use secure password hashing algorithms such as **Argon2**, **bcrypt**, or **PBKDF2**, rather than reversible encryption.

User data files containing passwords or personal information should also **not be committed to a public GitHub repository**.

## License

This project is intended for educational use.
