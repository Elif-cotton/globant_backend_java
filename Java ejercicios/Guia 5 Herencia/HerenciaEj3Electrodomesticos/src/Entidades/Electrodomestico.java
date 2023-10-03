
package Entidades;

/**
 *
 * @author javer
 */
public class Electrodomestico {
    
    protected double precio;
    protected String color; // disponibles: blanco, negro, rojo, azul y gris 
    protected Character consumoEnergetico; // letras entre A y F
    protected int peso;
    
    //constructores

    public Electrodomestico() {
    }

    public Electrodomestico(double precio, String color, Character consumoEnergetico, int peso) {
        this.precio = precio;
        this.color = color;
        this.consumoEnergetico = consumoEnergetico;
        this.peso = peso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Character getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public void setConsumoEnergetico(Character consumoEnergetico) {
        this.consumoEnergetico = consumoEnergetico;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

}
