
package Servicios;

import Entidades.Autor;
import Persistencia.AutorDAO;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author javer
 */
public class AutorServicio {
    
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    AutorDAO dao = new AutorDAO();
    
    public Autor crearAutor() {
        Autor autor = new Autor();
        do {
            System.out.println("Ingrese el nombre del autor");
            String nombre = leer.next();
            autor.setNombre(nombre);
            
            if (dao.validarNombreAutor(nombre).isEmpty()) {
                break;
            } else {
                System.out.println("Nombre de autor ya registrado.");
            }
        } while (true);

        autor.setAlta(true);

        dao.guardar(autor);
        System.out.println("Autor guardado exitosamente!");
        return autor;
    }

    public Autor crearAutor(String nombre) {   //método de libroServicio
        Autor autor = new Autor();
        autor.setNombre(nombre);
        autor.setAlta(true);

        dao.guardar(autor);
        System.out.println("Autor guardado exitosamente!");
        return autor;
    }
    
     public void darAltaBajaModificar() {
        Integer id;
        do {
            System.out.println("Ingrese el id del autor que desea dar alta/baja/modificar");
            try {
                id = leer.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Error al ingresar el id");
                leer.next();
            }
        } while (true);
        Autor autor = dao.buscarAutor(id);
        int opcion;
        do {
            System.out.println("1- Alta/Baja \n2-Modificar");
            try {
                opcion = leer.nextInt();
                if (!(opcion == 1 || opcion == 2)) {
                    System.out.println("Opción mal ingresada");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Opción mal ingresada");
            }
        } while (true);
        switch (opcion) {
            case 1:
                if (autor.getAlta()) {
                    autor.setAlta(false);
                } else {
                    autor.setAlta(true);
                }
                break;
            case 2:
                System.out.println("Ingrese el nombre que desea modificar");
                String nombreAutor = leer.next();
                autor.setNombre(nombreAutor);
                break;
        }
        dao.actualizar(autor);
    }

    public List<Autor> buscarAutorNombre(){
        System.out.println("Ingrese el nombre del autor que desea buscar");
        String nombre= leer.next();
        List<Autor> autores= dao.buscarAutorNombre(nombre);
        
        if (autores.isEmpty()) {
            System.out.println("No se encontraron autores con ese nombre.");
        } else {
            System.out.println("Autores encontrados:");
            for (Autor autor : autores) {
                System.out.println("ID: " + autor.getId() + ", Nombre: " + autor.getNombre());
            }
        }
        return autores;
    }
     
    public List<Autor> buscarAutorNombre(String nombre) {
        return dao.buscarAutorNombre(nombre);
    }
    
     public void mostrarTodosLosAutores() {
        try {
            List<Autor> autores = dao.listarTodos();
            System.out.printf("%-6s %-10s %-15s\n", "ID", "ALTA", "NOMBRE AUTOR");
            System.out.println("--------------------------------------------------");
            for (Autor autor : autores) {
                System.out.printf("%-6s %-10s %-15s\n",
                        autor.getId(),
                        (autor.getAlta()? "Sí" : "No"),
                        autor.getNombre());
                         
            }
        } catch (Exception e) {
            System.err.println("Error al mostrar los autores: " + e.getMessage());
        }
    }
}
