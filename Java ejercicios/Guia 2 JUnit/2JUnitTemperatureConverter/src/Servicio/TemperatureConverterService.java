
package Servicio;


public class TemperatureConverterService {
    
    public static double covertCelciusToFahrenheit(double celcius){
        
        return (celcius*9/5)+32;
    }
    
    public static double covertFahrenheitToCelcius(double fahrenheit){
        
        return (fahrenheit-32)*5/9;
    }
    
    public static double covertCelciusToKelvin(double celcius){
        
        return celcius+273.15;
    }
    
    public static double covertKelvinToCelcius(double kelvin){
        
        return kelvin-273.15;
    }
    
    public static double covertFahrenheitToKelvin(double fahrenheit){
        
        return ((5/9*(fahrenheit-32))+ 273.15);
    }
    
    public static double covertKelvinToFahrenheit(double kelvin){
        
        return  ((kelvin - 273.15)*9/5) + 32;
    }
}
