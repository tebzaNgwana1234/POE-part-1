/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registration;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Teboho Kojoana
 */
public class Login {
    //Declarations
    private String Username; //Stores the username
    private String Password; //Stores the password
    
    // Method to validate the format of the username
    public boolean checkUsername(String username) {
        //Username must contain an underscore and be at most 5 characters long
        return username.contains("_") && username.length() <= 5;
    }

    //Method to check password complexity requirements
    public boolean checkPasswordComplexity(String password) {
        //Password must be at least 8 characters, include an uppercase letter,
        //a digit, and a special character from the specified set
        return password.length() >= 8 &&
               password.chars().anyMatch(Character::isUpperCase) &&
               password.chars().anyMatch(Character::isDigit) &&
               password.chars().anyMatch(ch -> "!@#$%^&*()-+=<>?/".indexOf(ch) >= 0);
    }

    //Method to register a new user with a username and password
    public String user(String username, String password) {
        //Validate username and password
        boolean isUsernameValid = checkUsername(username);
        boolean isPasswordValid = checkPasswordComplexity(password);

        //Construct response messages based on validation results
        if (!isUsernameValid && !isPasswordValid) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length. " +
                   "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
        } else if (!isUsernameValid) { 
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        } else if (!isPasswordValid) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
        } else {
            //Store valid username and password
            Username = username;
            Password = password;
            return "Registration successful. Username and password successfully captured.";
        }
    }

    //Method to verify if the user can log in with provided credentials
    public boolean loginUser(String username, String password) {
        //Check if the stored username and password match the provided ones
        return Username != null && Username.equals(username) &&
               Password != null && Password.equals(password);
    }

    //Method to return the login status based on user credentials
    public String returnLoginStatus(String username, String password) {
        //Verify login and return appropriate message
        if (loginUser(username, password)) {
            return "Login successful.";
        } else {
            return "Login failed. Please check your username and password.";
        }
    }

    //Fields for managing tasks
    private String storedUsername; //Placeholder for a stored username
    private String storedPassword; //Placeholder for a stored password
    private List<Task> tasks = new ArrayList<>(); //List to hold tasks
    private int totalHours = 0; //Total hours allocated to tasks

    //Method to add multiple tasks with user input
    public void addTasks(int numberOfTasks) {
        //Loop to add specified number of tasks
        for (int i = 0; i < numberOfTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter Task Name: ");
            String taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 characters): ");

            //Validate task description length
            if (!checkTaskDescription(taskDescription)) {
                JOptionPane.showMessageDialog(null,"Please enter a task description of less than 50 characters");
                i--; //Decrement to retry this task
                continue; //Skip to the next iteration
            }
            String developerName = JOptionPane.showInputDialog("Enter Developer Name: ");
            String taskDuration = JOptionPane.showInputDialog("Enter the duration: ");

            //Select task status from user input
            String status = JOptionPane.showInputDialog("Select Task Status (1. To Do, 2. Done, 3. Doing)");
            switch (Integer.parseInt(status)) {
                case 1: status = "To Do"; break; //Map user input to status
                case 2: status = "Done"; break;
                case 3: status = "Doing"; break;
                default: 
                    JOptionPane.showMessageDialog(null, "Invalid selection."); 
                    continue; //Skip to the next iteration on invalid input
            }

            //Create a new Task instance and set its status
            Task task = new Task(taskName, i, taskDescription, developerName, Integer.parseInt(taskDuration));
            task.setTaskStatus(status);
            tasks.add(task); //Add task to the list
            totalHours += Integer.parseInt(taskDuration); //Update total hours

            //Show task details to the user
            JOptionPane.showMessageDialog(null, task.printTaskDetails());
        }
    }

    // Method to check if the task description is within the allowed length
    public boolean checkTaskDescription(String description) {
        return description.length() <= 50; // Return true if description length is 50 or less
    }

    // Method to return the total hours allocated to all tasks
    public int returnTotalHours() {
        return totalHours; // Return the total hours
    }
}
