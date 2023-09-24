import Entidades.Nif;
import Servicio.NifServicio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");

        NifServicio ns=new NifServicio();

        Nif n1=ns.crearNif();
        Nif n2=ns.crearNif();

        ns.mostrar(n1);
        ns.mostrar(n2);

    }
}