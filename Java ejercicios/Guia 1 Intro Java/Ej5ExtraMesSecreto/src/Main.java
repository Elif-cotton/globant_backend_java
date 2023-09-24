import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random rn = new Random();
        Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");

        String[] meses={
                "enero","febrero","marzo","abril","mayo","junio","julio",
                "agosto","septiembre","octubre","noviembre","diciembre"};

        String mesSecreto=meses[rn.nextInt(12)];

        System.out.println("Adivina el mes secreto");
        System.out.print("Introduzca el nombre del mes en minúsculas: ");
        String mesIngresado = "";

        boolean esCorrecto = false;

        while (!esCorrecto) {
            mesIngresado = leer.next().toLowerCase();
            esCorrecto = mesSecreto.equals(mesIngresado);

            if (!esCorrecto) {
                System.out.println("No ha acertado.");
                System.out.print("Intente adivinarlo introduciendo otro mes: ");
            }
        }

        System.out.println("¡Ha acertado!");


    }
}