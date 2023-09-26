package Servicio;

import java.util.*;

public class PaisServicio {
    private static Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
    HashSet<String> paisesList = new HashSet();

    public void crearPais() {

        boolean crearOtroPais = true;
        while (crearOtroPais) {

            System.out.print("Ingrese el nombre del País: ");
            String pais = leer.nextLine();

            paisesList.add(pais);

            System.out.print("¿Desea agregar otro país? (Sí: s, No: n): ");
            String opcion = leer.nextLine().toLowerCase();
            crearOtroPais = opcion.equals("s");
        }
        leer.close();
    }

    public PaisServicio() {
        System.out.println("Mostrar el conjunto de paises");
        // paises = new HashSet<>(Arrays.asList("Ecuador", "Venezuela", "Colombia", "Peru",
        //                     "Brazil", "Argentina", "Uruguay"));

        paisesList.add("Alemania");
        paisesList.add("Chile");
        paisesList.add("Canadá");
        paisesList.add("España");
        paisesList.add("China");
        paisesList.add("Korea");
        paisesList.add("Brasil");

    }

    public void mostrarPaises() {

        for (String pais : paisesList) {
            System.out.println(pais);
        }

    }

    public void mostrarPaisesOrdenados() { //convertir conjunto a lista y usar Collections.sort()

        ArrayList<String> listaPaises = new ArrayList(paisesList);
        Collections.sort(listaPaises);

        System.out.println("Conjunto ordenado alfabéticamente:");
        for (String pais : listaPaises) {
            System.out.println(pais);
        }
    }

    public void eliminarPais() {

        System.out.print("Ingrese el nombre de un País que desa eliminar: ");
        String paisIngresado = leer.nextLine();

        Iterator<String> it = paisesList.iterator();
        boolean encontrado = false;
        while (it.hasNext()) {
            if (it.next().equalsIgnoreCase(paisIngresado)) {
                it.remove();
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            System.out.println("País eliminado correctamente. Conjunto actualizado:");
            mostrarPaises();
        } else {
            System.out.println("El país no se encuentra en el conjunto.");
        }
    }
}
