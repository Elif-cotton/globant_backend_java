import Entidades.Lavadora;
import Entidades.Televisor;
import Servicio.LavadoraServicio;
import Servicio.TelevisorServicio;

public class Main {
    public static void main(String[] args) {

        LavadoraServicio ls=new LavadoraServicio();
        TelevisorServicio ts=new TelevisorServicio();

        System.out.println("Crea lavadora");
        Lavadora lavadora=ls.crearLavadora();
        System.out.println("Crear Televisor");
        Televisor televisor=ts.crearTelevisor();

        ls.precioFinal(lavadora);
        System.out.println("");
        ts.precioFinal(televisor);

    }
}