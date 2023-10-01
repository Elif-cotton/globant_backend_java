
package relacionesej1adopcion;

import Entidad.Perro;
import Entidad.Persona;
import Servicio.PersonaServicio;

/**
 *
 * @author javer
 */
public class RelacionesEj1Adopcion {

    
    public static void main(String[] args) {
        
        Perro perro1 = new Perro("Algodón", "Beagle",2,"Mediano");
        Perro perro2 = new Perro("Colitas", "Pastor",1,"Grande");
        
        Persona persona1 = new Persona("Juan", "Perez", 23, "123456");
        Persona persona2 = new Persona("María", "González", 33, "987654");
      
        persona1.adoptarPerro(perro1);
        persona2.adoptarPerro(perro2);
        
        PersonaServicio ps=new PersonaServicio();
        ps.mostrarInformacionPersona(persona1);
        ps.mostrarInformacionPersona(persona2);
 
        System.out.println("");
        System.out.println(persona1.toString());
        System.out.println(persona2.toString());
    }
    

}
