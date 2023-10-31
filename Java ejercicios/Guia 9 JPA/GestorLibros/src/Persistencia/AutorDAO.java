
package Persistencia;

import Entidades.Autor;
import java.util.List;

/**
 *
 * @author javer
 */
public class AutorDAO extends DAO<Autor>{
    
    @Override
    public void guardar(Autor autor) {
        super.guardar(autor);
    }

    @Override
    public void actualizar(Autor autor) {
        super.actualizar(autor);
    }

    @Override
    public void eliminar(Autor autor) {
        super.eliminar(autor);
    }
    
    public Autor buscarAutor(Integer id) {
        conectar();
        Autor autor = em.find(Autor.class, id);
        desconectar();
        return autor;
    }
    
    public List<Autor> buscarAutorNombre(String nombre) {
        conectar();
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a where TRIM(a.nombre) = :nombre AND a.alta = TRUE").setParameter("nombre", nombre).getResultList();
        desconectar();
        return autores;
    }

    public List<Autor> validarNombreAutor(String nombre) {  //no se repita el nombre
        conectar();
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a where a.nombre = :nombre").setParameter("nombre", nombre).getResultList();
        desconectar();
        return autores;
    }
    
    public List<Autor> listarTodos() throws Exception {
        conectar();
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a").getResultList();
        desconectar();
        return autores;
    }
}
