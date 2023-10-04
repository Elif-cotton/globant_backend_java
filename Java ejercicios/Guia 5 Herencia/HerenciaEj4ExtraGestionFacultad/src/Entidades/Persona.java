
package Entidades;

/**
 *
 * @author javer
 */
public class Persona {
    
    protected String nombre;
    protected String apellidos;
    protected String numeroIdentificacion;
    protected String estadoCivil;

    public Persona() {
    }

    public Persona(String nombre, String apellidos, String numeroIdentificacion, String estadoCivil) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numeroIdentificacion = numeroIdentificacion;
        this.estadoCivil = estadoCivil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    
    public void cambiarEstadoCivil(String nuevoEstado) {
        estadoCivil = nuevoEstado;
    }

//    public String getInfo() {
//        return "Nombre: " + nombre + " " + apellidos + "\nIdentificación: " + numeroIdentificacion +
//               "\nEstado Civil: " + estadoCivil;
//    }

   
    
}
