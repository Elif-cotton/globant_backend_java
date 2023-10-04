
package Entidades;

/**
 *
 * @author javer
 */
public class PersonalDeServicio extends Empleado{
    
    private String seccionAsignada;

    public PersonalDeServicio() {
    }

    public PersonalDeServicio(String nombre, String apellidos, String numeroIdentificacion, String estadoCivil,
                              String seccionAsignada, int anioIncorporacion, String numeroDespacho) {
        super(anioIncorporacion, numeroDespacho, nombre, apellidos, numeroIdentificacion, estadoCivil);
        this.seccionAsignada = seccionAsignada;
    }

    public String getSeccionAsignada() {
        return seccionAsignada;
    }

    public void setSeccionAsignada(String seccionAsignada) {
        this.seccionAsignada = seccionAsignada;
    }
    
    public void trasladarSeccion(String nuevaSeccion) {
        seccionAsignada = nuevaSeccion;
    }
    
    public void mostrarInformacion() {
        System.out.println("Nombre completo: " + nombre + " " + apellidos);
        System.out.println("Identificación: " + numeroIdentificacion);
        System.out.println("Estado Civil: " + estadoCivil);
        System.out.println("Seccción Asiganda: " + seccionAsignada);
        if (!seccionAsignada.equals("Decanato")) {
            System.out.println("¡Has sido transferido a otra sección!");
        }
    }
}
