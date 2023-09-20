import Entidades.Libro;
import Servicio.LibroServicio;

public class Main {
    public static void main(String[] args) {

        LibroServicio ls=new LibroServicio();

        //intanciación
        Libro l1=ls.crearLibro();

        //llamar a los métodos
        ls.imprimirInformación(l1);
    }
}