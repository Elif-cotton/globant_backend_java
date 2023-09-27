import Servicio.NumeroServicio;

public class Main {
    public static void main(String[] args) {
        NumeroServicio ns=new NumeroServicio();

        ns.agregarNumeros();
        System.out.println("");
        System.out.println("Los número son: ");
        ns.mostrarNumeros();
        ns.mostrarResultados();
    }
}