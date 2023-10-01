
package Servicio;

import Entidad.Baraja;
import Enumeracion.Palo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author javer
 */
public class BarajaServicio {
    
    private List<Baraja> barajaList;
    private List<Baraja> montonList;

    public BarajaServicio() {
        barajaList = new ArrayList<>();
        montonList = new ArrayList<>();
        for (int numero = 1; numero <= 12; numero++) {
            if (numero != 8 && numero != 9) {
                for (Palo palo : Palo.values()) {
                    barajaList.add(new Baraja(numero, palo));
                }
            }
        }
        barajar();
    }

    public void barajar() {
        Collections.shuffle(barajaList);
    }
    
     public Baraja siguienteCarta() {
        if (barajaList.isEmpty()) {
            System.out.println("No hay más cartas en la baraja.");
            return null;
        }
        Baraja siguiente = barajaList.remove(0);
        montonList.add(siguiente);
        return siguiente;
    }

    public int cartasDisponibles() {
        return barajaList.size();
    }
    
     public List<Baraja> darCartas(int cantidad) {
        List<Baraja> cartasRepartidas = new ArrayList<>();
        for (int i = 0; i < cantidad && !barajaList.isEmpty(); i++) {
            Baraja cartaRepartida = siguienteCarta();
            if (cartaRepartida != null) {
                cartasRepartidas.add(cartaRepartida);
            }
        }
        return cartasRepartidas;
    }
     
     public void cartasMonton() {
        if (montonList.isEmpty()) {
            System.out.println("Aún no se ha sacado ninguna carta.");
        } else {
            System.out.println("Cartas en el montón:");
            for (Baraja baraja : montonList) {
                System.out.println(baraja);
            }
        }
    }

    public void mostrarBaraja() {
        for (Baraja Baraja : barajaList) {
            System.out.println(Baraja);
        }
    } 
}
