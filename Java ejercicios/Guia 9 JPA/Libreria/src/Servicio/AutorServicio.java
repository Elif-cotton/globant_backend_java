
package Servicio;

import Entidades.Autor;
import Persistencia.AutorDAO;
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
    
}
