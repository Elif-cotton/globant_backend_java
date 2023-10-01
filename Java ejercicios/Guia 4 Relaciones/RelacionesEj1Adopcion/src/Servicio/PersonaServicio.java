
package Servicio;

import Entidad.Perro;
import Entidad.Persona;

/**
 *
 * @author javer
 */
public class PersonaServicio {
    
    public void mostrarInformacionPersona(Persona persona) {
        System.out.println("Nombre: " + persona.getNombre()+" "+persona.getApellido());
        System.out.println("Edad: " + persona.getEdad());
        System.out.println("Documento: " + persona.getDocumento());

        Perro perro = persona.getPerro();
        if (perro != null) {
            System.out.println("Perro Adoptado:");
            System.out.println("Nombre: " + perro.getNombre());
            System.out.println("Raza: " + perro.getRaza());
            System.out.println("Edad: " + perro.getEdad());
            System.out.println("Tamaño: " + perro.getTamano());
        } else {
            System.out.println("No tiene perro adoptado.");
        }

        System.out.println();
    }
}
