
package Entidades;

/**
 *
 * @author javer
 */
public class Velero extends Barco {
    
    private int mastiles;

    public Velero() {
    }

    public Velero(int mastiles, String matricula, double eslora, int anioFabricacion) {
        super(matricula, eslora, anioFabricacion);
        this.mastiles = mastiles;
    }

    public int getMastiles() {
        return mastiles;
    }

    public void setMastiles(int mastiles) {
        this.mastiles = mastiles;
    }
    
    public String getInfo() {
        return super.getInfo() + "\nNúmero de Mástiles: " + mastiles;
    }
}
