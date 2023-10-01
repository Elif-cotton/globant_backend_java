
package relacionesej3cartasespanolas;

import Entidad.Baraja;
import Entidad.Carta;

/**
 *
 * @author javer
 */
public class RelacionesEj3CartasEspanolas {

    public static void main(String[] args) {
       
        Baraja baraja = new Baraja();
    
        System.out.println("Baraja recién creada:");
        baraja.mostrarBaraja();
        System.out.println("Cartas disponibles en la baraja: " + baraja.cartasDisponibles());
        System.out.println();
    
        baraja.barajar();
        System.out.println("Baraja después de ser barajada:");
        baraja.mostrarBaraja();
        System.out.println("Cartas disponibles en la baraja: " + baraja.cartasDisponibles());
        System.out.println();
    
        Carta[] mano = baraja.darCartas(5);
        System.out.println("Cartas en la mano del jugador:");
        for (Carta carta : mano) {
            System.out.println(carta);
        }
        System.out.println("Cartas disponibles en la baraja: " + baraja.cartasDisponibles());
        System.out.println();
    
        System.out.println("Montón de cartas:");
        baraja.cartasMonton();
    }
    
    
}
