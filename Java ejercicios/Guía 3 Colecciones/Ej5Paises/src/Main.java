import Servicio.PaisServicio;

public class Main {
    public static void main(String[] args) {

        PaisServicio ps=new PaisServicio();

        //ps.crearPais();

        ps.mostrarPaises();

        ps.mostrarPaisesOrdenados();

        ps.eliminarPais();
    }
}