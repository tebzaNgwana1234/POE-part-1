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
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerName;
    private int developerHours;
    private String taskID;
    private String taskStatus;

    public Task(String taskName, int taskNumber, String taskDescription, String developerName, int developerHours) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerName = developerName;
        this.developerHours = developerHours;
        this.taskID = createTaskID(taskName, taskNumber, developerName);
    }

    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    private String createTaskID(String taskName, int taskNumber, String developerName) {
        String id = taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developerName.substring(developerName.length() - 3).toUpperCase();
        return id;
    }

    public String printTaskDetails() {
        return String.format("Task Status: %s\nDeveloper Details: %s\nTask Number: %d\nTask Name: %s\nTask Description: %s\nTask ID: %s\nTask Duration: %d hours",
                taskStatus, developerName, taskNumber, taskName, taskDescription, taskID, developerHours);
    }

    public void setTaskStatus(String status) {
        this.taskStatus = status;
    }

    public int getDeveloperHours() {
        return developerHours;
    }
    
}
