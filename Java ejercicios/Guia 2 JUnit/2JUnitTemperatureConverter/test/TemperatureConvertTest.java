/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Servicio.TemperatureConverterService;
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
public class TemperatureConvertTest {
    
    public TemperatureConvertTest() {
    }
    
    private static final double DELTA = 0.001; // Margen de error aceptable para las pruebas
    //TemperatureConverterService ts=new TemperatureConverterService();
    
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
    public void testCelciusToFahrenheit(){
        
        double celsius = 25.0;
        double fahrenheitEsperado = 77.0;
        
        double result=TemperatureConverterService.covertCelciusToFahrenheit(celsius);
        assertEquals(fahrenheitEsperado, result,DELTA);
        
    }
    
    @Test
    public void testFarhenheitToCelcius(){
        double Fahrenheit = 98.6;
        double celciusEsperado = 37.0;
        
        double result=TemperatureConverterService.covertFahrenheitToCelcius(Fahrenheit);
        assertEquals(celciusEsperado, result,DELTA);
        
    }
    
    @Test
    public void testCelciusToKelvin(){
        
        double celsius = 0.0;
        double kelvinEsperado = 273.15;
        
        double result=TemperatureConverterService.covertCelciusToKelvin(celsius);
        assertEquals(kelvinEsperado, result,DELTA);
        
    }
    
     
    @Test
    public void testkelvinToCelcius(){
        
        double kelvin = 300.0;
        double celciusEsperado = 26.85;
        
        double result=TemperatureConverterService.covertKelvinToCelcius(kelvin);
        assertEquals(celciusEsperado, result,DELTA);
        
    }
    
    @Test
    public void testFarhenheitToKelvin(){
        double Fahrenheit = 32.0;
        double kelvinEsperado = 273.15;
        
        double result=TemperatureConverterService.covertFahrenheitToKelvin(Fahrenheit);
        assertEquals(kelvinEsperado, result,DELTA);
        
    }
    
    @Test
    public void testKelvinToFarhenheit(){
        double kelvin = 300.0;
        double FarhenheitEsperado = 80.33;
        
        double result=TemperatureConverterService.covertKelvinToFahrenheit(kelvin);
        assertEquals(FarhenheitEsperado, result,DELTA);
        
    }
}
