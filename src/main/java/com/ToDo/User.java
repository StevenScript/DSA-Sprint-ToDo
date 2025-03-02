package com.ToDo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class User {
    @Setter
    private String name;

    private final TaskList taskList = new TaskList();

    public User(String name) {
        this.name = name;
        // TaskList is already initialized
    }

    // Adds a new task to the user's TaskList given its description
    public void addTask(String description) {
        Task newTask = new Task(description);
        taskList.addTask(newTask);
    }

    // Marks a task as completed if it matches the given description
    public void markTaskAsCompleted(String description) {
        taskList.markTaskAsCompleted(description);
    }
}
