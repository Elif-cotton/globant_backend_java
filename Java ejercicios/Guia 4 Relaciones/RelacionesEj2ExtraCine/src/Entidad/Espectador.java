
package Entidad;

/**
 *
 * @author javer
 */
public class Espectador {
    
    private String nombre;
    private int edad;
    private double dinero;

    public Espectador() {
    }

    public Espectador(String nombre, int edad, double dinero) {
        this.nombre = nombre;
        this.edad = edad;
        this.dinero = dinero;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }


    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }
   
    public boolean tieneEdadYDineroSuficiente(Pelicula pelicula, double precioEntrada) {
        return edad >= pelicula.getEdadMinima() && dinero >= precioEntrada;
    }
    
     @Override
    public String toString() {
        return "el nombre del espectador es " + nombre + " de " + edad + " años y con " 
                + dinero + " pesos en su bolsillo";
    }
    
}
