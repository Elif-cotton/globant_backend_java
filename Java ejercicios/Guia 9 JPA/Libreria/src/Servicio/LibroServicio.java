
package Servicio;

import Entidades.Autor;
import Entidades.Editorial;
import Entidades.Libro;
import Persistencia.LibroDAO;
import java.util.Scanner;

/**
 *
 * @author javer
 */
public class LibroServicio {
    
    Scanner leer=new Scanner(System.in).useDelimiter("\n");
    
    LibroDAO dao=new LibroDAO();
    
    public void crearLibro(){
       AutorServicio as=new AutorServicio();
       EditorialServicio es=new EditorialServicio();
       Libro libro=new Libro();
          
        System.out.println("Ingrese el ISBN del libro");
        long isbn=leer.nextLong();
        libro.setIsbn(isbn);
        System.out.println("Ingrese el nombre del libro");
        String titulo=leer.next();
        libro.setTitulo(titulo);
        System.out.println("Ingrese el año de edición del libro");
        Integer anio=leer.nextInt();
        libro.setAnio(anio);
        System.out.println("Ingrese la cantidad de ejemplares");
        Integer cantidadEjemplares=leer.nextInt();
        libro.setEjemplares(cantidadEjemplares);
        libro.setEjemplaresPrestados(0);
        libro.setEjemplaresRestantes(cantidadEjemplares);
        libro.setAlta(true);       
        
        Autor autor= as.crearAutor();
        libro.setAutor(autor);
        Editorial editorial = es.crearEditorial();
        libro.setEditorial(editorial);
        
        dao.guardar(libro);
        
    }
    
    public void darBaja(){
        System.out.println("Ingrese el ISBN del libro que desea dar de baja");
        long isbn=leer.nextLong();
        Libro libro=dao.buscarLibroIsbn(isbn);
        libro.setAlta(false);
        dao.editar(libro);
    }
    
    
}
