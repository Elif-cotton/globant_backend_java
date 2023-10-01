
package Entidad;

/**
 *
 * @author javer
 */
public class Asiento {
    
    private char fila;
    private int numero;
    private boolean ocupado;

    public Asiento() {
    }

    public Asiento(char fila, int numero) {
        this.fila = fila;
        this.numero = numero;
        this.ocupado = false;
    }

    public char getFila() {
        return fila;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void ocupar() {
        ocupado = true;
    }

    public void desocupar() {
        ocupado = false;
    }
 
   @Override
    public String toString() {
        return ocupado ? "X" : " ";
    }
}
