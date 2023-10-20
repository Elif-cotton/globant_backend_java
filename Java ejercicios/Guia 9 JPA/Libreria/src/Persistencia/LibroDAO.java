
package Persistencia;

import Entidades.Libro;
import java.util.List;

/**
 *
 * @author javer
 */
public class LibroDAO extends DAO <Libro> {
    
     @Override
    public void guardar(Libro libro) {
        super.guardar(libro);
    }
    
    @Override
    public void editar(Libro libro) {
        super.editar(libro);
    }
    
    public void editar(long isbn) throws Exception {
        Libro libro = buscarPorId(isbn);
        super.editar(libro);
    }
    
     public void eliminar(String titulo) throws Exception {
        Libro libro = (Libro) buscarPorTitulo(titulo);
        super.editar(libro);
    }
     
    public void eliminar(long isbn) throws Exception {
        Libro libro = buscarPorId(isbn);
        super.eliminar(libro);
    }
    
    public Libro buscarPorId(long isbn) throws Exception {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.isbn LIKE :id").setParameter("isbn", isbn).getSingleResult();
        desconectar();
        return libro;
    }

    public List<Libro> listarTodos() throws Exception {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Editorial l").getResultList();
        desconectar();
        return libros;
    }
    
    public List<Libro> buscarPorTitulo(String titulo) {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :titulo")
                .setParameter("titulo", titulo).getResultList();
        desconectar();
        return libros;
    }
    
    public Libro buscarLibroIsbn(long isbn){
        Libro libro=em.find(Libro.class, isbn);
        return libro;
    }
}
