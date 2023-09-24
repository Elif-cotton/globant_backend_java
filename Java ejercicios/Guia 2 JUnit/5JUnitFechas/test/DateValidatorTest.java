/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Servicio.DateValidatorServicio;
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
public class DateValidatorTest {
    
    public DateValidatorTest() {
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
    public void testValidDates() {
        assertTrue(DateValidatorServicio.esFechaValida(2023, 7, 17));  // Fecha actual válida
        assertTrue(DateValidatorServicio.esFechaValida(2020, 2, 29));  // Año bisiesto válido
        assertTrue(DateValidatorServicio.esFechaValida(2000, 2, 29));  // Año bisiesto válido
        assertTrue(DateValidatorServicio.esFechaValida(2000, 12, 31)); // Último día del año válido
    }
    
    @Test
    public void testInvalidDates() {
        assertFalse(DateValidatorServicio.esFechaValida(2023, 2, 29));  // No es año bisiesto
        assertFalse(DateValidatorServicio.esFechaValida(2023, 13, 1));  // Mes inválido
        assertFalse(DateValidatorServicio.esFechaValida(2023, 7, 32));  // Día inválido
        assertFalse(DateValidatorServicio.esFechaValida(0, 7, 17));     // Año inválido
        assertFalse(DateValidatorServicio.esFechaValida(2023, -1, 17)); // Mes inválido
    }

}
