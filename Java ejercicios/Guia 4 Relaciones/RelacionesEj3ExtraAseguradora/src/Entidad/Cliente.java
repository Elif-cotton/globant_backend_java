
package Entidad;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javer
 */
public class Cliente {
    
    private String nombre;
    private String apellido;
    private String documento;
    private String email;
    private String domicilio;
    private String telefono;
    List<Poliza> polizas = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String documento, String email, String domicilio, 
                    String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.email = email;
        this.domicilio = domicilio;
        this.telefono = telefono;
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Poliza> getPolizas() {
        return polizas;
    }

    public void setPolizas(List<Poliza> polizas) {
        this.polizas = polizas;
    }

    
    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", apellido=" + apellido + 
                ", documento=" + documento + ", email=" + email + ", domicilio="
                + domicilio + ", teléfono=" + telefono + '}';
    }

   
    
   
    
}
