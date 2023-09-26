package Servicio;

import Entidades.Pelicula;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PeliculaServicio {
    private static Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");

    ArrayList <Pelicula> peliculasList= new ArrayList();

    public void crearPelicula(){

        boolean crearOtraPelicula = true;
        while (crearOtraPelicula) {

            System.out.print("Ingrese el título de la película: ");
            String titulo = leer.nextLine();

            System.out.print("Ingrese el director de la película: ");
            String director = leer.nextLine();

            System.out.print("Ingrese la duración de la película en horas: ");
            int duracion = leer.nextInt();

            peliculasList.add(new Pelicula(titulo, director, duracion));

            System.out.print("¿Desea crear otra película? (Sí: s, No: n): ");
            String opcion = leer.nextLine().toLowerCase();
            crearOtraPelicula = opcion.equals("s");
        }
        leer.close();

    }

    public ArrayList<Pelicula> getPeliculas() {

        return peliculasList;
    }

    public PeliculaServicio() {

        peliculasList.add(new Pelicula("Titanic", "James Cameron", 3));
        peliculasList.add(new Pelicula("Avatar", "James Cameron", 2));
        peliculasList.add(new Pelicula("Oppenheimer", "Christopher Nolan", 3));
        peliculasList.add(new Pelicula("Star Trek", "Akiva Goldsman", 1));
    }

    public void mostrarPeliculas() {

        for (Pelicula pelicula : peliculasList) {
            System.out.println(pelicula.toString());
        }
    }

    public void mostrarPeliculasMasDeUnaHora() {
        System.out.println("**** Películas con duración mayor a 1 hora:");
        for (Pelicula pelicula : peliculasList) {
            if (pelicula.getDuracion() > 1) {
                System.out.println(pelicula);
            }
        }
    }

    public void ordenarPeliculasPorDuracionMayorAMenor() {
        Collections.sort(peliculasList, (Pelicula p1, Pelicula p2) -> Double.compare(p2.getDuracion(), p1.getDuracion()));

        System.out.println("**** Listado de películas ordenadas por duración (de mayor a menor):");
        for (Pelicula pelicula : peliculasList) {
            System.out.println(pelicula);
        }
    }

    public void ordenarPeliculasPorDuracionMenorAMayor() {
        Collections.sort(peliculasList, (Pelicula p1, Pelicula p2) -> Double.compare(p1.getDuracion(), p2.getDuracion()));

        System.out.println("**** Listado de películas ordenadas por duración (de menor a mayor):");
        for (Pelicula pelicula : peliculasList) {
            System.out.println(pelicula);
        }
    }

    public void ordenarPeliculasPorTitulo() {
        Collections.sort(peliculasList, (Pelicula p1, Pelicula p2) -> p1.getTitulo().compareToIgnoreCase(p2.getTitulo()));

        System.out.println("**** Listado de películas ordenadas por título:");
        for (Pelicula pelicula : peliculasList) {
            System.out.println(pelicula);
        }
    }

    public void ordenarPeliculasPorDirector() {
        Collections.sort(peliculasList, (Pelicula p1, Pelicula p2) -> p1.getDirector().compareToIgnoreCase(p2.getDirector()));

        System.out.println("**** Listado de películas ordenadas por director:");
        for (Pelicula pelicula : peliculasList) {
            System.out.println(pelicula);
        }
    }
}
