
package Servicio;

import Entidad.Jugador;
import Entidad.RevolverDeAgua;
import java.util.ArrayList;

/**
 *
 * @author javer
 */
public class JuegoServicio {
    
    private ArrayList<Jugador> jugadores;
    private RevolverDeAgua revolver;

    public JuegoServicio(ArrayList<Jugador> jugadores, RevolverDeAgua revolver) {
        this.jugadores = jugadores;
        this.revolver = revolver;
    }

    

    public void ronda(JugadorServicio jugadorServicio, RevolverDeAguaServicio revolverServicio) {
       
        for (Jugador jugador : jugadores) {
            System.out.println("Es el turno de: " + jugador.toString());
            jugadorServicio.disparo(jugador, revolver);
            if (jugador.estaMojado()) {
                System.out.println("¡" + jugador.toString() + " se mojó!");
                return;
            }
        }
    }
}
