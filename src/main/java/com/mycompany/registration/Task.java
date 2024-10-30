/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registration;
/**
 *
 * @author Teboho Kojoana
 */
public class Task {
    // Name of the task
    public String taskName;
    
    // Unique number assigned to the task
    public int taskNumber;
    
    // Description of the task (max length of 50 characters)
    public String taskDescription;
    
    // Name of the developer assigned to the task
    public String developerName;
    
    // Number of hours allocated to the developer for the task (private for encapsulation)
    private int developerHours;
    
    // Unique ID generated for the task
    public String taskID;
    
    // Current status of the task (e.g., "In Progress", "Completed")
    public String taskStatus;

    // Constructor to initialize a new Task instance with provided details
    public Task(String taskName, int taskNumber, String taskDescription, String developerName, int developerHours) {
        this.taskName = taskName; // Initialize task name
        this.taskNumber = taskNumber; // Initialize task number
        this.taskDescription = taskDescription; // Initialize task description
        this.developerName = developerName; // Initialize developer name
        this.developerHours = developerHours; // Initialize developer hours
        this.taskID = createTaskID(taskName, taskNumber, developerName); // Generate the unique task ID
    }

    // Method to check if the task description is within the allowed length
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50; // Return true if description length is 50 or less
    }

    // Private method to create a unique task ID based on task details
    private String createTaskID(String taskName, int taskNumber, String developerName) {
        // Generate the ID using the first two letters of taskName, taskNumber, and last three letters of developerName
        String id = taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developerName.substring(developerName.length() - 3).toUpperCase();
        return id; // Return the generated task ID
    }

    // Method to print all details of the task in a formatted string
    public String printTaskDetails() {
        // Return a formatted string with task details
        return String.format("Task Status: %s\nDeveloper Details: %s\nTask Number: %d\nTask Name: %s\nTask Description: %s\nTask ID: %s\nTask Duration: %d hours",
                taskStatus, developerName, taskNumber, taskName, taskDescription, taskID, developerHours);
    }

    // Method to set the current status of the task
    public void setTaskStatus(String status) {
        this.taskStatus = status; // Update the task status
    }

    // Getter method to retrieve the number of hours allocated to the developer for the task
    public int getDeveloperHours() {
        return developerHours; // Return the allocated hours
    }
}
