package com.ToDo;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
@Getter
@AllArgsConstructor
public class Task {
    // Holds the task description
    @Setter
    private String description;

    // Holds the completion status
    private boolean completed;

    // Sets completed to false by default
    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    // Marks this task as completed
    public void markAsCompleted() {
        this.completed = true;
    }
}
