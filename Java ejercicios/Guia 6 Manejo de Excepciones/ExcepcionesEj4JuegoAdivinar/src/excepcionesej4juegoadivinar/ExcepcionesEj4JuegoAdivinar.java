
package excepcionesej4juegoadivinar;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author javer
 */
public class ExcepcionesEj4JuegoAdivinar {

    private static final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    public static void main(String[] args) {
        
       
        Random random = new Random();
        int numeroAdivinar = random.nextInt(500) + 1;
        int intentos = 0;

        System.out.println("Bienvenido al juego de adivinar un número entre 1 y 500.");

        while (true) {
            System.out.print("Ingrese un número: ");
            String entrada = leer.nextLine();

            try {
                int numeroUsuario = Integer.parseInt(entrada);
                intentos++;

                if (numeroUsuario == numeroAdivinar) {
                    System.out.println("¡Felicidades! Ha adivinado el número " + numeroAdivinar);
                    System.out.println("Número de intentos: " + intentos);
                    break;
                } else if (numeroUsuario < numeroAdivinar) {
                    System.out.println("El número a adivinar es mayor.");
                } else {
                    System.out.println("El número a adivinar es menor.");
                }
            } catch (NumberFormatException e) {
                intentos++;
                System.out.println("Error: Debe ingresar un número válido.");
            }
        }

        leer.close();
        
        
        
    }
    
}
