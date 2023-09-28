import Entidades.CantanteFamoso;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
    public static void main(String[] args) {

            ArrayList<CantanteFamoso> cantantesList = new ArrayList();

            //agregar 5 cantantes famosos o bandas
            cantantesList.add(new CantanteFamoso("BTS", "Dynamite"));
            cantantesList.add(new CantanteFamoso("Jungkook", "Seven"));
            cantantesList.add(new CantanteFamoso("Seventeen", "Super"));
            cantantesList.add(new CantanteFamoso("CNBLUE", "I am sorry"));
            cantantesList.add(new CantanteFamoso("Blackpink", "Pink Venom"));

            //mostrar
            for (CantanteFamoso cantante : cantantesList) {
                System.out.println(cantante);
            }

            //crear un menú con un bucle
            boolean salir = false;
            int opcion;
            String nombre;
            String cancion;

            while (!salir) {
                System.out.println("");
                System.out.println("**********MENÚ OPCIONES**********");
                System.out.println("1. Agregar un cantante más ");
                System.out.println("2. Mostrar todos los cantantes ");
                System.out.println("3. Eliminar un cantante ");
                System.out.println("4. Salir");
                System.out.println("");
                System.out.println("Elija una opción");
                opcion = leer.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el nombre del cantante: ");
                        nombre = leer.next();
                        System.out.println("Ingrese la canción con más ventas: ");
                        cancion = leer.next();
                        cantantesList.add(new CantanteFamoso(nombre, cancion));
                        break;
                    case 2:
                        for (CantanteFamoso cantante : cantantesList) {
                            System.out.println(cantante);
                        }
                        break;
                    case 3:
                        System.out.println("Ingrese el nombre del cantante que desea eliminar: ");
                        nombre = leer.next();
                        //otra forma
                        //cantantesList.removeIf(cantante->cantante.getNombre().equals(nombre);
                        boolean encontrado = false;
                        for (int i = 0; i < cantantesList.size(); i++) {
                            CantanteFamoso cantante = cantantesList.get(i);
                            if (cantante.getNombre().equalsIgnoreCase(nombre)) {
                                cantantesList.remove(i);
                                System.out.println("El cantante fue eliminado correctamente");
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado)
                            System.out.println("No se encontró ese cantante");
                        break;
                    case 4:
                        salir = true;
                        System.out.println("Saliendo*******");
                        break;
                    default:
                        System.out.println("Elija una opción valida");
                        break;
                }

            }

    }
}