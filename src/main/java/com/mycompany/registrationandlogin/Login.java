/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrationandlogin;
import java.util.Scanner;
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
    private boolean containsUppercase(){
        return password.chars().anyMatch(Character::isUpperCase);
    }   
    private boolean containsDigit(){
        return password.chars().anyMatch(Character::isDigit);
    }
    private boolean containsSpecialCharacter(){
        String SpecialCharacter = "!@#$%^&*()_+-{}[]=;:''<>?,./`~";
    }
   
    public String registerUser(){
    }

    public boolean loginUser(){
    }

    public String returnLoginStatus(){
    }

}

