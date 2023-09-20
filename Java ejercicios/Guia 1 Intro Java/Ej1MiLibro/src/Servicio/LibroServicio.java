package Servicio;

import Entidades.Libro;

import java.util.Scanner;

public class LibroServicio {

    private Scanner leer=new Scanner(System.in).useDelimiter("\n");

    public Libro crearLibro(){
        //intanciar un objeto tipo libro
        Libro l1=new Libro();

        //ingresar datos
        System.out.println("Ingrese el ISBN del libro");
        l1.setIsbn(leer.next());
        System.out.println("Ingrese el título del libro");
        l1.setTitulo(leer.next());
        System.out.println("Ingrese el autor del libro");
        l1.setAutor(leer.next());
        System.out.println("Ingrese el número de las páginas del libro");
        l1.setNumeroPaginas(leer.nextInt());

        return l1;
    }

    //método
    public void imprimirInformación(Libro l1){

        System.out.println("ISBN: " + l1.getIsbn());
        System.out.println("Título: " + l1.getTitulo());
        System.out.println("Autor: " + l1.getAutor());
        System.out.println("Número de páginas: " + l1.getNumeroPaginas());
    }

}
