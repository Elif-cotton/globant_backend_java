
package relacionesejemplojugador;

import Entidad.Equipo;
import Entidad.Jugador;
import java.util.ArrayList;

/**
 *
 * @author javer
 */
public class RelacionesEjemploJugador {

    public static void main(String[] args) {
    
        Jugador jugador1=new Jugador();
        jugador1.setNombre("Nicolás");
        jugador1.setApellido("Perez");
        jugador1.setPosicion("delantero");
        jugador1.setNumero(12);
        
        Jugador jugador2=new Jugador();
        jugador2.setNombre("Luis");
        jugador2.setApellido("Vargas");
        jugador2.setPosicion("medio");
        jugador2.setNumero(9);
        
        Jugador jugador3=new Jugador();
        jugador3.setNombre("Robert");
        jugador3.setApellido("Alvarez");
        jugador3.setPosicion("punta");
        jugador3.setNumero(2);
        
        ArrayList <Jugador> jugadorList=new ArrayList();
        jugadorList.add(jugador1);
        jugadorList.add(jugador2);
        jugadorList.add(jugador3);
        
        Equipo equipo=new Equipo();
        equipo.setJugadorList(jugadorList);
        
        for (Jugador jugador : jugadorList) {
            System.out.println(jugador.toString());
        }
        
        
    }
    
}
