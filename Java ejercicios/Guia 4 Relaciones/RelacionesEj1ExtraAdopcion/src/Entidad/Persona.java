
package Entidad;

/**
 *
 * @author javer
 */
public class Persona {
    
    private String nombre;
    private String apellido;
    private int edad;
    private String documento;
    private Perro perroAdoptado;

    public Persona() {
    }

    public Persona(String nombre, String apellido, int edad, String documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
        this.perroAdoptado = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Perro getPerroAdoptado() {
        return perroAdoptado;
    }

    public void setPerroAdoptado(Perro perroAdoptado) {
        this.perroAdoptado = perroAdoptado;
    }
    
    public boolean adoptarPerro(Perro perro) {
        if (!perro.isAdoptado()) {
            perro.setAdoptado(true);
            perroAdoptado = perro;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + (perroAdoptado != null ? "Adoptó a: " + perroAdoptado : "No adoptó perro");
    }
}
