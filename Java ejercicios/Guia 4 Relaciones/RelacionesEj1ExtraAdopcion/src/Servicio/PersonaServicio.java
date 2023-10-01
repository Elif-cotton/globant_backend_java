
package Servicio;

import Entidad.Perro;
import Entidad.Persona;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author javer
 */
public class PersonaServicio {
    
    private static Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");
    
    public void adopcionPerro(List<Persona> personas, List<Perro> perros ){
        
        for (Persona persona : personas) {
            System.out.println(persona.getNombre() + ", elige un perro para adoptar:");
            for (int i = 0; i < perros.size(); i++) {
                Perro perro = perros.get(i);
                if (!perro.isAdoptado()) {
                    System.out.println(i + 1 + ". " + perro);
                }
            }
            int opcion = leer.nextInt();
            if (opcion >= 1 && opcion <= perros.size()) {
                Perro perroElegido = perros.get(opcion - 1);
                if (persona.adoptarPerro(perroElegido)) {
                    System.out.println(persona.getNombre() + " ha adoptado a " + perroElegido.getNombre());
                } else {
                    System.out.println("El perro ya ha sido adoptado por otra persona.");
                }
            } else {
                System.out.println("Opción inválida.");
            }
        }
    }
        
    public void mostrarInformacionPersona( List<Persona> personas) {
        System.out.println("\nLista de adopciones:");
        for (Persona persona : personas) {
            System.out.println(persona);
        }   
    }
    
    
}
