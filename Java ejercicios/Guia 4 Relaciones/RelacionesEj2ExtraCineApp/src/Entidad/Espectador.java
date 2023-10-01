
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }
    
    public void pagar(double precio) {
        dinero -= precio;
    }

    @Override
    public String toString() {
        return "el nombre del espectador es " + nombre + " de " + edad + 
                " años y con " + dinero + " euros en su bolsillo";
    }

    
}
