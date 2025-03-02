package com.ToDo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    void testTaskInitialization() {
        // Expecting a task with a description and an initial 'completed' status of false.
        Task task = new Task("Read a book");
        Assertions.assertEquals("Read a book", task.getDescription(),
                "Task description should match constructor input");
        Assertions.assertFalse(task.isCompleted(),
                "New tasks should be marked as not completed by default");
    }
}
