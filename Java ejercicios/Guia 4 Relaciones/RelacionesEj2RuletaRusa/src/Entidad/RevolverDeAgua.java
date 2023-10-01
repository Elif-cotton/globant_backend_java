
package Entidad;

import java.util.Random;

/**
 *
 * @author javer
 */
public class RevolverDeAgua {
    
    private int posicionActual;
    private int posicionAgua;

    public RevolverDeAgua() {
        this.posicionActual = 1; // Inicializa en la posición 1 por defecto
        this.posicionAgua = new Random().nextInt(6) + 1; // Posición del agua aleatoria entre 1 y 6
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }

    public int getPosicionAgua() {
        return posicionAgua;
    }

    public void setPosicionAgua(int posicionAgua) {
        this.posicionAgua = posicionAgua;
    }
    
    public boolean mojar() {
        return posicionActual == posicionAgua;
    }

    public void siguienteChorro() {
        if (posicionActual == 6) {
            posicionActual = 1;
        } else {
            posicionActual++;
        }
    }

    @Override
    public String toString() {
        return "Posición actual: " + posicionActual + ", Posición del agua: " + posicionAgua;
    }
}
