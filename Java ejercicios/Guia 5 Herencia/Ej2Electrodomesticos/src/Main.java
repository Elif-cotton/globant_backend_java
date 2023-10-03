import Entidades.Lavadora;
import Entidades.Televisor;

public class Main {
    public static void main(String[] args) {

        Lavadora l = new Lavadora();
        l.crearLavadora();

        Televisor t = new Televisor();
        t.crearTelevisor();

        System.out.println("Precio final lavadora: " + l.precioFinal());
        System.out.println("Precio final televisor: " + t.precioFinal());

    }
}