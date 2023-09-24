
import Entidad.Tarea;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TareaTest {
    
    public TareaTest() {
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

    @Test
    public void obtenerId(){
        
        int tareaId=1;
        Tarea tarea=new Tarea(tareaId, "Comprar frutas",LocalDate.parse("2023-07-17"));
        
        assertEquals(tareaId, tarea.getId());
    }
    
    @Test 
    public void obtenerDescripcion(){
        String tareaDescripcion="Comprar frutas";
        Tarea tarea=new Tarea(1, tareaDescripcion,LocalDate.parse("2023-07-17"));
        
        assertEquals(tareaDescripcion, tarea.getDescripcion());
    }
    
    @Test
    public void obtenerFecha(){
        LocalDate fecha=LocalDate.parse("2023-07-17");
        Tarea tarea=new Tarea(1,"Comprar frutas" ,fecha);
        
        assertEquals(fecha, tarea.getFecha());
    }
}
