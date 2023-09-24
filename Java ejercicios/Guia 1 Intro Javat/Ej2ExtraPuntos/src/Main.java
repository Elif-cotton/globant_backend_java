import Entidades.Punto;
import Servicio.PuntoServicio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");

        PuntoServicio ps=new PuntoServicio();

        Punto p=ps.crearPuntos();

        System.out.println("Datos: " + p.toString());

        System.out.println("");

        ps.calcularDistancia(p);

        System.out.println("");


    }
}