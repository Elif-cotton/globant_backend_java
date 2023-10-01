
package Entidad;

import Enumeracion.Palo;

/**
 *
 * @author javer
 */
public class Baraja {
    
    private int numero;
    private Palo palo;

    public Baraja() {
    }

    public Baraja(int numero, Palo palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Palo getPalo() {
        return palo;
    }

    public void setPalo(Palo palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        return "Baraja{" + "numero=" + numero + ", palo=" + palo + '}';
    }
    
 
}
