import Servicio.CodigoPostalServicio;

import java.util.Scanner;

public class Main {
    private static Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");
    public static void main(String[] args) {

        CodigoPostalServicio cp=new CodigoPostalServicio();

        cp.mostrarCiudad();

        System.out.println("");
        System.out.print("Ingrese el código postal a consultar: ");
        String codigo = leer.next();
        cp.buscarPorCodigoPostal(codigo);

        System.out.println("");
        System.out.println("Agregar ciudad");
        System.out.print("Ingrese el código postal de la ciudad: ");
        codigo = leer.next();
        System.out.print("Ingrese la ciudad: ");
        String ciudad = leer.next();
        cp.agregarCiudad(codigo, ciudad);
        cp.mostrarCiudad();

        System.out.println("");
        // Elimina 3 ciudades existentes dentro del HashMap,
        // que pida el usuario.
        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese la ciudad a eliminar:");
            ciudad = leer.next();
            cp.eliminarCiudad(ciudad);
        }
        cp.mostrarCiudad();

    }
}