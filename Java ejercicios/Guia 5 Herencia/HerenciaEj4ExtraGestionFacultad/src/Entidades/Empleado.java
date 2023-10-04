
package Entidades;

/**
 *
 * @author javer
 */
public class Empleado extends Persona{
    
    private int anioIncorporacion;
    private String numeroDespacho;

    public Empleado() {
    }

    public Empleado(int anioIncorporacion, String numeroDespacho, String nombre, String apellidos, String numeroIdentificacion, String estadoCivil) {
        super(nombre, apellidos, numeroIdentificacion, estadoCivil);
        this.anioIncorporacion = anioIncorporacion;
        this.numeroDespacho = numeroDespacho;
    }

    public int getAnioIncorporacion() {
        return anioIncorporacion;
    }

    public void setAnioIncorporacion(int anioIncorporacion) {
        this.anioIncorporacion = anioIncorporacion;
    }

    public String getNumeroDespacho() {
        return numeroDespacho;
    }

    public void setNumeroDespacho(String numeroDespacho) {
        this.numeroDespacho = numeroDespacho;
    }
    
    public void reasignarDespacho(String nuevoDespacho) {
        numeroDespacho = nuevoDespacho;
    }
    
    
}
