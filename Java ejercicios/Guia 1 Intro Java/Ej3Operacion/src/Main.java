import Entidades.Operacion;
import Servicio.OperacionServicio;

public class Main {
    public static void main(String[] args) {

        OperacionServicio os=new OperacionServicio();

        Operacion o1=os.ingresarNumeros();

        //llamar métodos

        System.out.println("La suma es: "+ os.sumar(o1));
        System.out.println("La resta es: "+ os.restar(o1));
        System.out.println("La multiplicación es: "+ os.multiplicar(o1));
        System.out.println("La división es: "+ os.dividir(o1));
    }
}