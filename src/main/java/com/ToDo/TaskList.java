package com.ToDo;

import lombok.Getter;
import lombok.Setter;

public class TaskList {

    @Getter
    private Node head; // Holds the head of the list

    private int size;  // Tracks the number of tasks in the list

    // Node class to represent a single node in the list
    @Getter
    public static class Node {
        private final Task task;    // Holds the task data
        @Setter
        private Node next;    // Points to the next node in the list

        public Node(Task task) {
            this.task = task;
        }

    }

    // Adds a new task to the end of the list
    public void addTask(Task task) {
        Node newNode = new Node(task);

        // If the list is empty, this node becomes the head
        if (head == null) {
            head = newNode;
        } else {
            // Traverse to the end of the list and attach the new node
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    // Returns the current size of the list
    public int size() {
        return size;
    }

    // Searches for a task by its description and marks it as completed if found
    public void markTaskAsCompleted(String description) {
        Node current = head;
        while (current != null) {
            if (current.getTask().getDescription().equals(description)) {
                current.getTask().markAsCompleted();
                return; // Stops after marking the first match
            }
            current = current.getNext();
        }
    }
}
