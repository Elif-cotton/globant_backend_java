
package Entidad;

import java.util.Random;

/**
 *
 * @author javer
 */
public class Baraja {
    
    private Carta[] cartas;
    private int cartasDisponibles;
    private Carta[] monton;
    private int cartasMonton;

    public Baraja() {
        cartas = new Carta[40];
        String[] palos = {"espadas", "bastos", "oros", "copas"};
        int index = 0;
        for (String palo : palos) {
            for (int numero = 1; numero <= 12; numero++) {
                if (numero != 8 && numero != 9) {
                    cartas[index] = new Carta(numero, palo);
                    index++;
                }
            }
        }
        cartasDisponibles = 40;
        monton = new Carta[40];
        cartasMonton = 0;
    }

    public void barajar() {
        Random rnd = new Random();
        for (int i = cartas.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            Carta temp = cartas[index];
            cartas[index] = cartas[i];
            cartas[i] = temp;
        }
    }

    public Carta siguienteCarta() {
        if (cartasDisponibles == 0) {
            System.out.println("No hay más cartas en la baraja.");
            return null;
        }
        Carta carta = cartas[cartas.length - cartasDisponibles];
        cartasDisponibles--;
        monton[cartasMonton] = carta;
        cartasMonton++;
        return carta;
    }

    public int cartasDisponibles() {
        return cartasDisponibles;
    }

    public Carta[] darCartas(int cantidad) {
        if (cartasDisponibles < cantidad) {
            System.out.println("No hay suficientes cartas en la baraja.");
            return null;
        }
        Carta[] cartas = new Carta[cantidad];
        for (int i = 0; i < cantidad; i++) {
            cartas[i] = siguienteCarta();
        }
        return cartas;
    }

    public void cartasMonton() {
        if (cartasMonton == 0) {
            System.out.println("No ha salido ninguna carta todavía.");
        } else {
            for (int i = 0; i < cartasMonton; i++) {
                System.out.println(monton[i]);
            }
        }
    }

    public void mostrarBaraja() {
        for (int i = cartas.length - cartasDisponibles; i < cartas.length; i++) {
            System.out.println(cartas[i]);
        }
    }
}
