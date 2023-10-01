
package Servicio;

import Entidad.Jugador;
import Entidad.RevolverDeAgua;

/**
 *
 * @author javer
 */
public class JugadorServicio {
    
    public boolean disparo(Jugador jugador, RevolverDeAgua revolver) {
        if (revolver.mojar()) {
            jugador.mojar();
            return true;
        } else {
            revolver.siguienteChorro();
            return false;
        }
    }
}
