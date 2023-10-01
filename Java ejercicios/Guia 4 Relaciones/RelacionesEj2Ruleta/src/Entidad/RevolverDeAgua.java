
package Entidad;

/**
 *
 * @author javer
 */
public class RevolverDeAgua {
    
    private int posicionActual; //posición del tambor que se dispara, puede que esté el agua o no
    private int posicionAgua; //la posición del tambor donde se encuentra el agua

    public RevolverDeAgua() {
    }

    public RevolverDeAgua(int posicionActual, int posicionAgua) {
        this.posicionActual = posicionActual;
        this.posicionAgua = posicionAgua;
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

   
    
    
}
