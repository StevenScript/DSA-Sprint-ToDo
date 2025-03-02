## Author - Steven Norris

## Date - March 2nd, 2025

# To-Do List Manager (Data Structures & Algorithms)

This project is a console-based **to-do list manager** that demonstrates the use of **arrays** and **singly linked lists** in Java. 
It allows creating multiple users, assigning them tasks, marking tasks as completed, and viewing all tasks for each user.
All functionalities have been developed and tested using a **TDD (Test-Driven Development)** approach with **JUnit 5**.

## Table of Contents

1. [Features](#features)  
2. [Technologies & Dependencies](#technologies--dependencies)  
3. [Project Structure](#project-structure)  
4. [Setup & Installation](#setup--installation)  
5. [Usage](#usage)  
6. [Testing](#testing)  
7. [TDD Approach](#tdd-approach)  
8. [License](#license)

---

## Features

1. **User Management**  
   - Create multiple users and store them in an array (up to a limit defined in code).  
   - Each user has a unique name.

2. **Task Management**  
   - Each user manages tasks using a singly linked list.  
   - Add tasks to a user’s to-do list by providing a description.  
   - Mark tasks as completed by description.  
   - View all tasks in a user’s list (pending or completed).

3. **Console-Based Menu**  
   - Main class runs a console menu allowing:  
     1. Create a new user.  
     2. Add tasks to a user.  
     3. Mark a user’s task as completed.  
     4. Print tasks for all users.  
     5. Exit.

---

## Technologies & Dependencies

- **Java 17**  
- **Maven** for build and dependency management.  
- **JUnit 5** for unit testing.  
- **Lombok** to reduce boilerplate (constructors, getters, setters).

Key dependencies are specified in the `pom.xml`:

```xml
<dependencies>
    <!-- JUnit 5 for TDD -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>5.9.3</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-engine</artifactId>
        <version>5.9.3</version>
        <scope>test</scope>
    </dependency>

    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.28</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

---

## Project Structure

```
├─ src
│  ├─ main
│  │  ├─ java
│  │  │  └─ com/example/todo
│  │  │     ├─ Main.java
│  │  │     ├─ Task.java
│  │  │     ├─ TaskList.java
│  │  │     └─ User.java
│  │  └─ resources
│  └─ test
│     └─ java
│        └─ com/example/todo
│           ├─ TaskTest.java
│           ├─ TaskListTest.java
│           ├─ UserTest.java
│           └─ MultipleUsersTest.java
├─ pom.xml
└─ README.md
```

- **`Task.java`**: Represents a single task with description and completion status.  
- **`TaskList.java`**: A singly linked list for storing `Task` objects (each node references the next).  
- **`User.java`**: Associates a user name with a `TaskList`.  
- **`Main.java`**: Contains a console menu for user interactions (create users, add tasks, etc.).  
- **Test Classes**: Each class (Task, TaskList, User) has its own test, plus an integration test (`MultipleUsersTest`).

---

## Setup & Installation

1. **Clone** or **Download** the repository.  
2. **Open** the project in an IDE that supports Maven (e.g., IntelliJ, Eclipse, VS Code with Maven extension).  
3. **Check** that Lombok is supported in the IDE. Enabling Lombok annotations might require a plugin or additional IDE settings.

---

## Usage

1. Run the **Main** class:

   ```bash
   mvn clean compile
   mvn exec:java -Dexec.mainClass="com.example.todo.Main"
   ```
   Or run `Main.java` directly in the IDE.

2. **Menu Options**:
   1. **Create a new user**: Prompts for user name.  
   2. **Add a task to a user**: Prompts for user name, then asks for task description.  
   3. **Mark a user’s task as completed**: Searches for a task description in that user’s task list and marks it.  
   4. **Print all tasks**: Displays tasks for each user, showing `[Completed]` or `[Pending]`.  
   5. **Exit**: Ends the console loop.

---

## Testing

### TDD Approach
1. Run **unit tests** using JUnit 5:

   ```bash
   mvn clean test
   ```

2. The test classes cover:
   - **TaskTest**: Checks `Task` initialization and completion status.  
   - **TaskListTest**: Validates singly linked list operations (add, mark complete).  
   - **UserTest**: Ensures the `User` class associates tasks with users properly.  
   - **MultipleUsersTest**: Confirms multiple users handle tasks independently using an array.
