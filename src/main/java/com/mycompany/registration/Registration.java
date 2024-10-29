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
    private String name;
    private String lastName;
    private String username;
    private String password;

    public void registerUser() {
        //Promting user for information
        name = JOptionPane.showInputDialog("Enter your name: ");
        lastName = JOptionPane.showInputDialog("Enter your last name: ");
        username = JOptionPane.showInputDialog("Enter a username: ");
        password = JOptionPane.showInputDialog("Enter a password: ");

        Login login = new Login(); 
        String registrationMessage = login.user(username, password);
        System.out.println(registrationMessage);
    }

    public static void main(String[] args) {
        Registration registration = new Registration();
        registration.registerUser();
        
        //User enters credentials 
        String username = JOptionPane.showInputDialog("Enter your username to login: ");
        String password = JOptionPane.showInputDialog("Enter your password to login: ");

        Login login = new Login();
        String loginStatus = login.returnLoginStatus(username, password);
        JOptionPane.showMessageDialog(null, loginStatus);
        
        //Welocme message
        JOptionPane.showMessageDialog(null,"Welcome to EasyKanban!");
        
        //Display options to user
        while (true) {
            String choice = JOptionPane.showInputDialog("Choose an option: \n1: Add Tasks \n2: Show Report (Coming soon) \n3: Quit " );
            switch (Integer.parseInt(choice)) {
                case 1:
                    String numberOfTasks = JOptionPane.showInputDialog("How many tasks would you like to enter?");
                    login.addTasks(Integer.parseInt(numberOfTasks));
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Coming soon.");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Exiting the application.");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            }
        }
    }
        
        
    
}

