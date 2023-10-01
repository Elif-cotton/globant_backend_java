
package relacionesej4extrasimulador;

import Entidad.Alumno;
import Entidad.Simulador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javer
 */
public class RelacionesEj4ExtraSimulador {

    public static void main(String[] args) {
        List<String> nombres =Simulador.generarNombresAleatorios(10); 
        List<String> dnis = Simulador.generarDNIs(10); 
        List<Alumno> alumnos = new ArrayList<>();
        
        Simulador.crearAlumnos(nombres, dnis, 10);
        System.out.println("Listado de Alumnos:");
        Simulador.imprimirListadoAlumnos(alumnos);
        
        Simulador.votacion(alumnos);
        
        System.out.println("\nResultados de la Votación:");
        Simulador.mostrarResultados(alumnos);

        Simulador.recuentoVotos(alumnos);
    
    }
    
}
