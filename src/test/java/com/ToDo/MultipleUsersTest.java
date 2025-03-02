package com.ToDo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MultipleUsersTest {

    @Test
    void testMultipleUsersManagement() {
        // Create an array of 3 users
        User[] users = new User[3];
        users[0] = new User("Steve");
        users[1] = new User("Mary");
        users[2] = new User("Oscar");

        // Add tasks to Steve
        users[0].addTask("Buy milk");
        users[0].addTask("Pay bills");

        // Add tasks to Mary
        users[1].addTask("Study data structures");

        // Mark one of Steve's tasks as completed
        users[0].markTaskAsCompleted("Buy milk");

        // Verify Steve's tasks
        Assertions.assertEquals(2, users[0].getTaskList().size(),
                "Steve should have 2 tasks total");
        Assertions.assertTrue(
                users[0].getTaskList().getHead().getTask().isCompleted(),
                "Steve's 'Buy milk' task should be marked as completed"
        );

        // Verify Mary's tasks
        Assertions.assertEquals(1, users[1].getTaskList().size(),
                "Mary should have 1 task");
        Assertions.assertFalse(
                users[1].getTaskList().getHead().getTask().isCompleted(),
                "Mary's task should still be pending"
        );

        // Oscar has no tasks
        Assertions.assertEquals(0, users[2].getTaskList().size(),
                "Bob should have no tasks yet");
    }
}
