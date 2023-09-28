import Entidades.Libro;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    private static Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");
    public static void main(String[] args) {

        HashSet <Libro> librosList=new HashSet();

        boolean salir=false;
        String respuesta;

        while(!salir){
            System.out.println("Creando un libro");
            System.out.println("Ingrese el título: ");
            String nombre=leer.next();
            System.out.println("Ingrese el autor: ");
            String autor=leer.next();
            System.out.println("Ingrese el número de libros existentes: ");
            int numeroLibros=leer.nextInt();
            System.out.println("Ingrese el número de libros prestados: ");
            int librosPrestados=leer.nextInt();
            while (librosPrestados >= numeroLibros) {
                System.out.println("El número de libros prestados debe ser menor que el número de libros existentes.");
                System.out.println("Ingrese el número de libros prestados nuevamente: ");
                librosPrestados = leer.nextInt();
            }

            librosList.add(new Libro(nombre, autor, numeroLibros,librosPrestados));

            System.out.println("¿Quiere crear otro libro? (s/n)");
            respuesta = leer.next();

            if(respuesta.equalsIgnoreCase("n")){
                salir=true;
            }
        }

        mostrarLibros(librosList);
        prestarLibros(librosList);
        mostrarLibros(librosList);
        devolucionLibros(librosList);
        mostrarLibros(librosList);

    }

    public static void mostrarLibros(HashSet<Libro> librosList){

        System.out.println("Los libros de la librería son: ");
        for (Libro libro : librosList) {
            System.out.println(libro);
        }
    }

    public static void prestarLibros(HashSet <Libro> librosList){

        System.out.println("Ingrese el título del libro que desea que le presten: ");
        String nombre=leer.next();

        for (Libro libro : librosList) {
            if (libro.getTituloLibro().equalsIgnoreCase(nombre)){
                if(libro.prestamo()){
                    System.out.println("Préstamo realizado con éxito");
                }else{
                    System.out.println("No me quedan ejemplares disponibles");
                }
                return;
            }
        }
        System.out.println("El libro no se encuentra en la biblioteca");
    }

    public static void devolucionLibros(HashSet <Libro> librosList){

        System.out.println("Ingrese el título del libro que desea devolver: ");
        String nombre=leer.next();

        for (Libro libro : librosList) {
            if(libro.getTituloLibro().equalsIgnoreCase(nombre)){
                if(libro.devolucion()){
                    System.out.println("El libro fue devuelto correctamente");
                }else{
                    System.out.println("No hay ejemplares prestados para devolución");
                }
                return;
            }

        }
        System.out.println("El libro no es de esta biblioteca");
    }

}
