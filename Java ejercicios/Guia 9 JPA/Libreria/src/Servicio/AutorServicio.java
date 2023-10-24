
package Servicio;

import Entidades.Autor;
import Persistencia.AutorDAO;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author javer
 * autores (consulta, creación, modificación y eliminación
 */
public class AutorServicio {
    
    Scanner leer=new Scanner(System.in).useDelimiter("\n");
    
    AutorDAO dao=new AutorDAO();
    
    public Autor crearAutor(){
        Autor autor=new Autor();
        
        System.out.println("Ingrese el nombre del autor");
        String nombre=leer.next();
        autor.setNombre(nombre);
        autor.setAlta(true);
        
        dao.guardar(autor);
        System.out.println("Autor ingresado exitosamente!");
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
    
    public void eliminarAutorPorId() {
        System.out.println("Ingrese el ID del autor que desea eliminar");
        Integer autorId=leer.nextInt();
        
        try {
            
            if (!dao.existeID(autorId)) {
                throw new Exception("El id del autor " + autorId + " no existe en la base de datos.");
            }  
            dao.eliminar(autorId);
        } catch (Exception e) {
             System.err.println("Error al eliminar el autor: " + e.getMessage());
        }
    }
}
