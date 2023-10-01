
package Entidad;

import java.util.ArrayList;

/**
 *
 * @author javer
 */
public class Equipo {
    
    ArrayList <Jugador> jugadorList=new ArrayList();

    public Equipo() {
    }
    
    

    public ArrayList<Jugador> getJugadorList() {
        return jugadorList;
    }

    public void setJugadorList(ArrayList<Jugador> jugadorList) {
        this.jugadorList = jugadorList;
    }

    @Override
    public String toString() {
        return "Equipo{" + "jugadorList=" + jugadorList + '}';
    }
    
    
    
    
}
