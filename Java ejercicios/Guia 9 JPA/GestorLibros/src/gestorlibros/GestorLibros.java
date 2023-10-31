
package gestorlibros;

import Entidades.Autor;
import Entidades.Cliente;
import Entidades.Editorial;
import Entidades.Libro;
import Entidades.Prestamo;
import Persistencia.AutorDAO;
import Persistencia.ClienteDAO;
import Persistencia.EditorialDAO;
import Persistencia.LibroDAO;
import Persistencia.PrestamoDAO;
import Servicios.AutorServicio;
import Servicios.ClienteServicio;
import Servicios.EditorialServicio;
import Servicios.LibroServicio;
import Servicios.PrestamoServicio;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author javer
 */
public class GestorLibros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        AutorServicio as = new AutorServicio();
        EditorialServicio es = new EditorialServicio();
        LibroServicio ls = new LibroServicio();
        PrestamoServicio ps = new PrestamoServicio();
        ClienteServicio cs = new ClienteServicio();
        
        cargarDatos();
        
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        boolean menu = true;
        do {
            int opcion = 0;
            do {
                try {
                    System.out.println("\n");
                    System.out.println("1. Agregar autor, editorial, libro o cliente.");
                    System.out.println("2. Dar de alta/baja autor, editorial, libro o cliente.");
                    System.out.println("3. Buscar Autor por nombre");
                    System.out.println("4. Buscar libro por ISBN");
                    System.out.println("5. Buscar libro por Título");
                    System.out.println("6. Buscar libro/s por nombre de Autor");
                    System.out.println("7. Buscar libro/s por nombre de Editorial");
                    System.out.println("8. Registrar préstamo");
                    System.out.println("9. Devolver préstamo");
                    System.out.println("10. Mostrar tabla libros");
                    System.out.println("11. Mostrar tabla autores");
                    System.out.println("12. Mostrar tabla editoriales");
                    System.out.println("0. Salir");
                    System.out.print("Ingrese la opción: ");

                    opcion = leer.nextInt();
                    break;
                } catch (Exception e) {
                    leer.next();
                    System.out.println("");
                    System.out.println("Opción no válida.");
                }
            } while (menu);

            switch (opcion) {
                case 1:
                    do {
                        try {
                            System.out.println("1. Autor");
                            System.out.println("2. Editorial");
                            System.out.println("3. Libro");
                            System.out.println("4. Cliente");
                            System.out.println("5. Volver al menú principal");
                            System.out.print("Ingrese la opción: ");

                             opcion = leer.nextInt();
                            break;
                        } catch (Exception e) {
                            leer.next();
                            System.out.println("Opción no válida");
                        }
                    } while (true);
                    switch (opcion) {
                        case 1:
                            as.crearAutor();
                            break;
                        case 2:
                            es.crearEditorial();
                            break;
                        case 3:
                            ls.crearLibro();
                            break;
                        case 4:
                            cs.crearCliente();
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Opción no reconocida.");
                    }
                    break;
                case 2:
                    do {
                        try {
                            System.out.println("1. Autor");
                            System.out.println("2. Editorial");
                            System.out.println("3. Libro");
                            System.out.println("4. Cliente");
                            System.out.println("5. Volver al menú principal");
                            System.out.print("Ingrese la opción: ");

                            opcion = leer.nextInt();
                            break;
                        } catch (Exception e) {
                            leer.next();
                            System.out.println("Opción no válida");
                        }
                    } while (true);

                    switch (opcion) {
                        case 1:
                            as.darAltaBajaModificar();
                            break;
                        case 2:
                            es.darAltaBajaModifcar();
                            break;
                        case 3:
                            ls.darAltaBajaModificar();
                            break;
                        case 4:
                            cs.darAltaBajaModificar();
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Opción no reconocida.");
                    }
                    break;
                case 3:
                    as.buscarAutorNombre();
                    break;
                case 4:
                    ls.buscarLibroISBN();
                    break;
                case 5:
                    ls.buscarLibroTitulo();
                    break;
                case 6:
                    ls.buscarLibroAutor();
                    break;
                case 7:
                    ls.buscarLibroEditorial();
                    break;
                case 8:
                    ps.darPrestamo();
                    break;
                case 9:
                    ps.devolverLibro();
                    break;
                case 10:
                    ls.mostrarTodosLosLibros();
                    break;
                case 11:
                    as.mostrarTodosLosAutores();
                    break;
                case 12:
                    es.mostrarTodasLasEditoriales();
                    break;
                case 0:
                    menu = false;
                    System.out.println("Gracias por usar mi programa!");
                    break;
                default:
                    System.out.println("Opción no reconocida. Por favor, elige una opción del menú.");
            }
        } while (menu);
        System.out.println("\n\n");
    }
    public static void cargarDatos() {
        
        //Autores
        AutorDAO autorDAO=new AutorDAO();
       
        Autor autor1 = new Autor();
        autor1.setAlta(true);
        autor1.setNombre("J. K. Rowling");
        

        Autor autor2 = new Autor();
        autor2.setAlta(true);
        autor2.setNombre("Dan Brown");

        Autor autor3 = new Autor();
        autor3.setAlta(true);
        autor3.setNombre("Gabriel García Márquez");
        
        //Guardar datos
        autorDAO.guardar(autor1);
        autorDAO.guardar(autor2);
        autorDAO.guardar(autor3);
        
        //Editoriales
        EditorialDAO editorialDAO=new EditorialDAO();
        
        Editorial editorial1 = new Editorial();
        editorial1.setAlta(true);
        editorial1.setNombre("Bloomsbury");

        Editorial editorial2 = new Editorial();
        editorial2.setAlta(true);
        editorial2.setNombre("Doubleday");

        Editorial editorial3 = new Editorial();
        editorial3.setAlta(true);
        editorial3.setNombre("Sudamericana");

        Editorial editorial4 = new Editorial();
        editorial4.setAlta(true);
        editorial4.setNombre("Oveja Negra");

        editorialDAO.guardar(editorial1);
        editorialDAO.guardar(editorial2);
        editorialDAO.guardar(editorial3);
        editorialDAO.guardar(editorial4);
        
        //Libros
        LibroDAO libroDAO=new LibroDAO();
        
        Libro libro1 = new Libro();
        libro1.setTitulo("Harry Potter y la piedra filosofal");
        libro1.setAnio(1997);
        libro1.setEjemplares(5);
        libro1.setEjemplaresPrestados(0);
        libro1.setEjemplaresRestantes(libro1.getEjemplares() - libro1.getEjemplaresPrestados());
        libro1.setAlta(true);
        libro1.setAutor(autor1);
        libro1.setEditorial(editorial1);
        
        Libro libro2 = new Libro();
        libro2.setTitulo("El código Da Vinci");
        libro2.setAnio(2003);
        libro2.setEjemplares(8);
        libro2.setEjemplaresPrestados(0);
        libro2.setEjemplaresRestantes(libro2.getEjemplares() - libro2.getEjemplaresPrestados());
        libro2.setAlta(true);
        libro2.setAutor(autor2);
        libro2.setEditorial(editorial2);
        
        Libro libro3 = new Libro();
        libro3.setTitulo("Cien años de soledad");
        libro3.setAnio(1967);
        libro3.setEjemplares(4);
        libro3.setEjemplaresPrestados(0);
        libro3.setEjemplaresRestantes(libro3.getEjemplares() - libro3.getEjemplaresPrestados());
        libro3.setAlta(true);
        libro3.setAutor(autor3);
        libro3.setEditorial(editorial3);
        
        Libro libro4 = new Libro();
        libro4.setAlta(true);
        libro4.setTitulo("El amor en los tiempos del cólera");
        libro4.setAnio(1985);
        libro4.setEjemplares(1);
        libro4.setEjemplaresPrestados(0);
        libro4.setEjemplaresRestantes(libro4.getEjemplares() - libro4.getEjemplaresPrestados());
        libro4.setAlta(true);
        libro4.setAutor(autor3);
        libro4.setEditorial(editorial4);

        
        Libro libro5 = new Libro();
        libro5.setTitulo("Del amor y otros demonios");
        libro5.setAnio(1994);
        libro5.setEjemplares(8);
        libro5.setEjemplaresPrestados(0);
        libro5.setEjemplaresRestantes(libro5.getEjemplares() - libro5.getEjemplaresPrestados());
        libro5.setAlta(true);
        libro5.setAutor(autor3);
        libro5.setEditorial(editorial4);
        
        Libro libro6 = new Libro();
        libro6.setTitulo("Crónica de una muerte anunciada");
        libro6.setAnio(1981);
        libro6.setEjemplares(3);
        libro6.setEjemplaresPrestados(0);
        libro6.setEjemplaresRestantes(libro6.getEjemplares() - libro6.getEjemplaresPrestados());
        libro6.setAlta(false);
        libro6.setAutor(autor3);
        libro6.setEditorial(editorial4);
        
        //guardar libros
        libroDAO.guardar(libro1);
        libroDAO.guardar(libro2);
        libroDAO.guardar(libro3);
        libroDAO.guardar(libro4);
        libroDAO.guardar(libro5);
        libroDAO.guardar(libro6);
        
        //Clientes
        ClienteDAO clienteDAO=new ClienteDAO();
        Cliente cliente1 = new Cliente();
        cliente1.setDocumento(43455736L);
        cliente1.setNombre("Sebastian");
        cliente1.setApellido("Fermanelli");
        cliente1.setTelefono("2322-328423");

        Cliente cliente2 = new Cliente();
        cliente2.setDocumento(37902842L);
        cliente2.setNombre("Maria");
        cliente2.setApellido("Garcia");
        cliente2.setTelefono("2474-432357");

        Cliente cliente3 = new Cliente();
        cliente3.setDocumento(22938445L);
        cliente3.setNombre("Juan");
        cliente3.setApellido("Lopez");
        cliente3.setTelefono("341-3892748");

        //Guardar clientes
        clienteDAO.guardar(cliente1);
        clienteDAO.guardar(cliente2);
        clienteDAO.guardar(cliente3);

        //Préstamos
        PrestamoDAO prestamoDAO=new PrestamoDAO();
        
        Prestamo prestamo1 = new Prestamo();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fechaPrestamo1 = dateFormat.parse("2020-04-03");
            prestamo1.setFechaPrestamo(fechaPrestamo1);
            Date fechaDevolucion1 = dateFormat.parse("2020-04-10");
            prestamo1.setFechaDevolucion(fechaDevolucion1);
        } catch (ParseException e) {
            e.printStackTrace();
        }    
        prestamo1.setCliente(cliente1);
        prestamo1.setLibro(libro4);

        Prestamo prestamo2 = new Prestamo();
        try {
            Date fechaPrestamo2 = dateFormat.parse("2023-07-08");
            prestamo2.setFechaPrestamo(fechaPrestamo2);
            Date fechaDevolucion2 = dateFormat.parse("2023-07-10");
            prestamo2.setFechaDevolucion(fechaDevolucion2);
        } catch (ParseException e) {
            e.printStackTrace();
        }     
        prestamo2.setCliente(cliente3);
        prestamo2.setLibro(libro5);
        
        //guardar prestamo
        prestamoDAO.guardar(prestamo1);
        prestamoDAO.guardar(prestamo2);

        System.out.println("El sistema cargó los datos correctamente");
    }
}
