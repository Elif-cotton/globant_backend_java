
package Entidad;

import Servicio.Metodos;

/**
 *
 * @author javer
 */
public class Baraja {
    
    private Carta cartas[];
    private int posSiguienteCarta;
    
    //Constante
    public static final int NUM_CARTAS = 40;

    public Baraja() {
        cartas = new Carta[NUM_CARTAS]; // Inicializar el array cartas
        crearBaraja(); // Llamar al método para crear la baraja ordenada
        posSiguienteCarta = 0; // Inicializar la posición siguienteCarta
    }

    public Baraja(Carta[] cartas, int posSiguienteCarta) {
        this.cartas = cartas;
        this.posSiguienteCarta = posSiguienteCarta;
    }

    public Carta[] getCartas() {
        return cartas;
    }

    public void setCartas(Carta[] cartas) {
        this.cartas = cartas;
    }

    public int getPosSiguienteCarta() {
        return posSiguienteCarta;
    }

    public void setPosSiguienteCarta(int posSiguienteCarta) {
        this.posSiguienteCarta = posSiguienteCarta;
    }
    
    //Crear la baraja ordenada
    private void crearBaraja() {

        String[] palos = Carta.PALOS;

        //Recorro los palos
        for (int i = 0; i < palos.length; i++) {

            //Recorro los números
            for (int j = 0; j < Carta.LIMITE_CARTA_PALO; j++) {
                //Las posiciones del 8 y del 9 son el 7 y el 8 (emepzamos en 8)
                if (!(j == 7 || j == 8)) {
                    if (j >= 9) {
                        //Solo para la sota, caballo y rey
                        cartas[((i * (Carta.LIMITE_CARTA_PALO - 2)) + (j - 2))] = new Carta(j + 1, palos[i]);
                    } else {
                        //Para los casos de 1 a 7
                        cartas[((i * (Carta.LIMITE_CARTA_PALO - 2)) + j)] = new Carta(j + 1, palos[i]);
                    }

                }
            }

        }

    }
    
    //Baraja todas las cartas
    
    public void barajar() {

        int posAleatoria = 0;
        Carta c;

        //Recorro las cartas
        for (int i = 0; i < cartas.length; i++) {

            posAleatoria = Metodos.generaNumeroEnteroAleatorio(0, NUM_CARTAS - 1);

            //intercambio
            c = cartas[i];
            cartas[i] = cartas[posAleatoria];
            cartas[posAleatoria] = c;

        }

        //La posición vuelve al inicio
        this.posSiguienteCarta = 0;

    }
    
     //Devuelve la casta donde se encuentre "posSiguienteCarta"
    public Carta siguienteCarta() {

        Carta carta = null;

        if (posSiguienteCarta == NUM_CARTAS) {
            System.out.println("Ya no hay mas cartas, baraja otra vez");
        } else {
            carta = cartas[posSiguienteCarta++];
        }

        return carta;

    }

     //Devuelve un número de cartas. Controla si hay más cartas de las que se piden 
    public Carta[] darCartas(int numCartas) {

        if (numCartas > NUM_CARTAS) {
            System.out.println("No se puede dar más cartas de las que hay");
        } else if (cartasDisponible() < numCartas) {
            System.out.println("No hay suficientes cartas que mostrar");
        } else {

            Carta[] cartasDar = new Carta[numCartas];

            //recorro el array que acabo de crear para rellenarlo
            for (int i = 0; i < cartasDar.length; i++) {
                cartasDar[i] = siguienteCarta(); //uso el metodo anterior
            }
            
            //Lo devuelvo
            return cartasDar;

        }

        //solo en caso de error
        return null;

    }

    //Indica el numero de cartas que hay disponibles
    public int cartasDisponible() {
        return NUM_CARTAS - posSiguienteCarta;
    }

    //Muestro las cartas que ya han salido
    public void cartasMonton() {

        if (cartasDisponible() == NUM_CARTAS) {
            System.out.println("No se ha sacado ninguna carta");
        } else {
            //Recorro desde 0 a la posSiguienteCarta
            for (int i = 0; i < posSiguienteCarta; i++) {
                System.out.println(cartas[i]);
            }
        }

    }

    //Muestro las cartas que aun no han salido
    public void mostrarBaraja() {

        if (cartasDisponible() == 0) {
            System.out.println("No hay cartas que mostrar");
        } else {
            for (int i = posSiguienteCarta; i < cartas.length; i++) {
                System.out.println(cartas[i]);
            }
        }

    }

}
