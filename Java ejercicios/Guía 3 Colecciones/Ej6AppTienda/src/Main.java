import Servicio.ProductoServicio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");
        ProductoServicio ps=new ProductoServicio();

        ps.menu();
    }
}