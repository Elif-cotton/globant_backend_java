
package Persistencia;

import Entidades.Libro;
import java.util.Collections;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

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
    
    @Override
    public void eliminar(Libro libro) {
        super.eliminar(libro);
    }
    
     public void eliminar(String titulo) throws Exception {
        Libro libro = (Libro) buscarPorTitulo(titulo);
        super.editar(libro);
    }


    public List<Libro> listarTodos() throws Exception {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l").getResultList();
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
    
    public List<Libro> buscarPorAutor(String nombreAutor) {
        try {
            conectar();
            List<Libro> libros = em.createQuery(
                "SELECT l FROM Libro l " +
                "INNER JOIN l.autor a " +
                "WHERE a.nombre = :nombreAutor", Libro.class)
                .setParameter("nombreAutor", nombreAutor).getResultList();
            desconectar();
            return libros;
        } catch (Exception e) {
            System.out.println("Ocurrió un error al buscar libros por autor: " + e.getMessage());
             return Collections.emptyList(); // Devuelve una lista vacía en caso de error
        } finally {
            desconectar();
        }
    }
    
    public List<Libro> buscarPorEditorial(String editorial) {
        try {
            conectar();
             List<Libro> libros = em.createQuery(
                     "SELECT l FROM Libro l"
                   + " INNER JOIN l.editorial e "
                   + "WHERE e.nombre = :editorial", Libro.class)
                    .setParameter("editorial", editorial).getResultList();
            desconectar();
            return libros;
        } catch (Exception e) {
            System.out.println("Ocurrió un error al buscar libros por editorial: " + e.getMessage());
             return Collections.emptyList(); // Devuelve una lista vacía en caso de error
        } finally {
            desconectar();
        }
    }
    
    public Libro buscarLibroPorIsbn(Long libroIsbn) {
        try {
            String jpql = "SELECT l FROM Libro l WHERE l.isbn = :libroIsbn";
            TypedQuery<Libro> query = em.createQuery(jpql, Libro.class);
            query.setParameter("libroIsbn", libroIsbn);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null; // Si no se encuentra el libro, devuelve null
        }
    }
}
