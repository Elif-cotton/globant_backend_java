/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Entidad.DiscountCalculator;
import Servicio.ServicioDescuento;
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
public class DiscountCalculatorTest {
    
    public DiscountCalculatorTest() {
        
    }
    private static final double DELTA = 0.001;
    ServicioDescuento sd;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        sd=new ServicioDescuento();
       
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
    public void testCalcularDiezPorciento(){
        double precio = 100.0;
        double tasaDescuento = 10.0;
        double precioEsperadoDescuento = 90.0;
        System.out.println("Prueba del 10% de descuento");
        double precioActualDescuento= sd.realizarDescuento(precio, tasaDescuento);
        System.out.println(precioActualDescuento);
        assertEquals(precioEsperadoDescuento, precioActualDescuento,DELTA);
        
    }
//    DELTA se establece en 0.001, lo que significa que se considera aceptable una
//    diferencia de hasta 0.001 entre el valor esperado y el valor actual en las pruebas unitarias.
//    Si la diferencia es mayor que 0.001, la prueba unitaria fallará.
    
    @Test
    public void testCalcularMaximoPorcentaje(){
        double precio = 100.0;
        double tasaDescuento = 100.0;
        double precioEsperadoDescuento = 0.0;
        System.out.println("Prueba del 100% de descuento");
        double precioActualDescuento= sd.realizarDescuento(precio, tasaDescuento);
        System.out.println(precioActualDescuento);
        assertEquals(precioEsperadoDescuento, precioActualDescuento,DELTA);
    }
    
    @Test
    public void testCalcularNingunDescuento(){
        double precio = 100.0;
        double tasaDescuento = 0.0;
        double precioEsperadoDescuento =100.0;
        System.out.println("Prueba del 0% de descuento");
        double precioActualDescuento= sd.realizarDescuento(precio, tasaDescuento);
        System.out.println(precioActualDescuento);
        assertEquals(precioEsperadoDescuento, precioActualDescuento,DELTA);
    }
    
    @Test
    public void testCalcularcincuentaDescuento(){
        double precio = 100.0;
        double tasaDescuento = 50.0;
        double precioEsperadoDescuento =50.0;
        System.out.println("Prueba del 0% de descuento");
        double precioActualDescuento= sd.realizarDescuento(precio, tasaDescuento);
        System.out.println(precioActualDescuento);
        assertEquals(precioEsperadoDescuento, precioActualDescuento,DELTA);
    }
    
 
}
