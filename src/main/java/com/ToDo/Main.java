package com.ToDo;

import java.util.Scanner;

public class Main {

    // Array to store User objects
    private static final int MAX_USERS = 5;
    private static User[] users = new User[MAX_USERS];
    private static int userCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("========== To-Do List Manager ==========");
            System.out.println("1) Create a new user");
            System.out.println("2) Add a task to a user");
            System.out.println("3) Mark a user's task as completed");
            System.out.println("4) Print all tasks for each user");
            System.out.println("5) Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    createNewUser(scanner);
                    break;
                case 2:
                    addTaskToUser(scanner);
                    break;
                case 3:
                    markUserTaskAsCompleted(scanner);
                    break;
                case 4:
                    printAllUsersTasks();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    // Prompts user for a username and creates a new User if there's space in the array
    private static void createNewUser(Scanner scanner) {
        if (userCount >= MAX_USERS) {
            System.out.println("User limit reached. Cannot create more users.");
            return;
        }
        System.out.print("Enter a new user's name: ");
        String userName = scanner.nextLine().trim();

        // Checks if a user with the same name already exists
        if (getUserIndexByName(userName) != -1) {
            System.out.println("A user with that name already exists.");
            return;
        }

        users[userCount] = new User(userName);
        userCount++;
        System.out.println("User '" + userName + "' created successfully!");
    }

    // Prompts for a user name, then adds a task description to that user's TaskList if found
    private static void addTaskToUser(Scanner scanner) {
        if (userCount == 0) {
            System.out.println("No users available. Please create a user first.");
            return;
        }

        System.out.print("Enter the user's name: ");
        String userName = scanner.nextLine().trim();
        int userIndex = getUserIndexByName(userName);

        if (userIndex == -1) {
            System.out.println("User not found.");
            return;
        }

        System.out.print("Enter the task description: ");
        String taskDescription = scanner.nextLine().trim();
        users[userIndex].addTask(taskDescription);
        System.out.println("Task added to user " + userName);
    }

    // Prompts for a user name, then marks the specified task as completed
    private static void markUserTaskAsCompleted(Scanner scanner) {
        if (userCount == 0) {
            System.out.println("No users available. Please create a user first.");
            return;
        }

        System.out.print("Enter the user's name: ");
        String userName = scanner.nextLine().trim();
        int userIndex = getUserIndexByName(userName);

        if (userIndex == -1) {
            System.out.println("User not found.");
            return;
        }

        System.out.print("Enter the task description to mark as completed: ");
        String taskDescription = scanner.nextLine().trim();
        users[userIndex].markTaskAsCompleted(taskDescription);
        System.out.println("Task marked as completed (if found).");
    }

    // Prints all tasks for every user, showing each task's description and status
    private static void printAllUsersTasks() {
        if (userCount == 0) {
            System.out.println("No users available.");
            return;
        }
        for (int i = 0; i < userCount; i++) {
            User currentUser = users[i];
            System.out.println();
            System.out.println("Tasks for " + currentUser.getName() + ":");
            TaskList.Node currentNode = currentUser.getTaskList().getHead();
            if (currentNode == null) {
                System.out.println(" - No tasks for this user.");
            } else {
                while (currentNode != null) {
                    Task task = currentNode.getTask();
                    String status = task.isCompleted() ? "Completed" : "Pending";
                    System.out.println(" - " + task.getDescription() + " [" + status + "]");
                    currentNode = currentNode.getNext();
                }
            }
        }
    }

    // Returns the index of the user in the array if found; otherwise returns -1
    private static int getUserIndexByName(String name) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }
}