/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Entidad.TaskManager;
import Service.TaskManagerService;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TaskManagerTest {
    
    public TaskManagerTest() {
    }
    
    //private static ArrayList <TaskManager> taskManagerList = new ArrayList <>();
    
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
    public void testAgregarTarea(){
        
        ArrayList <TaskManager> taskManagerList = new ArrayList <>();
        
        TaskManagerService.agregarTarea("Tarea1", LocalDate.of(2023, 7, 17),LocalDate.of(2023, 7, 18));
        TaskManagerService.agregarTarea("Tarea2", LocalDate.of(2023, 7, 18), LocalDate.of(2023, 7, 19));
        
        TaskManagerService.obtenerTareas();
        
        TaskManager tarea1 =new TaskManager("Tarea1", LocalDate.of(2023, 7, 17),LocalDate.of(2023, 7, 18));
        TaskManager tarea2 = new TaskManager("Tarea 2", LocalDate.of(2023, 7, 18), LocalDate.of(2023, 7, 19));
        //assertArrayEquals(expecteds, actuals);
        TaskManager[] tareasEsperadas = {tarea1, tarea2};
        assertArrayEquals(tareasEsperadas,  TaskManagerService.getTaskManagerList().toArray());
    }
    
   //@Test
    public void testRemoverTareaPorFecha() {
        ArrayList <TaskManager> taskManagerList = new ArrayList <>();
       
        TaskManagerService.agregarTarea("Tarea 1", LocalDate.of(2023, 7, 17), LocalDate.of(2023, 7, 18));
        TaskManagerService.agregarTarea("Tarea 2", LocalDate.of(2023, 7, 18), LocalDate.of(2023, 7, 19));
        TaskManagerService.agregarTarea("Tarea 3", LocalDate.of(2023, 7, 17), LocalDate.of(2023, 7, 20));
        
        LocalDate fechaEliminar = LocalDate.of(2023, 7, 17);
        TaskManagerService.eliminarTarea(fechaEliminar);
        
        TaskManager tarea2 = new TaskManager("Tarea 2", LocalDate.of(2023, 7, 18), LocalDate.of(2023, 7, 19));
        TaskManager[] tareasEsperadas = {tarea2};
        assertArrayEquals(tareasEsperadas, taskManagerList.toArray());
         
    }
}
