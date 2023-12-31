
package Entidades;

/**
 *
 * @author javer
 */
public class BarcoMotor extends Barco{
    
    private int potencia;

    public BarcoMotor() {
    }

    public BarcoMotor(int potencia, String matricula, double eslora, int anioFabricacion) {
        super(matricula, eslora, anioFabricacion);
        this.potencia = potencia;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    
    public String getInfo() {
        return super.getInfo() + "\nPotencia en CV: " + potencia;
    }
}
