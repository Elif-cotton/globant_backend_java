
package relacionesej3cartasapp;

import Entidad.Baraja;
import Entidad.Carta;

/**
 *
 * @author javer
 */
public class RelacionesEj3CartasApp {

    
    public static void main(String[] args) {
     
         //Creamos la baraja
        Baraja baraja = new Baraja();
        
        //Mostramos las cartas disponibles (40)
        System.out.println("Hay "+baraja.cartasDisponible()+" cartas disponibles");
       
        //Saco una carta
        baraja.siguienteCarta();
        
        //Saco 5 cartas
        baraja.darCartas(5);
        
        //Mostramos las cartas disponibles (34)
        System.out.println("Hay "+baraja.cartasDisponible()+" cartas disponibles");
       
        System.out.println("Cartas sacadas de momento");
        
        baraja.cartasMonton();
        
        
        //Barajamos de nuevo
        baraja.barajar();
       
        //Saco 5 cartas
        Carta[] c = baraja.darCartas(5);
        
        System.out.println("Cartas sacadas después de barajar ");
        for(int i=0;i<c.length;i++){
            System.out.println(c[i]);
        }
        
    
    }
    
}
