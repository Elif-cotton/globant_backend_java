
package Servicio;

import Entidades.Editorial;
import Persistencia.EditorialDAO;
import java.util.List;
import java.util.Scanner;
import javax.persistence.PersistenceException;

/**
 *
 * @author javer
 */
public class EditorialServicio {
    
    Scanner leer=new Scanner(System.in).useDelimiter("\n");
    
    EditorialDAO dao=new EditorialDAO();
    
    public Editorial crearEditorial() {
       
        Editorial editorial = new Editorial();
        
        try {
            System.out.println("Ingrese el nombre de la editorial");
            String nombre = leer.next();

            // Verifica si la editorial ya existe por nombre
            Editorial editorialExistente = dao.buscarEditorialPorNombre(nombre);

            if (editorialExistente != null) {
            // Si ya existe, reemplaza la editorial existente con la nueva información.
                editorialExistente.setNombre(nombre);
                editorialExistente.setAlta(true);
                dao.editar(editorialExistente); // Suponiendo que tienes un método para actualizar
                System.out.println("La editorial ha sido actualizada exitosamente!");
                return editorialExistente;
            } else {
                // Si no existe, crea una nueva editorial y guárdala.
                editorial.setNombre(nombre);
                editorial.setAlta(true);
                dao.guardar(editorial);
                System.out.println("Editorial ingresada exitosamente!");
            return editorial;
            }
        } catch (PersistenceException e) {
             System.err.println("Error al guardar o actualizar la editorial: " + e.getMessage());
        }
        return editorial;
    }
    
    public void darBajaEditorial(){
        System.out.println("Ingrese el id de la editorial que desea dar de baja");
        Integer id=leer.nextInt();
        Editorial editorial=dao.buscarEditorialId(id);
        editorial.setAlta(false);
        dao.editar(editorial);
    }
    
    public void mostrarTodasLasEditoriales() {
        try {
            List<Editorial> editoriales = dao.listarTodos();
            System.out.printf("%-6s %-10s %-15s\n", "ID", "ALTA", "NOMBRE EDITORIAL");
            System.out.println("--------------------------------------------------");
            for (Editorial editorial : editoriales) {
                System.out.printf("%-6s %-10s %-15s\n",
                        editorial.getId(),
                        (editorial.isAlta()? "Sí" : "No"),
                        editorial.getNombre());
                         
            }
        } catch (Exception e) {
            System.err.println("Error al mostrar las editoriales: " + e.getMessage());
        }
    }
    
    public void modificarEditorial() {
        
        System.out.println("Ingrese el ID de la editorial que desea modificar");
        Integer id=leer.nextInt();
     
        System.out.println("Ingrese el nombre de la editorial");
        String nombre=leer.next(); 
        System.out.println("Ingrese el alta de la editorial, true/false");
        boolean alta =leer.nextBoolean();    
                   
        try {
            Editorial editorial = dao.buscarEditorialId(id);

            if (editorial != null) {
                // Modifica los atributos de la editorial con los nuevos valores
               editorial.setNombre(nombre);
               editorial.setAlta(alta);
            
            // Actualiza la editorial en la base de datos
                dao.editar(editorial);
                System.out.println("La editorial se actualizó exitosamente");
            } else {
                System.out.println("La editorial con id " + id + " no fue encontrado.");
            }
        } catch (Exception e) {
            System.err.println("Error al modificar la editorial: " + e.getMessage());
        }
    }
    
    public void eliminarEditorialPorId(){
         
        System.out.println("Ingrese el ID de la editorial que desea eliminar");
        Integer id=leer.nextInt();
        
        try {
              //Aquí puedes agregar validaciones antes de llamar al método de DAO
            if (id <= 0) {
                throw new Exception("El id de la editorial debe ser un número mayor que cero.");
            }
            
            Editorial editorial = dao.buscarEditorialPorId(id);
            if (editorial != null) {
                 dao.eliminar(editorial);
                 System.out.println("La editorial fue eliminada con éxito!");
            } else {
                System.out.println("La editorial no existe en la base de datos.");
            }
        } catch (Exception e) {
            System.err.println("Error al eliminar la editorial: " + e.getMessage());
        }
    }
    
}
