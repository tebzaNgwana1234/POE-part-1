/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import com.mycompany.registration.Task;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Teboho Kojoana
 */
public class TaskTest {
    private Task task;

    //Set up a new Task instance before each test
    @Before
    public void setUp() {
        task = new Task("Sample Task", 1, "This is a sample task description.", "Alice Johnson", 5);
    }

    //Test constructor initialization and task ID creation
    @Test
    public void testTaskConstructorAndID() {
        //Verify that the task ID is created correctly based on the inputs
        assertEquals("SA:1:SON", task.taskID);
        
        //Check if other properties are initialized correctly
        assertEquals("Sample Task", task.taskName);
        assertEquals(1, task.taskNumber);
        assertEquals("This is a sample task description.", task.taskDescription);
        assertEquals("Alice Johnson", task.developerName);
        assertEquals(5, task.getDeveloperHours());
    }

    //Test the task description length check with a valid description
    @Test
    public void testCheckTaskDescription_ValidLength() {
        // Expect that a valid description (<= 50 characters) returns true
        assertTrue(task.checkTaskDescription());
    }

    //Test the task description length check with an invalid description
    @Test
    public void testCheckTaskDescription_InvalidLength() {
        // Create a task with a long description (> 50 characters)
        Task longDescriptionTask = new Task("Long Task", 2, "This description is definitely longer than fifty characters and should fail.", "Bob Smith", 8);
        // Expect that the task description check returns false
        assertFalse(longDescriptionTask.checkTaskDescription());
    }

    //Test printing task details
    @Test
    public void testPrintTaskDetails() {
        // Prepare the expected output string for task details
        String expectedDetails = "Task Status: null\nDeveloper Details: Alice Johnson\nTask Number: 1\nTask Name: Sample Task\nTask Description: This is a sample task description.\nTask ID: SA:1:SON\nTask Duration: 5 hours";
        
        // Verify that the printed details match the expected output
        assertEquals(expectedDetails, task.printTaskDetails());
    }

    //Test setting task status
    @Test
    public void testSetTaskStatus() {
        // Set a new status for the task
        task.setTaskStatus("In Progress");
        // Check if the status is updated correctly
        assertEquals("In Progress", task.taskStatus);
    }
}
