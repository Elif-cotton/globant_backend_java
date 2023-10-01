
package relacionesej2ruleta;

import Entidad.Jugador;
import Entidad.RevolverDeAgua;
import Servicio.JuegoServicio;
import Servicio.JugadorServicio;
import Servicio.RevolverDeAguaServicio;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author javer
 */
public class RelacionesEj2Ruleta {
    private static Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");
   
    public static void main(String[] args) {
       
        System.out.print("Ingrese el número de jugadores (entre 1 y 6): ");
        int numJugadores = leer.nextInt();

        if (numJugadores < 1 || numJugadores > 6) {
            System.out.println("Número de jugadores inválido. Se utilizarán 6 jugadores por defecto.");
            numJugadores = 6;
        }
        
        ArrayList<Jugador> jugadores = new ArrayList<>();
        JugadorServicio jugadorServicio = new JugadorServicio();
        
        for (int i = 1; i <= numJugadores; i++) {
            jugadores.add(jugadorServicio.crearJugador(i));
        }

        RevolverDeAgua revolver = new RevolverDeAgua();
        RevolverDeAguaServicio revolverServicio = new RevolverDeAguaServicio();
        revolverServicio.llenarRevolver(revolver);

        JuegoServicio juegoServicio = new JuegoServicio(jugadores, revolver);

        juegoServicio.ronda(jugadorServicio, revolverServicio);
    
    }
    
}
