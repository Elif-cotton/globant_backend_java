
package herenciaej4extragestionfacultad;

import Entidades.Estudiante;
import Entidades.PersonalDeServicio;
import Entidades.Profesor;

/**
 *
 * @author javer
 */
public class HerenciaEj4ExtraGestionFacultad {

    
    public static void main(String[] args) {
       
        Estudiante estudiante = new Estudiante("Juan", "Perez", "123456789", "Soltero", "Ingeniería Informática");
        Profesor profesor = new Profesor("Maria", "Gomez", "987654321", "Soltero","Matemáticas", 2010, "A123");
        PersonalDeServicio servicio = new PersonalDeServicio("Luis", "Martinez", "567890123", "Viudo",
                "Decanato", 2015, "B456");
        
        System.out.println("");
        System.out.println("Estudiante");
        estudiante.mostrarInformacion();
        System.out.println("");
        System.out.println("Profesor");
        profesor.mostrarInformacion();
        System.out.println("");
        System.out.println("Empleado de Servicio");
        servicio.mostrarInformacion();
        System.out.println("");
        
        estudiante.matricularEnCurso("Medicina");
        profesor.cambiarEstadoCivil("Casado");
        profesor.cambiarDepartamento("Física");
        servicio.trasladarSeccion("Biblioteca");

        System.out.println("Estudiante");
        estudiante.mostrarInformacion();
        System.out.println("");
        System.out.println("Profesor");
        profesor.mostrarInformacion();
        System.out.println("");
        System.out.println("Empleado de Servicio");
        servicio.mostrarInformacion();
        
    }
    
}
