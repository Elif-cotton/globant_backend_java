
package relacionesej3cartasespanoles;

import Entidad.Baraja;
import Servicio.BarajaServicio;
import java.util.List;

/**
 *
 * @author javer
 */
public class RelacionesEj3CartasEspanoles {

    public static void main(String[] args) {
    
        BarajaServicio barajaServicio = new BarajaServicio();

        // Repartir cartas
        List<Baraja> cartasRepartidas = barajaServicio.darCartas(5);
        System.out.println("Cartas repartidas:");
        for (Baraja Baraja : cartasRepartidas) {
            System.out.println(Baraja);
        }

        // Mostrar información de la baraja
        System.out.println("Cartas disponibles en la baraja: " + barajaServicio.cartasDisponibles());

        // Mostrar cartas en el montón
        barajaServicio.cartasMonton();

        // Sacar una carta y mostrar la baraja
        Baraja cartaSacada = barajaServicio.siguienteCarta();
        System.out.println("Carta sacada: " + cartaSacada);
        System.out.println("Cartas disponibles en la baraja después de sacar una carta: " + barajaServicio.cartasDisponibles());

        // Mostrar cartas en el montón nuevamente
        barajaServicio.cartasMonton();
    
        
    }
    
}
