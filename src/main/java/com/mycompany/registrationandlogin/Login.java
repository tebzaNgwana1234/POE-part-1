/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrationandlogin;

/**
 *
 * @author Teboho Kojoana
 */
public class Login {
    
    //Declarations 
    private String username;
    private String password;
    
    //Assign veriables 
    public void SetsUsername(String n){
        username = n;
    }
    public void SetsPassword(String p){
        password = p;
    }
    
    //Return values
    public String getUsername(){
    return username;
    }
    public String getPassword(){
    return password;
    }
    
    public boolean checkUserName(){
        return password.length() < 5 && password.contains("_");
    }

    public boolean checkPasswordComplexity(){
        return password.length() >= 8 && 
                containsUppercase() && 
                containsDigit() && 
                containsSpecialCharacter();
    }
    
    //Check password complexity
    public boolean containsUppercase(){
        return password.chars().anyMatch(Character::isUpperCase);
    }   
    public boolean containsDigit(){
        return password.chars().anyMatch(Character::isDigit);
    }
    public boolean containsSpecialCharacter() {
        String specialCharacters = "!@#$%^&*()-_=+[]{};:'\",.<>?/`~";
        return password.chars().anyMatch(ch -> specialCharacters.indexOf(ch) >= 0);
    }
    // Method to check registration status
    public String checkRegistrationStatus() {
        if (!isUsernameValid()) {
            return "Invalid username. It must be less than 5 characters long and contain an underscore.";
        }
        if (!isPasswordValid()) {
            return "Invalid password. It must be at least 8 characters long, contain a capital letter, a number, and a special character.";
        }
        return "Registration successful!";
    }
    //Verify login details
    public boolean loginUser(String inputUsername, String inputPassword){
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    //Return login status
    public String returnLoginStatus(boolean isSuccess){
        return isSuccess? "Login successful" : "Invalid login details!";
    }

    private boolean isUsernameValid() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private boolean isPasswordValid() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

