/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registration3;
import javax.swing.JOptionPane;


/**
 *
 * @author Teboho Kojoana
 */
public class Registration3 {

    public static void main(String[] args) {
         //Create the Login instance
        Login login = new Login();
        
        //Request registration inputs from the user
        String firstName = JOptionPane.showInputDialog("Enter your first name: ");
        String lastName = JOptionPane.showInputDialog("Enter your last name: ");
        String username = JOptionPane.showInputDialog("Enter a username: ");
        String password = JOptionPane.showInputDialog("Enter a password: ");
        
        //Attempt user registration
        String registrationResult = login.registerUser(firstName, lastName, username, password);
        JOptionPane.showMessageDialog(null, registrationResult);

        //Attempt user login after registration
        String loginUsername = JOptionPane.showInputDialog("Enter your username to login: ");
        String loginPassword = JOptionPane.showInputDialog("Enter your password to login: ");
        
        //Verify the login credentials
        String loginResult = login.loginUser(loginUsername, loginPassword);
        JOptionPane.showMessageDialog(null, loginResult);
        
        //If login is successful, move to task management
        if (loginResult.equals("Login successful!")) {
            Task.manageTasks();
        }    
    }
}
