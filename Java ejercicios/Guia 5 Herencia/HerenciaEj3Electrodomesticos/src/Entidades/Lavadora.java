
package Entidades;

/**
 *
 * @author javer
 */
public class Lavadora extends Electrodomestico{
    
    private int carga;

    
    public Lavadora() {
    }

    
    public Lavadora(int carga, double precio, String color, Character consumoEnergetico, int peso) {
        super(precio, color, consumoEnergetico, peso);
        this.carga = carga;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }
}
