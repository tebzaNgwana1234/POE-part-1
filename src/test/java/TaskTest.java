/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Teboho Kojoana
 */
public class TaskTest {
    private Task task1, task2, task3, task4;

    @Before
    public void setUp() {
        //Create the tasks based on the given test data
        task1 = new Task(1, "Mike Smith", "Create Login", 5, "To Do");
        task2 = new Task(2, "Edward Harrison", "Create Add Features", 8, "Doing");
        task3 = new Task(3, "Samantha Paulson", "Create Reports", 2, "Done");
        task4 = new Task(4, "Glenda Oberholzer", "Add Arrays", 11, "To Do");

        //Add these tasks to static lists for testing
        Task.addTask(task1);
        Task.addTask(task2);
        Task.addTask(task3);
        Task.addTask(task4);
    }

    @Test
    public void testDeveloperArrayPopulatedCorrectly() {
        //Check if the developer array is populated with correct data for tasks 1-4
        List<String> expectedDevelopers = List.of("Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer");
        List<String> developers = Task.getDevelopers(); 
        assertEquals(expectedDevelopers, developers);
    }

    @Test
    public void testDisplayDeveloperAndLongestDurationTask() {
        //Test if the developer and task with the longest duration are returned correctly
        String expectedOutput = "Glenda Oberholzer, 11";
        String result = Task.displayLongestDurationTask(); 
        assertEquals(expectedOutput, result);
    }

    @Test
    public void testSearchTaskByName() {
        // Search for the task "Create Login"
        String expectedOutput = "Mike Smith, Create Login";
        String result = Task.searchTaskByName("Create Login");
        assertEquals(expectedOutput, result);
    }

    @Test
    public void testSearchTasksByDeveloper() {
        //Search for all tasks assigned to "Samantha Paulson"
        String expectedOutput = "Create Reports";
        String result = Task.searchTasksByDeveloper("Samantha Paulson");
        assertTrue(result.contains(expectedOutput));  // Checking if the task name is part of the result
    }

    @Test
    public void testDeleteTaskByName() {
        //Delete the task "Create Reports" and ensure it's removed correctly
        String expectedOutput = "Entry 'Create Reports' successfully deleted";
        String result = Task.deleteTaskByName("Create Reports"); 
        assertEquals(expectedOutput, result);

        //Check that the task was actually deleted
        assertNull(Task.searchTaskByName("Create Reports"));
    }

    @Test
    public void testDisplayFullReport() {
        //Test the full report display with all tasks (Assuming displayFullReport() prints out task details)
        String expectedReport = 
                "Task Name: Create Login\n" +
                "Developer: Mike Smith\n" +
                "Task ID: CR:1:DEV\n" +
                "Task Status: To Do\n" +
                "Task Duration: 5.0 hours\n\n" +
                "Task Name: Create Add Features\n" +
                "Developer: Edward Harrison\n" +
                "Task ID: CR:2:DEV\n" +
                "Task Status: Doing\n" +
                "Task Duration: 8.0 hours\n\n" +
                "Task Name: Create Reports\n" +
                "Developer: Samantha Paulson\n" +
                "Task ID: CR:3:DEV\n" +
                "Task Status: Done\n" +
                "Task Duration: 2.0 hours\n\n" +
                "Task Name: Add Arrays\n" +
                "Developer: Glenda Oberholzer\n" +
                "Task ID: AD:4:DEV\n" +
                "Task Status: To Do\n" +
                "Task Duration: 11.0 hours\n\n";
        
        String result = Task.displayFullReport();
        assertEquals(expectedReport, result);
    }

    //Helper methods in the Task class
    //Add these helper methods in your Task class to make the tests work

    public static class Task {
        private static List<String> developers = new ArrayList<>();
        private static List<String> taskNames = new ArrayList<>();
        private static List<String> taskIds = new ArrayList<>();
        private static List<Double> taskDurations = new ArrayList<>();
        private static List<String> taskStatuses = new ArrayList<>();

        private String developer;
        private String taskName;
        private String taskId;
        private double taskDuration;
        private String taskStatus;

        //Constructor to initialize Task with test data
        public Task(int taskNumber, String developer, String taskName, double taskDuration, String taskStatus) {
            this.developer = developer;
            this.taskName = taskName;
            this.taskId = taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":DEV";
            this.taskDuration = taskDuration;
            this.taskStatus = taskStatus;
        }

        //Add task to the static lists for testing purposes
        public static void addTask(Task task) {
            developers.add(task.developer);
            taskNames.add(task.taskName);
            taskIds.add(task.taskId);
            taskDurations.add(task.taskDuration);
            taskStatuses.add(task.taskStatus);
        }

        //Get developers for the test
        public static List<String> getDevelopers() {
            return developers;
        }

        //Display the task with the longest duration
        public static String displayLongestDurationTask() {
            double maxDuration = 0;
            String developer = "";
            for (int i = 0; i < taskDurations.size(); i++) {
                if (taskDurations.get(i) > maxDuration) {
                    maxDuration = taskDurations.get(i);
                    developer = developers.get(i);
                }
            }
            return developer + ", " + maxDuration;
        }

        //Search for a task by name
        public static String searchTaskByName(String taskName) {
            for (int i = 0; i < taskNames.size(); i++) {
                if (taskNames.get(i).equalsIgnoreCase(taskName)) {
                    return developers.get(i) + ", " + taskNames.get(i);
                }
            }
            return "Task not found.";
        }

        //Search for tasks by developer
        public static String searchTasksByDeveloper(String developerName) {
            StringBuilder tasksByDeveloper = new StringBuilder();
            for (int i = 0; i < developers.size(); i++) {
                if (developers.get(i).equalsIgnoreCase(developerName)) {
                    tasksByDeveloper.append(taskNames.get(i)).append("\n");
                }
            }
            return tasksByDeveloper.toString().isEmpty() ? "No tasks found for " + developerName : tasksByDeveloper.toString();
        }

        //Delete task by name
        public static String deleteTaskByName(String taskName) {
            for (int i = 0; i < taskNames.size(); i++) {
                if (taskNames.get(i).equalsIgnoreCase(taskName)) {
                    developers.remove(i);
                    taskNames.remove(i);
                    taskIds.remove(i);
                    taskDurations.remove(i);
                    taskStatuses.remove(i);
                    return "Entry '" + taskName + "' successfully deleted";
                }
            }
            return "Task not found.";
        }

        //Display full report of all tasks
        public static String displayFullReport() {
            StringBuilder report = new StringBuilder();
            for (int i = 0; i < taskNames.size(); i++) {
                report.append("Task Name: ").append(taskNames.get(i)).append("\n")
                      .append("Developer: ").append(developers.get(i)).append("\n")
                      .append("Task ID: ").append(taskIds.get(i)).append("\n")
                      .append("Task Status: ").append(taskStatuses.get(i)).append("\n")
                      .append("Task Duration: ").append(taskDurations.get(i)).append(" hours\n\n");
            }
            return report.toString();
        }
    }
}
