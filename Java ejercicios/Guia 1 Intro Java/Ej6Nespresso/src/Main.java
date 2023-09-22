import Entidades.Cafetera;
import Servicio.CafeteraServicio;

public class Main {
    public static void main(String[] args) {

        CafeteraServicio cs=new CafeteraServicio();

        Cafetera c1=cs.ingresarCafetera();

        //Métodos
        cs.llenarCafetera(c1);
        System.out.println("");
        cs.servirTaza(10, 8);
        System.out.println("");
        cs.vaciarCafetera(c1);
        System.out.println("");
        cs.agregarCafé(20.0);

    }
}