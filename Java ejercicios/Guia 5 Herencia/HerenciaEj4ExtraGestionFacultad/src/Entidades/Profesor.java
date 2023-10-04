
package Entidades;

/**
 *
 * @author javer
 */
public class Profesor extends Empleado {
    
    private String departamento;

    public Profesor() {
    }

    public Profesor(String nombre, String apellidos, String numeroIdentificacion, String estadoCivil,
            String departamento, int anioIncorporacion, String numeroDespacho) {
        super(anioIncorporacion, numeroDespacho, nombre, apellidos, numeroIdentificacion, estadoCivil);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    public void cambiarDepartamento(String nuevoDepartamento) {
        departamento = nuevoDepartamento;
    }
    
    public void mostrarInformacion() {
        System.out.println("Nombre completo: " + nombre + " " + apellidos);
        System.out.println("Identificación: " + numeroIdentificacion);
        System.out.println("Estado Civil: " + estadoCivil);
        System.out.println("Departamento: " + departamento);
        if (!departamento.equals("Matemáticas")) {
            System.out.println("¡Has sido transferido a otro departamento!");
        }
    }
}
