
package Entidad;

/**
 *
 * @author javer
 */
public class Alumno {
    
    private String nombreCompleto;
    private String DNI;
    private int cantidadVotos;

    public Alumno() {
    }

    public Alumno(String nombreCompleto, String DNI) {
        this.nombreCompleto = nombreCompleto;
        this.DNI = DNI;
        this.cantidadVotos = 0;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public int getCantidadVotos() {
        return cantidadVotos;
    }

    public void setCantidadVotos(int cantidadVotos) {
        this.cantidadVotos = cantidadVotos;
    }
    
    public void incrementarVotos() {
        cantidadVotos++;
    }

    @Override
    public String toString() {
        return "Alumno{" + "Nombre Completo=" + nombreCompleto + ", DNI=" + DNI +
                ", Cantidad de Votos=" + cantidadVotos + '}';
    }
    
    
}
