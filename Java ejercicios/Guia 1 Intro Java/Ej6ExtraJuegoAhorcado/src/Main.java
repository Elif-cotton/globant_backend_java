import Entidades.Ahorcado;
import Servicio.AhorcadoServicio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");

        AhorcadoServicio as=new AhorcadoServicio();

        Ahorcado ahorcado=as.crearJuego();

        as.longitud(ahorcado);

        System.out.println("La longitud de la palabra a adivinar es: "+as.longitud(ahorcado));

        System.out.println("Ingrese la letra a buscar: ");
        String letra1 = leer.nextLine();

        if (letra1.length() != 1 || !Character.isLowerCase(letra1.charAt(0))) {
            System.out.println("Debes ingresar una letra en minúscula.");
            return;
        }

        char letra = letra1.charAt(0);

        as.buscar(letra);
    }
}