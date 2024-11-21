/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registration3;
/**
 *
 * @author Teboho Kojoana
 */
public class Login {
    //Request login credentials 
    private String storedUsername;
    private String storedPassword;
    
    //Method to check username format
    public boolean checkUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }
    
    //Method to check password complexity
    public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*[0-9].*") &&
               password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
    }

    //Register user and store credentials if valid
    public String registerUser(String firstName, String lastName, String username, String password) {
        if (!checkUsername(username)) {
            return "Username is not correctly formatted. It should contain an underscore and be no more than 5 characters long.";
        } else if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted. Ensure it contains at least 8 characters, a capital letter, a number, and a special character.";
        } else {
            this.storedUsername = username;
            this.storedPassword = password;
            return "Registration successful!";
        }
    }

    //Verify login details
    public String loginUser(String username, String password) {
        if (this.storedUsername == null || this.storedPassword == null) {
            return "No user registered.";
        }
        if (this.storedUsername.equals(username) && this.storedPassword.equals(password)) {
            return "Login successful!";
        } else {
            return "Login failed. Incorrect username or password.";
        }
    }
}
