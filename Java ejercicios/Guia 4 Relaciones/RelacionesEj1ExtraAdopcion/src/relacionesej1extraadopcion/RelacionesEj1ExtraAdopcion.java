
package relacionesej1extraadopcion;

import Entidad.Perro;
import Entidad.Persona;
import Servicio.PersonaServicio;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author javer
 */
public class RelacionesEj1ExtraAdopcion {
    private static Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");
    
    public static void main(String[] args) {
        
        List<Perro> perros = new ArrayList<>();
        perros.add(new Perro("Firulais", "Labrador", 3, "Mediano"));
        perros.add(new Perro("Max", "Golden Retriever", 2, "Grande"));
        perros.add(new Perro("Luna", "Poodle", 1, "Pequeño"));

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Juan", "Perez", 30, "12345678"));
        personas.add(new Persona("Maria", "Gomez", 25, "87654321"));
        personas.add(new Persona("Carlos", "Lopez", 40, "98765432"));
        
        PersonaServicio ps=new PersonaServicio();
        ps.adopcionPerro(personas, perros);
        ps.mostrarInformacionPersona(personas);

    }
    
}
