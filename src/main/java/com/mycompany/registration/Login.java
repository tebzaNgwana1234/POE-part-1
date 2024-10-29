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
    private String Username;
    private String Password;
    
    //Method to user name
    public boolean checkUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }
    //Methode to check password complexity
    public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 &&
               password.chars().anyMatch(Character::isUpperCase) &&
               password.chars().anyMatch(Character::isDigit) &&
               password.chars().anyMatch(ch -> "!@#$%^&*()-+=<>?/".indexOf(ch) >= 0);
    }
    //User 
    public String user(String username, String password) {
        boolean isUsernameValid = checkUsername(username);
        boolean isPasswordValid = checkPasswordComplexity(password);

        if (!isUsernameValid && !isPasswordValid) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length. " +
                   "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
        } else if (!isUsernameValid) { 
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        } else if (!isPasswordValid) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
        } else {
            Username = username;
            Password = password;
            return "Registration successful. Username and password successfully captured.";
        }
    }
    //CHecking username complexity 
    public boolean loginUser(String username, String password) {
        return Username != null && Username.equals(username) &&
               Password != null && Password.equals(password);
    }
    //Login status
    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Login successful.";
        } else {
            return "Login failed. Please check your username and password.";
        }
    }
    private String storedUsername;
    private String storedPassword;
    private List<Task> tasks = new ArrayList<>();
    private int totalHours = 0;

    // Other methods from the previous Login class...

    public void addTasks(int numberOfTasks) {
        
        for (int i = 0; i < numberOfTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter Task Name: ");
            String taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 characters): ");
            
            if (!checkTaskDescription(taskDescription)) {
                JOptionPane.showMessageDialog(null,"Please enter a task description of less than 50 characters");
                i--; // decrement to retry this task
                continue;
            }
            String developerName = JOptionPane.showInputDialog("Enter Developer Name: ");

             String taskDuration = JOptionPane.showInputDialog("Enter the duration: ");

            String status = JOptionPane.showInputDialog("Select Task Status (1. To Do, 2. Done, 3. Doing");
            switch (Integer.parseInt(status)) {
                case 1: status = "To Do"; break;
                case 2: status = "Done"; break;
                case 3: status = "Doing"; break;
                default: JOptionPane.showMessageDialog(null, "Invalid selection."); continue;
            }

            Task task = new Task(taskName, i, taskDescription, developerName, Integer.parseInt(taskDuration));
            task.setTaskStatus(status);
            tasks.add(task);
            totalHours += Integer.parseInt(taskDuration);

            JOptionPane.showMessageDialog(null, task.printTaskDetails());
        }
    }

    public boolean checkTaskDescription(String description) {
        return description.length() <= 50;
    }

    public int returnTotalHours() {
        return totalHours;
    }}
