package com.ToDo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskListTest {

    private TaskList taskList;

    @BeforeEach
    void setUp() {
        taskList = new TaskList();
    }

    @Test
    void testAddTask() {
        Task task1 = new Task("Finish homework");
        Task task2 = new Task("Wash dishes");

        // Add two tasks
        taskList.addTask(task1);
        taskList.addTask(task2);

        // Expecting the list to contain two tasks in the order added
        Assertions.assertEquals(2, taskList.size(),
                "List size should match the number of added tasks");

        // Checking the description of the first task
        Assertions.assertEquals("Finish homework",
                taskList.getHead().getTask().getDescription(),
                "First task should match the first insertion");

        // Checking the description of the second task
        Assertions.assertEquals("Wash dishes",
                taskList.getHead().getNext().getTask().getDescription(),
                "Second task should match the second insertion");
    }

    @Test
    void testMarkTaskAsCompleted() {
        Task task = new Task("Call a friend");
        taskList.addTask(task);

        // Mark the only task as completed
        taskList.markTaskAsCompleted("Call a friend");

        // Verify the task's status
        TaskList.Node headNode = taskList.getHead();
        Assertions.assertNotNull(headNode,
                "Head node should not be null after adding a task");
        Assertions.assertTrue(headNode.getTask().isCompleted(),
                "Task should be marked as completed");
    }

    @Test
    void testMarkTaskAsCompletedForNonExistentTask() {
        // Attempt to mark a task that doesn't exist
        taskList.markTaskAsCompleted("Invalid Task");

        // Expecting no changes (list is empty and no errors thrown)
        Assertions.assertEquals(0, taskList.size(),
                "List should remain empty if the task doesn't exist");
    }
}
