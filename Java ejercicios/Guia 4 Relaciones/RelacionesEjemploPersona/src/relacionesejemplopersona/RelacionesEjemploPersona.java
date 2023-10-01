
package relacionesejemplopersona;

import Entidad.Dni;
import Entidad.Persona;

/**
 *
 * @author javer
 */
public class RelacionesEjemploPersona {

    
    public static void main(String[] args) {
        Dni dni1 = new Dni('A', 12345678);
        Dni dni2 = new Dni('B', 98765432);

        Persona persona1 = new Persona("Juan", "Perez", dni1);
        Persona persona2 = new Persona("María", "González", dni2);
        
        Persona persona3=new Persona();
        persona3.setNombre("Luisa");
        persona3.setApellido("Vargas");
        Dni dni3=new Dni();
        dni3.setSerie('C');
        dni3.setNumero(12983476);
        persona3.setDni(dni3);
        
        
        System.out.println("Persona 1");
        System.out.println("Nombre: "+persona1.getNombre());
        System.out.println("Apellido: "+persona1.getApellido());
        System.out.println("DNI: "+persona1.getDni().getSerie()+persona1.getDni().getNumero());
        
        System.out.println("\nPersona 2");
        System.out.println("Nombre: "+persona2.getNombre());
        System.out.println("Apellido: "+persona2.getApellido());
        System.out.println("DNI: "+persona2.getDni().getSerie()+persona2.getDni().getNumero());
        
        System.out.println("\nPersona 3");
        System.out.println("Nombre: "+persona3.getNombre());
        System.out.println("Apellido: "+persona3.getApellido());
        System.out.println("DNI: "+persona3.getDni().getSerie()+persona3.getDni().getNumero());
        
        
    }
    
}
