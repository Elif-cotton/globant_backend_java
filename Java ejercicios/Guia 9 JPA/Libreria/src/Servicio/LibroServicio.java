
package Servicio;

import Entidades.Autor;
import Entidades.Editorial;
import Entidades.Libro;
import Persistencia.LibroDAO;
import java.util.List;
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
    
    public void buscarLibroISBN(){
        System.out.println("Ingrese el ISBN del libro que desea buscar");
        long isbn=leer.nextLong();
        
        try {
            Libro libro=dao.buscarLibroIsbn(isbn);
       
            if (libro != null) {
                System.out.println("Libro encontrado:");
                System.out.println("Título: " + libro.getTitulo());
                System.out.println("Autor: " + libro.getAutor().getNombre()); 
                System.out.println("ISBN: " + libro.getIsbn());
                System.out.println("Editorial: " + libro.getEditorial().getNombre()); 
        
            } else {
                System.out.println("Libro no fue encontrado para el ISBN proporcionado.");
            }
        } catch (Exception e) {
             System.out.println("Ocurrió un error al buscar el libro por ISBN: " + e.getMessage());
        }    
    }
    
    public void buscarLibroTitulo(){
        System.out.println("Ingrese el Título del libro que desea buscar");
        String titulo=leer.next();
        
        // Validar que el título contenga al menos un carácter alfabético
        if (!titulo.matches(".*[a-zA-Z].*")) {
            System.out.println("El título debe contener al menos una letra.");
            return; // Salir del método si el título no es válido
        }
        try {
            List<Libro> librosEncontrados=dao.buscarPorTitulo(titulo);
        
            if (librosEncontrados.isEmpty()) {
                System.out.println("No se encontraron libros con el título proporcionado.");
            } else {
                 System.out.println("Libros encontrados con el título '" + titulo + "':");
                for (Libro libro : librosEncontrados) {
                System.out.println("Título: " + libro.getTitulo());
                System.out.println("Autor: " + libro.getAutor().getNombre()); 
                System.out.println("ISBN: " + libro.getIsbn());
                System.out.println("Editorial: " + libro.getEditorial().getNombre()); 
                System.out.println("----------------------------------");
                }
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al buscar libros por título: " + e.getMessage());
        }
    }
    
    public void buscarLibrosAutor(){
        System.out.println("Ingrese el Autor que desea buscar");
        String autor=leer.nextLine();//nextLine() para permitir espacios en blanco en el nombre del autor
        
        try {
            List<Libro> librosEncontrados=dao.buscarPorAutor(autor);
        
            if (librosEncontrados.isEmpty()) {
                System.out.println("No se encontraron libros con el autor proporcionado.");
            } else {
                 System.out.println("Libros encontrados con el Autor '" + autor + "':");
                for (Libro libro : librosEncontrados) {
                System.out.println("Título: " + libro.getTitulo());
                System.out.println("Autor: " + libro.getAutor().getNombre()); 
                System.out.println("ISBN: " + libro.getIsbn());
                System.out.println("Editorial: " + libro.getEditorial().getNombre()); 
                System.out.println("----------------------------------");
                }
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al buscar libros por autor: " + e.getMessage());
        }
    }
    
    public void buscarLibrosEditorial(){
        System.out.println("Ingrese el nombre de la editorial que desea buscar");
        String nombre=leer.next();
        
        try {
            List<Libro> librosEncontrados=dao.buscarPorEditorial(nombre);
        
            if (librosEncontrados.isEmpty()) {
                System.out.println("No se encontraron libros con la editorial proporcionado.");
            } else {
                 System.out.println("Libros encontrados con la Editorial '" + nombre + "':");
                for (Libro libro : librosEncontrados) {
                System.out.println("Título: " + libro.getTitulo());
                System.out.println("Autor: " + libro.getAutor().getNombre()); 
                System.out.println("ISBN: " + libro.getIsbn());
                System.out.println("Editorial: " + libro.getEditorial().getNombre()); 
                System.out.println("----------------------------------");
                }
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al buscar libros por editorial: " + e.getMessage());
        }
    }
    
    public void mostrarTodosLosLibros() {
        try {
            List<Libro> libros = dao.listarTodos();
            
            int anchoTitulo = 40; // Ancho máximo de la columna de título
            
            System.out.printf("%-6s %-4s %-10s %-15s %-10s %-15s %-"+anchoTitulo+"s%-15s %-15s\n",
            "ISBN", "ALTA", "AÑO", "EJEMPLARES", "PRESTADOS", "RESTANTES",
            "TÍTULO LIBRO", "ID AUTOR", "ID EDITORIAL");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
            for (Libro libro : libros) {
                String titulo = libro.getTitulo();
                System.out.printf("%-6d %-4b %-10d %-15d %-10d %-15d %-"+anchoTitulo+"s%-15d %-15d\n",
                        libro.getIsbn(),
                        (libro.isAlta()? "Sí" : "No"),
                        libro.getAnio(),
                        libro.getEjemplares(),
                        libro.getEjemplaresPrestados(),
                        libro.getEjemplaresRestantes(),
                        libro.getTitulo(),  
                        libro.getAutor().getId(),
                        libro.getEditorial().getId());
                
            }
        } catch (Exception e) {
            System.err.println("Error al mostrar los libros: " + e.getMessage());
        }
    }
    
    public void modificarLibro() {
        
        System.out.println("Ingrese el ISBN del libro que desea modificar");
        long isbn=leer.nextLong();
     
        System.out.println("Ingrese el nombre del libro");
        String titulo=leer.next();       
        System.out.println("Ingrese el año de edición del libro");
        Integer anio=leer.nextInt();
        System.out.println("Ingrese la cantidad de ejemplares");
        Integer cantidadEjemplares=leer.nextInt();
        System.out.println("Ingrese la cantidad de ejemplares restantes");
        Integer EjemplaresRestantes=leer.nextInt();  
                   
        try {
            Libro libro = dao.buscarLibroIsbn(isbn);

            if (libro != null) {
                // Modifica los atributos del libro con los nuevos valores
                libro.setTitulo(titulo);
                libro.setAnio(anio);
                libro.setEjemplares(cantidadEjemplares);
                libro.setEjemplaresRestantes(EjemplaresRestantes);
            
            // Actualiza el libro en la base de datos
                dao.editar(libro);
                System.out.println("El libro se actualizó exitosamente");
            } else {
            System.out.println("El libro con ISBN " + isbn + " no fue encontrado.");
            }
        } catch (Exception e) {
            System.err.println("Error al modificar el libro: " + e.getMessage());
        }
    }
    
    public void eliminarLibroPorIsbn(){
         
        System.out.println("Ingrese el Isbn del libro que desea eliminar");
        Long isbn=leer.nextLong();
        
        try {
              //Aquí puedes agregar validaciones antes de llamar al método de DAO
            if (isbn <= 0) {
                throw new Exception("El isbn del libro debe ser un número mayor que cero.");
            }
            
            Libro libro = dao.buscarLibroPorIsbn(isbn);
            if (libro != null) {
                 dao.eliminar(libro);
                 System.out.println("El libro fue eliminada con éxito!");
            } else {
                System.out.println("El libro no existe en la base de datos.");
            }
        } catch (Exception e) {
            System.err.println("Error al eliminar el libro: " + e.getMessage());
        }
    }

}
