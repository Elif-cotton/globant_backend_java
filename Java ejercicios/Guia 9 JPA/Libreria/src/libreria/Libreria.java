
package libreria;

import Servicio.AutorServicio;
import Servicio.EditorialServicio;
import Servicio.LibroServicio;

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

 
    public static void main(String[] args) {
        
        AutorServicio as=new AutorServicio();
        EditorialServicio es=new EditorialServicio();
        LibroServicio ls=new LibroServicio();
        
        //ls.crearLibro();
        //ls.darBaja();
        es.darBajaEditorial();
    }
    
}
