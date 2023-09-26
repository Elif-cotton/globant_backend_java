import Servicio.PeliculaServicio;

public class Main {
    public static void main(String[] args) {
        PeliculaServicio ps = new PeliculaServicio();

        ps.mostrarPeliculas();
        ps.mostrarPeliculasMasDeUnaHora();
        ps.ordenarPeliculasPorDuracionMayorAMenor();
        ps.ordenarPeliculasPorDuracionMenorAMayor();
        ps.ordenarPeliculasPorTitulo();
        ps.ordenarPeliculasPorDirector();
        ps.mostrarPeliculas();
    }
}