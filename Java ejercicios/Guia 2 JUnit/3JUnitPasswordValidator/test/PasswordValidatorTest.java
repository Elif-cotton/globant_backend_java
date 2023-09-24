

import Service.PasswordValidatorService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PasswordValidatorTest {
    
    public PasswordValidatorTest() {
    }
    PasswordValidatorService vs = new PasswordValidatorService();
    
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
    public void testContrasenaValida(){
        //PasswordValidatorService vs = new PasswordValidatorService();
       
        assertTrue(vs.esValido("StrongPassword!123"));  //assertTrue o assertFalse (invalido)
    }
    
    @Test 
    public void testContrasenaInvalida(){
        
        assertFalse(vs.esValido("Short123"));  
    }
    
    @Test
    public void testEspecialCaracter() {
       
        assertTrue(vs.esValido("P&ssword123"));
    }
    
    @Test
    public void testInvalidaNoEspecialCaracter() {
       
        assertFalse(vs.esValido("Password123"));
    }
    
    @Test
    public void testletraMayuscula() {
        
        assertTrue(vs.esValido("Password!123"));
    }
    
    @Test
    public void testInvalidoNoletraMayuscula() {
        
        assertFalse(vs.esValido("password!123"));
    }
}
