import Entidad.Circunferencia;
import Servicio.CircunferenciaServicio;

public class Main {
    public static void main(String[] args) {

        CircunferenciaServicio cs=new CircunferenciaServicio();

        Circunferencia r1=cs.crearCircunferencia();

        //llamar métodos
        //cs.area(r1);
        //cs.perimetro(r1);
        System.out.println("El área es: "+ Math.ceil( cs.area(r1)));
        System.out.println("El perímetro es: "+ Math.ceil(cs.perimetro(r1)));
    }
}