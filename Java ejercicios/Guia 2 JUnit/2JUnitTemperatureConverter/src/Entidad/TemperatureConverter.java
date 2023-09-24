/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author javer
 */
public class TemperatureConverter {
    
    private double celcius;
    private double fahrenheit;
    private double kelvin;

    public TemperatureConverter() {
        
    }

    public TemperatureConverter(double celcius, double fahrenheit, double kelvin) {
        this.celcius = celcius;
        this.fahrenheit = fahrenheit;
        this.kelvin = kelvin;
    }

    public double getCelcius() {
        return celcius;
    }

    public void setCelcius(double celcius) {
        this.celcius = celcius;
    }

    public double getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public double getKelvin() {
        return kelvin;
    }

    public void setKelvin(double kelvin) {
        this.kelvin = kelvin;
    }

    @Override
    public String toString() {
        return "TemperatureConverter{" + "celcius=" + celcius + ", fahrenheit=" + fahrenheit + ", kelvin=" + kelvin + '}';
    }
    
    
    
}
