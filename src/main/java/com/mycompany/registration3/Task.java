/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registration3;
import javax.swing.JOptionPane;
import java.util.ArrayList;
/**
 *
 * @author Teboho Kojoana
 */
public class Task {
    //Arrays for storing task details
    private static ArrayList<String> developers = new ArrayList<>();
    private static ArrayList<String> taskNames = new ArrayList<>();
    private static ArrayList<String> taskIds = new ArrayList<>();
    private static ArrayList<Double> taskDurations = new ArrayList<>();
    private static ArrayList<String> taskStatuses = new ArrayList<>();
    
    //Declarations
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private double taskDuration;
    private String taskStatus;
    private String taskId;
    private String developer;

    //Constructor to create a task and get task details from user
    public Task(int taskNumber) {
        this.taskNumber = taskNumber;
        this.taskName = JOptionPane.showInputDialog("Enter Task Name: ");
        
        //Ensure task description is under 50 characters
        this.taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 characters):");
        while (!checkTaskDescription(this.taskDescription)) {
            this.taskDescription = JOptionPane.showInputDialog("Description too long! Enter Task Description (max 50 characters):");
        }

        //Input task duration
        this.taskDuration = Double.parseDouble(JOptionPane.showInputDialog("Enter Task Duration in hours: "));
        
        //Input task status
        this.taskStatus = JOptionPane.showInputDialog("Enter Task Status (To Do, Doing, Done): ");
        
        //Assign developer
        this.developer = JOptionPane.showInputDialog("Enter Developer Name: ");
        
        // Generate Task ID
        this.taskId = createTaskID(this.taskName, this.taskNumber);

        //Store task details in arrays
        developers.add(developer);
        taskNames.add(taskName);
        taskIds.add(taskId);
        taskDurations.add(taskDuration);
        taskStatuses.add(taskStatus);
    }

    //Method to check if task description is within the limit of 50 characters
    public boolean checkTaskDescription(String description) {
        return description.length() <= 50;
    }

    //Method to generate the Task ID
    public String createTaskID(String taskName, int taskNumber) {
        String taskId = taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":DEV"; // Developer's name assumed as "DEV"
        return taskId;
    }

    //Method to print task details
    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
               "Developer Details: " + developer + "\n" +
               "Task Number: " + taskNumber + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task ID: " + taskId + "\n" +
               "Task Duration: " + taskDuration + " hours";
    }

    //Method to return task duration
    public double getTaskDuration() {
        return taskDuration;
    }

    //Method to manage tasks
    public static void manageTasks() {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to enter?"));
        Task[] tasks = new Task[numTasks];

        double totalDuration = 0;
        for (int i = 0; i < numTasks; i++) {
            tasks[i] = new Task(i);
            JOptionPane.showMessageDialog(null, tasks[i].printTaskDetails());
            totalDuration += tasks[i].getTaskDuration();
        }

        JOptionPane.showMessageDialog(null, "Total Task Duration: " + totalDuration + " hours");

        //Task menu options
        String options = "1. Add Tasks\n2. Show Report (Coming Soon)\n3. Quit\n4. Display Done Tasks\n5. Search Task by Name\n6. Search Tasks by Developer\n7. Delete Task by Name";
        int option = Integer.parseInt(JOptionPane.showInputDialog(options));

        switch (option) {
            case 1:
                JOptionPane.showMessageDialog(null, "You can add tasks now.");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Coming soon");
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Goodbye!");
                break;
            case 4:
                displayDoneTasks();
                break;
            case 5:
                searchTaskByName();
                break;
            case 6:
                searchTasksByDeveloper();
                break;
            case 7:
                deleteTaskByName();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid Option");
        }
    }

    //Method to display tasks with the status of "Done"
    public static void displayDoneTasks() {
        StringBuilder doneTasks = new StringBuilder("Tasks with status 'Done':\n");
        for (int i = 0; i < taskStatuses.size(); i++) {
            if (taskStatuses.get(i).equalsIgnoreCase("Done")) {
                doneTasks.append("Developer: ").append(developers.get(i)).append("\n")
                          .append("Task Name: ").append(taskNames.get(i)).append("\n")
                          .append("Duration: ").append(taskDurations.get(i)).append(" hours\n\n");
            }
        }
        JOptionPane.showMessageDialog(null, doneTasks.toString());
    }

    //Method to display the task with the longest duration
    public static void displayLongestDurationTask() {
        double maxDuration = 0;
        String developer = "";
        for (int i = 0; i < taskDurations.size(); i++) {
            if (taskDurations.get(i) > maxDuration) {
                maxDuration = taskDurations.get(i);
                developer = developers.get(i);
            }
        }
        JOptionPane.showMessageDialog(null, "The task with the longest duration: Developer: " + developer + " with " + maxDuration + " hours.");
    }

    //Method to search for a task by name
    public static void searchTaskByName() {
        String taskName = JOptionPane.showInputDialog("Enter Task Name to Search: ");
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskName)) {
                JOptionPane.showMessageDialog(null, "Task Found:\n" +
                        "Task Name: " + taskNames.get(i) + "\n" +
                        "Developer: " + developers.get(i) + "\n" +
                        "Status: " + taskStatuses.get(i));
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task not found.");
    }

    //Method to search for tasks assigned to a developer
    public static void searchTasksByDeveloper() {
        String developerName = JOptionPane.showInputDialog("Enter Developer Name to Search: ");
        StringBuilder tasksByDeveloper = new StringBuilder("Tasks assigned to " + developerName + ":\n");
        for (int i = 0; i < developers.size(); i++) {
            if (developers.get(i).equalsIgnoreCase(developerName)) {
                tasksByDeveloper.append("Task Name: ").append(taskNames.get(i))
                                 .append(", Status: ").append(taskStatuses.get(i)).append("\n");
            }
        }
        if (tasksByDeveloper.length() > 0) {
            JOptionPane.showMessageDialog(null, tasksByDeveloper.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No tasks found for " + developerName);
        }
    }

    //Method to delete a task by task name
    public static void deleteTaskByName() {
        String taskNameToDelete = JOptionPane.showInputDialog("Enter Task Name to Delete: ");
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskNameToDelete)) {
                developers.remove(i);
                taskNames.remove(i);
                taskIds.remove(i);
                taskDurations.remove(i);
                taskStatuses.remove(i);
                JOptionPane.showMessageDialog(null, "Task '" + taskNameToDelete + "' has been deleted.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task not found.");
    }

    //Method to display a full report of all tasks
    public static void displayFullReport() {
        StringBuilder report = new StringBuilder("Full Report of All Tasks:\n");
        for (int i = 0; i < taskNames.size(); i++) {
            report.append("Task Name: ").append(taskNames.get(i)).append("\n")
                  .append("Developer: ").append(developers.get(i)).append("\n")
                  .append("Task ID: ").append(taskIds.get(i)).append("\n")
                  .append("Task Status: ").append(taskStatuses.get(i)).append("\n")
                  .append("Task Duration: ").append(taskDurations.get(i)).append(" hours\n\n");
        }
        JOptionPane.showMessageDialog(null, report.toString());
    }
}
