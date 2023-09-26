import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> razasPerros = new ArrayList<>();
        Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");

        System.out.println("Bienvenido al registro de razas de perros.");
        boolean continuar = true;

        do {
            System.out.print("¿Desea guardar una raza de perro? (si/no): ");
            String respuesta;

            // Bucle interno para asegurar respuesta válida
            do {
                respuesta = leer.nextLine();
                if (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no")) {
                    System.out.println("Respuesta incorrecta. Por favor, ingrese 'si' o 'no'.");
                }
            } while (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no"));

            if (respuesta.equalsIgnoreCase("si")) {
                System.out.print("Ingrese la raza del perro: ");
                String raza = leer.nextLine().toLowerCase();
                // Agregar la raza a la lista
                razasPerros.add(raza);
            } else {
                continuar = false;
            }
        } while (continuar);

        // Mostrar todas las razas de perros guardadas
        System.out.println("\nRazas de perros guardadas:");
        for (String raza : razasPerros) {
            System.out.println(raza);
        }

        // Pedir al usuario el perro a buscar y eliminar
        System.out.print("\nIngrese el perro a buscar y eliminar: ");
        String perroABuscar = leer.nextLine();

        // Buscar y eliminar el perro de la lista
        boolean encontrado = false;
        Iterator<String> iterator = razasPerros.iterator();
        while (iterator.hasNext()) {
            String raza = iterator.next();
            if (raza.equalsIgnoreCase(perroABuscar)) {
                iterator.remove();
                encontrado = true;
            }
        }

        // Mostrar la lista ordenada
        Collections.sort(razasPerros);
        if (encontrado) {
            System.out.println("\nPerro eliminado. Lista de perros actualizada:");
        } else {
            System.out.println("\nEl perro no se encontró en la lista. Lista de perros:");
        }

        for (String raza : razasPerros) {
            System.out.println(raza);
        }

    }
}