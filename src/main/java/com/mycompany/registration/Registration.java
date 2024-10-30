/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registration;
import javax.swing.JOptionPane;
/**
 *
 * @author Teboho Kojoana
 */
public class Registration {
    //Declarations
    private String name; //Variable to store the user's first name
    private String lastName; //Variable to store the user's last name
    private String username; //Variable to store the user's chosen username
    private String password; //Variable to store the user's chosen password

//Method to register a new user
public void registerUser() {
    //Prompting user for personal information
    name = JOptionPane.showInputDialog("Enter your name: "); //Get user's first name
    lastName = JOptionPane.showInputDialog("Enter your last name: "); //Get user's last name
    username = JOptionPane.showInputDialog("Enter a username: "); //Get user's desired username
    password = JOptionPane.showInputDialog("Enter a password: "); //Get user's chosen password

    //Create a new Login instance to handle user registration
    Login login = new Login(); 
    //Register the user and capture the registration message
    String registrationMessage = login.user(username, password);
    //Print the registration message to the console
    System.out.println(registrationMessage);
}

//Main method to run the application
public static void main(String[] args) {
    //Create a new instance of Registration to start the registration process
    Registration registration = new Registration();
    registration.registerUser(); //Call method to register the user
    
    //User enters credentials to login
    String username = JOptionPane.showInputDialog("Enter your username to login: "); //Prompt for username
    String password = JOptionPane.showInputDialog("Enter your password to login: "); //Prompt for password

    //Create a new Login instance to handle user login
    Login login = new Login();
    // Check the login status and get the corresponding message
    String loginStatus = login.returnLoginStatus(username, password);
    //Display the login status to the user in a dialog box
    JOptionPane.showMessageDialog(null, loginStatus);
    
    //Display a welcome message to the user
    JOptionPane.showMessageDialog(null,"Welcome to EasyKanban!");
    
    //Display options to the user in a loop
    while (true) {
        //Prompt the user to choose an option from the menu
        String choice = JOptionPane.showInputDialog("Choose an option: \n1: Add Tasks \n2: Show Report (Coming soon) \n3: Quit " );
        switch (Integer.parseInt(choice)) {
            case 1: // Option to add tasks
                String numberOfTasks = JOptionPane.showInputDialog("How many tasks would you like to enter?"); // Prompt for number of tasks
                login.addTasks(Integer.parseInt(numberOfTasks)); //Call method to add tasks
                break;
            case 2: //Option for showing reports
                JOptionPane.showMessageDialog(null, "Coming soon."); //Placeholder for future functionality
                break;
            case 3: //Option to quit the application
                JOptionPane.showMessageDialog(null, "Exiting the application."); //Inform user before exiting
                return; //Exit the application
            default: //Handle invalid choices
                JOptionPane.showMessageDialog(null, "Invalid choice. Please try again."); //Prompt for valid input
        }
    }
    }
        
        
    
}

