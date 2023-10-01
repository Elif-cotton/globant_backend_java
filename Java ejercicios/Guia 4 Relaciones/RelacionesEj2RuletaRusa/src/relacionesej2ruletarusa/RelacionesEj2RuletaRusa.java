
package relacionesej2ruletarusa;

import Entidad.Juego;
import Entidad.Jugador;
import Entidad.RevolverDeAgua;
import Servicio.JuegoServicio;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author javer
 */
public class RelacionesEj2RuletaRusa {
    private static Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");
   
    public static void main(String[] args) {
        
        System.out.print("Ingrese el número de jugadores (entre 1 y 6): ");
        int numJugadores = leer.nextInt();

        if (numJugadores < 1 || numJugadores > 6) {
            numJugadores = 6; // Por defecto, 6 jugadores
        }

        ArrayList<Jugador> jugadores = new ArrayList<>();
        for (int i = 1; i <= numJugadores; i++) {
            jugadores.add(new Jugador(i));
        }

        RevolverDeAgua revolver = new RevolverDeAgua();
        Juego juego = new Juego(jugadores, revolver);
        JuegoServicio juegoServicio = new JuegoServicio();

        juegoServicio.llenarJuego(juego.getJugadores(), juego.getRevolver());

        while (true) {
            juegoServicio.ronda(juego);

            boolean todosMojados = true;
            for (Jugador jugador : jugadores) {
                if (!jugador.estaMojado()) {
                    todosMojados = false;
                    break;
                }
            }

            if (todosMojados) {
                break;
            }

            juegoServicio.llenarJuego(jugadores, revolver);
        }
        

       leer.close();
    
    }
    
}
