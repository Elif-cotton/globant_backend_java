
package Persistencia;

import Entidades.Libro;
import java.util.List;

/**
 *
 * @author javer
 */
public class LibroDAO extends DAO<Libro>{
    
    @Override
    public void guardar(Libro libro) {
        super.guardar(libro);
    }

    @Override
    public void actualizar(Libro libro) {
        super.actualizar(libro);
    }

    @Override
    public void eliminar(Libro libro) {
        super.eliminar(libro);
    }
    
    public Libro buscarLibroISBN(Long ISBN) {
        conectar();
        Libro libro = em.find(Libro.class, ISBN);
        desconectar();
        return libro;
    }

    public List<Libro> buscarLibroTitulo(String titulo) {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.titulo = :titulo AND l.alta = TRUE")
                .setParameter("titulo", titulo).getResultList();
        desconectar();
        return libros;
    }

    public List<Libro> buscarLibroAutor(String nombre) {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.autor.id = "
                + "(SELECT a.id FROM Autor a where a.nombre = :nombre AND a.alta = TRUE)")
                .setParameter("nombre", nombre).getResultList();
        desconectar();
        return libros;
    }

    public List<Libro> buscarLibroEditorial(String nombre) {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.editorial.id ="
                + " (SELECT e.id FROM Editorial e where e.nombre = :nombre AND e.alta = TRUE)")
                .setParameter("nombre", nombre).getResultList();
        desconectar();
        return libros;
    }
    
    public List<Libro> listarTodos() throws Exception {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l").getResultList();
        desconectar();
        return libros;
    }
}
