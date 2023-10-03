
package Entidades;

/**
 *
 * @author javer
 */
public class Televisor extends Electrodomestico {
    
    private int resolucion; // en pulgadas inches
    private boolean sintonizador;

    public Televisor() {
    }

    public Televisor(int resolucion, boolean sintonizador, double precio, String color, Character consumoEnergetico, int peso) {
        super(precio, color, consumoEnergetico, peso);
        this.resolucion = resolucion;
        this.sintonizador = sintonizador;
    }   

    public int getResolucion() {
        return resolucion;
    }

    public void setResolucion(int resolucion) {
        this.resolucion = resolucion;
    }

    public boolean isSintonizador() {
        return sintonizador;
    }

    public void setSintonizador(boolean sintonizador) {
        this.sintonizador = sintonizador;
    }
    
}
