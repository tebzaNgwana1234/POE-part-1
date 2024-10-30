/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import com.mycompany.registration.Login;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Teboho Kojoana
 */
public class LoginTest {
    private Login login;

    // Set up a new Login instance before each test
    @Before
    public void setUp() {
        login = new Login();
    }

    // Test valid username containing an underscore and within length limit
    @Test
    public void testCheckUsername_ValidUsername() {
        assertTrue(login.checkUsername("user_"));
    }

    // Test invalid username without an underscore
    @Test
    public void testCheckUsername_InvalidUsername_NoUnderscore() {
        assertFalse(login.checkUsername("user"));
    }

    // Test invalid username that exceeds the maximum length
    @Test
    public void testCheckUsername_InvalidUsername_TooLong() {
        assertFalse(login.checkUsername("user_long"));
    }

    // Test valid password meeting complexity requirements
    @Test
    public void testCheckPasswordComplexity_ValidPassword() {
        assertTrue(login.checkPasswordComplexity("Password1!"));
    }

    // Test invalid password lacking an uppercase letter
    @Test
    public void testCheckPasswordComplexity_InvalidPassword_NoUppercase() {
        assertFalse(login.checkPasswordComplexity("password1!"));
    }

    // Test invalid password lacking a digit
    @Test
    public void testCheckPasswordComplexity_InvalidPassword_NoDigit() {
        assertFalse(login.checkPasswordComplexity("Password!"));
    }

    // Test invalid password lacking a special character
    @Test
    public void testCheckPasswordComplexity_InvalidPassword_NoSpecialChar() {
        assertFalse(login.checkPasswordComplexity("Password1"));
    }

    // Test successful registration with valid username and password
    @Test
    public void testUser_SuccessfulRegistration() {
        String result = login.user("user_", "Password1!");
        assertEquals("Registration successful. Username and password successfully captured.", result);
    }

    // Test registration failure due to invalid username
    @Test
    public void testUser_InvalidUsername() {
        String result = login.user("user", "Password1!");
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.", result);
    }

    // Test registration failure due to invalid password
    @Test
    public void testUser_InvalidPassword() {
        String result = login.user("user_", "password");
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.", result);
    }

    // Test successful login with correct credentials
    @Test
    public void testLoginUser_SuccessfulLogin() {
        login.user("user_", "Password1!");
        assertTrue(login.loginUser("user_", "Password1!"));
    }

    // Test failed login with incorrect password
    @Test
    public void testLoginUser_FailedLogin() {
        login.user("user_", "Password1!");
        assertFalse(login.loginUser("user_", "wrongPassword"));
    }

    // Test the return message for successful login
    @Test
    public void testReturnLoginStatus_SuccessfulLogin() {
        login.user("user_", "Password1!");
        String result = login.returnLoginStatus("user_", "Password1!");
        assertEquals("Login successful.", result);
    }

    // Test the return message for failed login
    @Test
    public void testReturnLoginStatus_FailedLogin() {
        login.user("user_", "Password1!");
        String result = login.returnLoginStatus("user_", "wrongPassword");
        assertEquals("Login failed. Please check your username and password.", result);
    }
}
