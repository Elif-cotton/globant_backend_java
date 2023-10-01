
package Entidad;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javer
 */
public class Alumno {
    
    private String nombreCompleto;
    private String dni;
    private int cantidadVotos;
    List<Voto> votosRecibidos;
    
    public Alumno() {
    }

    public Alumno(String nombreCompleto, String dni) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.cantidadVotos = 0;
        this.votosRecibidos = new ArrayList<>();
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDNI() {
        return dni;
    }

    public void setDNI(String DNI) {
        this.dni = dni;
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
        return nombreCompleto + " (DNI: " + dni + ") - Votos: " + cantidadVotos;
    }
}
