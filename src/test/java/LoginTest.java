/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import com.mycompany.registration3.Login;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Teboho Kojoana
 */
public class LoginTest {
    
    private Login login;

    @Before
    public void setUp() {
        //Create a new Login object before each test
        login = new Login();
    }

    //Test checkUsername method
    @Test
    public void testCheckUsername_ValidUsername() {
        assertTrue(login.checkUsername("kyl_1"));
    }

    @Test
    public void testCheckUsername_InvalidUsername_NoUnderscore() {
        assertFalse(login.checkUsername("kyle"));
    }

    @Test
    public void testCheckUsername_InvalidUsername_TooLong() {
        assertFalse(login.checkUsername("kyl_123"));
    }

    //Test checkPasswordComplexity method
    @Test
    public void testCheckPasswordComplexity_ValidPassword() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testCheckPasswordComplexity_PasswordTooShort() {
        assertFalse(login.checkPasswordComplexity("passw1@"));
    }

    @Test
    public void testCheckPasswordComplexity_MissingUpperCase() {
        assertFalse(login.checkPasswordComplexity("ch&&sec@ke99!"));
    }

    @Test
    public void testCheckPasswordComplexity_MissingNumber() {
        assertFalse(login.checkPasswordComplexity("Ch&&sec@ke!"));
    }

    @Test
    public void testCheckPasswordComplexity_MissingSpecialChar() {
        assertFalse(login.checkPasswordComplexity("ChSecKe99"));
    }

    //Test registerUser method
    @Test
    public void testRegisterUser_ValidCredentials() {
        String result = login.registerUser("John", "Doe", "kyl_1", "Ch&&sec@ke99!");
        assertEquals("Registration successful!", result);
    }

    @Test
    public void testRegisterUser_InvalidUsername() {
        String result = login.registerUser("John", "Doe", "kyle", "Ch&&sec@ke99!");
        assertEquals("Username is not correctly formatted. It should contain an underscore and be no more than 5 characters long.", result);
    }

    @Test
    public void testRegisterUser_InvalidPassword() {
        String result = login.registerUser("John", "Doe", "kyl_1", "password");
        assertEquals("Password is not correctly formatted. Ensure it contains at least 8 characters, a capital letter, a number, and a special character.", result);
    }

    //Test loginUser method
    @Test
    public void testLoginUser_SuccessfulLogin() {
        login.registerUser("John", "Doe", "kyl_1", "Ch&&sec@ke99!");
        String result = login.loginUser("kyl_1", "Ch&&sec@ke99!");
        assertEquals("Login successful!", result);
    }

    @Test
    public void testLoginUser_FailedLogin_IncorrectUsername() {
        login.registerUser("John", "Doe", "kyl_1", "Ch&&sec@ke99!");
        String result = login.loginUser("incorrect_user", "Ch&&sec@ke99!");
        assertEquals("Login failed. Incorrect username or password.", result);
    }

    @Test
    public void testLoginUser_FailedLogin_IncorrectPassword() {
        login.registerUser("John", "Doe", "kyl_1", "Ch&&sec@ke99!");
        String result = login.loginUser("kyl_1", "wrongpassword");
        assertEquals("Login failed. Incorrect username or password.", result);
    }

    @Test
    public void testLoginUser_NoUserRegistered() {
        String result = login.loginUser("kyl_1", "Ch&&sec@ke99!");
        assertEquals("No user registered.", result);
    }
}
