/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Service.TaskManagerService;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author javer
 */
public class TaskManagerTest {
    
    public TaskManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
     @Test
    public void testAddTask() {
        TaskManagerService tms=new TaskManagerService();
        
        tms.addTask("Task 1");
        tms.addTask("Task 2");
        tms.addTask("Task 3");
        
        List<String> tasks = tms.getTasks();

        assertEquals(3, tasks.size());
        assertTrue(tasks.contains("Task 1"));
        assertTrue(tasks.contains("Task 2"));
        assertTrue(tasks.contains("Task 3"));
    }

     @Test
    public void testRemoveTask() {
        TaskManagerService tms=new TaskManagerService();
        tms.addTask("Task 1");
        tms.addTask("Task 2");
        tms.addTask("Task 3");

        tms.removeTask("Task 2");
        List<String> tasks = tms.getTasks();

        assertEquals(2, tasks.size());
        assertTrue(tasks.contains("Task 1"));
        assertFalse(tasks.contains("Task 2"));
        assertTrue(tasks.contains("Task 3"));
    }
    
     @Test
    public void testGetTasks() {
        TaskManagerService tms=new TaskManagerService();
        List<String> tasks = tms.getTasks();
        assertEquals(0, tasks.size());

        tms.addTask("Task 1");
        tms.addTask("Task 2");
        tms.addTask("Task 3");
        tasks = tms.getTasks();

        assertEquals(3, tasks.size());
        assertTrue(tasks.contains("Task 1"));
        assertTrue(tasks.contains("Task 2"));
        assertTrue(tasks.contains("Task 3"));
    }

}
