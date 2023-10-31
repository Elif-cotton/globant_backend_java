
package libreria;

import Servicio.AutorServicio;
import Servicio.EditorialServicio;
import Servicio.LibroServicio;
import java.util.Scanner;

/**
 *
 * @author javer
 * crear un menú, 
 * 1)Crear los métodos para dar de alta/bajo o editar dichas entidades.
 * 2) Búsqueda de un Autor por nombre.
 * 3) Búsqueda de un libro por ISBN.
 * 4) Búsqueda de un libro por Título.
 * 5) Búsqueda de un libro/s por nombre de Autor.
 * 6) Búsqueda de un libro/s por nombre de Editorial.
 */
public class Libreria {

 
    public static void main(String[] args) throws Exception {
        
        Scanner leer=new Scanner(System.in).useDelimiter("\n");
        AutorServicio autorServicio = new AutorServicio();
        LibroServicio libroServicio = new LibroServicio();
        EditorialServicio editorialServicio = new EditorialServicio();

        int opcion;

        do {
            System.out.println("");
            System.out.println("Menú de Opciones:");
            System.out.println("1. Crear Autor");
            System.out.println("2. Crear Libro, Autor y editorial");
            System.out.println("3. Crear Editorial");
            System.out.println("4. Editar Autor");
            System.out.println("5. Editar Libro");
            System.out.println("6. Editar Editorial");
            System.out.println("7. Eliminar Autor");
            System.out.println("8. Eliminar Libro");
            System.out.println("9. Eliminar Editorial");
            System.out.println("10. Buscar Autor por nombre");
            System.out.println("11. Buscar Libro por ISBN");
            System.out.println("12. Buscar Libro por Título");
            System.out.println("13. Buscar Libro/s por nombre de Autor");
            System.out.println("14. Buscar Libro/s por nombre de Editorial");
            System.out.println("15. Dar de baja Autor");
            System.out.println("16. Dar de baja Libro");
            System.out.println("17. Dar de baja Editorial");
            System.out.println("18. Mostrar tabla libros");
            System.out.println("19. Mostrar tabla autores");
            System.out.println("20. Mostrar tabla editoriales");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    // Crear Autor
                    autorServicio.crearAutor();
                    break;
                case 2:
                    // Crear Libro, Autor y editorial
                    libroServicio.crearLibro();
                    break;
                case 3:
                    // Crear Editorial
                    editorialServicio.crearEditorial();
                    break;
                case 4:
                    // Editar Autor
                    autorServicio.modificarAutor();
                    break;
                case 5:
                    // Editar Libro
                    libroServicio.modificarLibro();
                    break;
                case 6:
                    // Editar Editorial
                    editorialServicio.modificarEditorial();
                    break;
                case 7:
                    // Eliminar Autor
                    autorServicio.eliminarAutorPorId();
                    break;
                case 8:
                    // Eliminar Libro
                     libroServicio.eliminarLibroPorIsbn();
                    break;
                case 9:
                    // Eliminar Editorial
                    editorialServicio.eliminarEditorialPorId();
                    break;
                case 10:
                    // Buscar Autor por nombre
                    autorServicio.buscarAutorNombre();
                    break;
                case 11:
                    // Buscar Libro por ISBN
                    libroServicio.buscarLibroISBN();
                    break;
                case 12:
                    // Buscar Libro por Título
                    libroServicio.buscarLibroTitulo();
                    break;
                case 13:
                    // Buscar Libro/s por nombre de Autor
                    libroServicio.buscarLibrosAutor();
                    break;
                case 14:
                    // Buscar Libro/s por nombre de Editorial
                    libroServicio.buscarLibrosEditorial();
                    break;
                case 15:
                    // Dar de baja Autor
                    autorServicio.darBaja();
                    break; 
                case 16:
                    // Dar de baja Libro
                    libroServicio.darBaja();
                    break; 
                case 17:
                    // Dar de baja Editorial
                    editorialServicio.darBajaEditorial();
                    break; 
                case 18:
                    // Mostrar tabla libros
                    libroServicio.mostrarTodosLosLibros();
                    break; 
                case 19:
                    // Mostrar tabla autores
                    autorServicio.mostrarTodosLosAutores();
                    break; 
                case 20:
                    // Mostrar tabla editoriales
                    editorialServicio.mostrarTodasLasEditoriales();
                    break;   
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);
    }
    
    
}
