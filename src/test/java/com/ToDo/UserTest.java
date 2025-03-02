package com.ToDo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("Alice");
    }

    @Test
    void testUserInitialization() {
        Assertions.assertEquals("Alice", user.getName(),
                "User name should match constructor input");
        Assertions.assertNotNull(user.getTaskList(),
                "User should have a non-null TaskList upon creation");
    }

    @Test
    void testAddTaskToUser() {
        user.addTask("Buy groceries");
        Assertions.assertEquals(1, user.getTaskList().size(),
                "User's TaskList size should be 1 after adding a single task");

        user.addTask("Read a book");
        Assertions.assertEquals(2, user.getTaskList().size(),
                "User's TaskList size should be 2 after adding another task");
    }

    @Test
    void testMarkTaskAsCompleted() {
        user.addTask("Go jogging");
        user.markTaskAsCompleted("Go jogging");

        // Checking that the first (and only) task is completed
        TaskList.Node headNode = user.getTaskList().getHead();
        Assertions.assertNotNull(headNode,
                "Head node should not be null after a task is added");
        Assertions.assertTrue(headNode.getTask().isCompleted(),
                "Task should be marked as completed");
    }
}
