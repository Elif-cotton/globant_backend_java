import Entidades.Movil;
import Servicio.MovilServicio;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        MovilServicio ms=new MovilServicio();

        Movil m=ms.cargarCelular();

        ms.ingresarCodigo(m);

        System.out.println("Código: " + Arrays.toString(m.getCodigo()));
        System.out.println("Datos: "+m.toString());
    }
}