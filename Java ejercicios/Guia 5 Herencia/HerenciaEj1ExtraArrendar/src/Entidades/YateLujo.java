
package Entidades;

/**
 *
 * @author javer
 */
public class YateLujo extends Barco {
    
    private int potencia;
    private int camarotes;

    public YateLujo() {
    }

    public YateLujo(int potencia, int camarotes, String matricula, double eslora, int anioFabricacion) {
        super(matricula, eslora, anioFabricacion);
        this.potencia = potencia;
        this.camarotes = camarotes;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getCamarotes() {
        return camarotes;
    }

    public void setCamarotes(int camarotes) {
        this.camarotes = camarotes;
    }
    
    public String getInfo() {
        return super.getInfo() + "\nPotencia en CV: " + potencia + "\nNúmero de Camarotes: " + camarotes;
    }
}
