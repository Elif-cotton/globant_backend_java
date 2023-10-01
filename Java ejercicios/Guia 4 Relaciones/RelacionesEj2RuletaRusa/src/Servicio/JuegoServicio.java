
package Servicio;

import Entidad.Juego;
import Entidad.Jugador;
import Entidad.RevolverDeAgua;
import java.util.ArrayList;

/**
 *
 * @author javer
 */
public class JuegoServicio {
    
    public void llenarJuego(ArrayList<Jugador> jugadores, RevolverDeAgua revolver) {
        for (Jugador jugador : jugadores) {
            jugador.mojar(); // Reinicia el estado de mojado
        }
    }
    
    public void ronda(Juego juego) {
        RevolverDeAgua revolver = juego.getRevolver();
        ArrayList<Jugador> jugadores = juego.getJugadores();

        int jugadorIndex = 0;
        while (true) {
            Jugador jugadorActual = jugadores.get(jugadorIndex);
            if (disparo(jugadorActual, revolver)) {
                System.out.println("¡" + jugadorActual + " se mojó!");
                break;
            }
            jugadorIndex = (jugadorIndex + 1) % jugadores.size();
        }
    }

    private boolean disparo(Jugador jugador, RevolverDeAgua revolver) {
        JugadorServicio jugadorServicio = new JugadorServicio();
        return jugadorServicio.disparo(jugador, revolver);
    }
    
}
