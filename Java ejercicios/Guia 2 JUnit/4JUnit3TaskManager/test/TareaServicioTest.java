
import Entidad.Tarea;
import Servicio.TareaServicio;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TareaServicioTest {
    
    private TareaServicio ts;
    
    public TareaServicioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ts=new TareaServicio();
    }
    
    @After
    public void tearDown() {
        ts=null;
    }

    @Test
    public void testAgregarTarea(){
        Tarea tarea=new Tarea(1, "Comprar frutas",LocalDate.parse("2023-07-17"));
        
        ts.agregarTarea(tarea);
        
        ArrayList <Tarea> tareaList=ts.mostrarTareas();
        
        assertTrue(tareaList.contains(tarea));
        
    }
    
    @Test
    public void testEliminarTarea(){
        Tarea tarea=new Tarea(1, "Comprar frutas",LocalDate.parse("2023-07-17"));
        
        ts.eliminarTarea(tarea);
        
        ArrayList <Tarea> tareaList=ts.mostrarTareas();
        
        assertFalse(tareaList.contains(tarea));
        
    }
    
    @Test
    public void testMostrarTarea(){
        Tarea tarea1=new Tarea(1, "Comprar frutas",LocalDate.parse("2023-07-17"));
        Tarea tarea2=new Tarea(2, "Comprar vegetales",LocalDate.parse("2023-07-20"));
        
        ts.agregarTarea(tarea1);
        ts.agregarTarea(tarea2);
        
        ArrayList <Tarea> tareaList=ts.mostrarTareas();
        
        assertEquals(2, tareaList.size());
        assertTrue(tareaList.contains(tarea1));
        assertTrue(tareaList.contains(tarea2));
         
    }
}
