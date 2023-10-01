
package Servicio;

import Entidad.Jugador;
import Entidad.RevolverDeAgua;

/**
 *
 * @author javer
 */
public class JugadorServicio {
    
    public Jugador crearJugador(int id) {
        return new Jugador(id);
    }

    
    public void disparo(Jugador jugador, RevolverDeAgua r) {
        RevolverDeAguaServicio revolverServicio = new RevolverDeAguaServicio();
        
        if(!jugador.estaMojado()){
            if(revolverServicio.mojar(r)){
                jugador.setMojado(true);
            }else{
                revolverServicio.siguienteChorro(r);
            }
        }
        
    }
}
