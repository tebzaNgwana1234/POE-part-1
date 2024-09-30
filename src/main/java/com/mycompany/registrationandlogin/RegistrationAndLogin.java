/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registrationandlogin;
import java.util.Scanner;
/**
 *
 * @author Teboho Kojoana
 */
public class RegistrationAndLogin {
    //Declarations 
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    
    Scanner sc = new Scanner(System.in);
    //Methods of a new registering user
    public void registerUser(){
        
        
        //User Information 
        System.out.print("User regirstered successfully!");
        displayUserInfo();
        
     boolean hasUppercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
            if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        if (hasUppercase && hasDigit && hasSpecialChar) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password is not correctly formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
            return; 
        }
        //Check if the entered username and password match
        if (username.equals(username) && password.equals(password)) {
            System.out.println("Welcome: " + firstName + ", " + lastName + ", it is great to see you again!");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }  
        
        System.out.print("Enter Username: ");
        username = sc.nextLine();
        
        //Username validaiton
        System.out.print("Enter Username (must contain an underscore and be no more than 5 characters long): ");
        if (username.length() <= 5 && username.contains("_")) {
            System.out.println("Username successfully captured.");
        } else {
            System.out.println("Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than 5 characters in length.");
            return; // Exit the method if the username is invalid
        }
        
        System.out.print("Enter Password: ");
        password = sc.nextLine();
        
        // Validate the password
        if (password.length() < 8) {
            System.out.println("Password is not correctly formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
            return; // Exit if password is invalid
        }
        
        //Username validaiton
        System.out.print("Enter Username (must contain an underscore and be no more than 5 characters long): ");
        if (username.length() <= 5 && username.contains("_")) {
            System.out.println("Username successfully captured.");
        } else {
            System.out.println("Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than 5 characters in length.");
            return;
        }
        
    }
    //Method to display user information
    private void displayUserInfo(){
            System.out.println("Registered User Information");
            System.out.println("First Name: "+ firstName);
            System.out.println("last Name: "+ lastName);
            System.out.println("Username: "+ username);           
    }
    
    
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        //Promping User Registration Details and Cridentials
        System.out.print("Enter First name: ");
        String firstName = sc.nextLine();
        
        System.out.print("Enter Last name: ");
        String lastName = sc.nextLine();
        
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        
        RegistrationAndLogin Registration = new RegistrationAndLogin();
        Login LoginObjects = new Login();
        LoginObjects.checkPasswordComplexity();
        //Registration methods
        LoginObjects.checkRegistrationStatus();
        Registration.registerUser();
        Registration.displayUserInfo();
        
        LoginObjects.loginUser(username, password);
        LoginObjects.returnLoginStatus(true);
        
       
        
        
    }
    
}
