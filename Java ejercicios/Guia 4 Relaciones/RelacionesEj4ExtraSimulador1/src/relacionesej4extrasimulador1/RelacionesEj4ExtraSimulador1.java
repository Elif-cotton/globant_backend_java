
package relacionesej4extrasimulador1;

import Entidad.Alumno;
import Entidad.Simulador;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author javer
 */
public class RelacionesEj4ExtraSimulador1 {

    
    public static void main(String[] args) {
      
        List<String> nombres = Arrays.asList("Juan", "María", "Carlos", "Ana", "Pedro", "Laura", "Javier", "Elena", "Luis", "Carmen");
        List<String> apellidos = Arrays.asList("García", "Martínez", "López", "Rodríguez", "Pérez", "González", "Hernández", "Ruiz", "Díaz", "Sánchez");
        
        Simulador simulador = new Simulador(nombres, apellidos);
        
        List<Alumno> alumnos = simulador.generarAlumnos(20);
        simulador.mostrarListadoAlumnos(alumnos);
        
        simulador.votacion(alumnos);
        
        System.out.println("\nResultados de la votación:");
        simulador.mostrarResultados(alumnos);
        
        simulador.recuentoVotos(alumnos);
        
        System.out.println("\nSelección de facilitadores y suplentes:");
        simulador.seleccionarFacilitadores(alumnos);
    }
        
    
}
