package com.ToDo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskedListTest {

    private TaskList taskList;

    @BeforeEach
    void setUp() {
        taskList = new TaskList();
    }

    @Test
    void testAddTask() {
        Task task1 = new Task("Finish homework");
        Task task2 = new Task("Wash dishes");

        taskList.addTask(task1);
        taskList.addTask(task2);

        // Expecting the list to contain the tasks in the order they were added.
        Assertions.assertEquals(2, taskList.size(),
                "List size should match the number of added tasks");
        Assertions.assertEquals("Finish homework", taskList.getHead().getTask().getDescription(),
                "First task should match the first insertion");
        Assertions.assertEquals("Wash dishes", taskList.getHead().getNext().getTask().getDescription(),
                "Second task should match the second insertion");
    }

    @Test
    void testMarkTaskAsCompleted() {
        Task task = new Task("Call a friend");
        taskList.addTask(task);

        // Mark the only task as completed
        taskList.markTaskAsCompleted("Call a friend");

        // Verify the task's status
        Task headTask = taskList.getHead().getTask();
        Assertions.assertTrue(headTask.isCompleted(),
                "Task should be marked as completed");
    }

    @Test
    void testMarkTaskAsCompletedForNonExistentTask() {
        // Attempt to mark a task that doesn't exist
        taskList.markTaskAsCompleted("This doesn't exist");
        // Expect no exceptions and no tasks in the list
        Assertions.assertEquals(0, taskList.size(),
                "List should remain empty if task doesn't exist");
    }
}
