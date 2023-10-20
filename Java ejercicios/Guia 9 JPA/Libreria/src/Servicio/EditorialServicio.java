
package Servicio;

import Entidades.Editorial;
import Persistencia.EditorialDAO;
import java.util.Scanner;

/**
 *
 * @author javer
 */
public class EditorialServicio {
    
    Scanner leer=new Scanner(System.in).useDelimiter("\n");
    
    EditorialDAO dao=new EditorialDAO();
    
    public Editorial crearEditorial(){
        Editorial editorial=new Editorial();
        
        System.out.println("Ingrese el nombre de la editorial");
        String nombre=leer.next();
        editorial.setNombre(nombre);
        editorial.setAlta(true);
        
        dao.guardar(editorial);
        System.out.println("Editorial ingresado exitosamente!");
        return editorial;
    }
    
    public void darBajaEditorial(){
        System.out.println("Ingrese el id de la editorial que desea dar de baja");
        Integer id=leer.nextInt();
        Editorial editorial=dao.buscarEditorialId(id);
        editorial.setAlta(false);
        dao.editar(editorial);
    }
}
