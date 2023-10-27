
package Servicio;

import Entidades.Autor;
import Persistencia.AutorDAO;
import java.util.Scanner;
import javax.persistence.PersistenceException;
import java.util.List;

/**
 *
 * @author javer
 * autores (consulta, creación, modificación y eliminación)
 */
public class AutorServicio {
    
    Scanner leer=new Scanner(System.in).useDelimiter("\n");
    
    AutorDAO dao=new AutorDAO();
    
    public Autor crearAutor(){
        Autor autor=new Autor();
        try{
            System.out.println("Ingrese el nombre del autor");
            String nombre=leer.next();

        // Verifica si el autor ya existe por nombre
            Autor autorExistente = dao.buscarAutorPorNombre(nombre);

            if (autorExistente != null) {
            // Si ya existe, reemplaza el autor existente con la nueva información.
                autorExistente.setNombre(nombre);
                autorExistente.setAlta(true);
                dao.editar(autorExistente); // Suponiendo que tienes un método para actualizar
                System.out.println("El autor ha sido actualizada exitosamente!");
                return autorExistente;
            } else {
                // Si no existe, crea una nueva editorial y guárdala.
                autor.setNombre(nombre);
                autor.setAlta(true);
                dao.guardar(autor);
                System.out.println("Autor ingresada exitosamente!");
            return autor;
            }
        } catch (PersistenceException e) {
             System.err.println("Error al guardar o actualizar la Autor: " + e.getMessage());
        }
        return autor;
    }
    
    public void darBaja(){
        System.out.println("Ingrese el id del autor que desea dar de baja");
        Integer id=leer.nextInt();
        Autor autor=dao.buscarAutorId(id);
        autor.setAlta(false);
        dao.editar(autor);
    }
    
    public List<Autor> buscarAutorNombre(){
        System.out.println("Ingrese el nombre del autor que desea buscar");
        String nombre= leer.next();
        List<Autor> autores= dao.buscarPorNombre(nombre);
        
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
     
    public void mostrarTodosLosAutores() {
        try {
            List<Autor> autores = dao.listarTodos();
            System.out.printf("%-6s %-10s %-15s\n", "ID", "ALTA", "NOMBRE AUTOR");
            System.out.println("--------------------------------------------------");
            for (Autor autor : autores) {
                System.out.printf("%-6s %-10s %-15s\n",
                        autor.getId(),
                        (autor.isAlta()? "Sí" : "No"),
                        autor.getNombre());
                         
            }
        } catch (Exception e) {
            System.err.println("Error al mostrar los autores: " + e.getMessage());
        }
    }
    
    public void modificarAutor() {
        
        System.out.println("Ingrese el ID del autor que desea modificar");
        Integer id=leer.nextInt();
     
        System.out.println("Ingrese el nombre del autor");
        String nombre=leer.next(); 
        System.out.println("Ingrese el alta del autor, true/false");
        boolean alta =leer.nextBoolean();    
                   
        try {
            Autor autor = dao.buscarPorId(id);

            if (autor != null) {
               autor.setNombre(nombre);
               autor.setAlta(alta);
            
            // Actualiza el autor en la base de datos
                dao.editar(autor);
                System.out.println("El autor se actualizó exitosamente");
            } else {
                System.out.println("El autor con id " + id + " no fue encontrado.");
            }
        } catch (Exception e) {
            System.err.println("Error al modificar el autor: " + e.getMessage());
        }
    }
    
    
    public void eliminarAutorPorId(){
         
        System.out.println("Ingrese el ID del autor que desea eliminar");
        Integer id=leer.nextInt();
        
        try {
              //Aquí puedes agregar validaciones antes de llamar al método de DAO
            if (id <= 0) {
                throw new Exception("El id del autor debe ser un número mayor que cero.");
            }
            
            Autor autor = dao.buscarAutorPorId(id);
            if (autor != null) {
                 dao.eliminar(autor);
                 System.out.println("El autor fue eliminada con éxito!");
            } else {
                System.out.println("El autor no existe en la base de datos.");
            }
        } catch (Exception e) {
            System.err.println("Error al eliminar el autor: " + e.getMessage());
        }
    }
}
