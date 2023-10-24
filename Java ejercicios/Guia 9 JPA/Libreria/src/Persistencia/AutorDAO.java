
package Persistencia;

import Entidades.Autor;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author javer
 * autores (consulta buscar por nombre, creación, modificación y eliminación)
 */
public class AutorDAO extends DAO<Autor>{
    
    @Override
    public void guardar(Autor autor) {
        super.guardar(autor);
    }
    
    @Override
    public void editar(Autor autor) {
        super.editar(autor);
    }
    
    public void editar(Integer id) throws Exception {
        Autor autor = buscarPorID(id);
        super.editar(autor);
    }
    
    public void eliminar(Integer id) throws Exception {
        Autor autor = buscarPorId(id);
        super.eliminar(autor);
    }
    
    public Autor buscarPorId(Integer id) throws Exception {
        conectar();
        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.id LIKE :id").setParameter("id", id).getSingleResult();
        //JPQL poner nombre tabla es la de la clase Autor
        desconectar();
        return autor;
    }

    public List<Autor> listarTodos() throws Exception {
        conectar();
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a").getResultList();
        desconectar();
        return autores;
    }
    
    //usando createNamedQuery
    public Autor buscarPorID(Integer id) throws Exception {
        conectar();
        Autor autor = em.createNamedQuery("Autor.buscarPorId", Autor.class).setParameter("id", id).getSingleResult();
        desconectar();
        return autor;
    }
    
    public Autor buscarAutorId(Integer id){
        Autor autor=em.find(Autor.class, id);
        return autor;
    }
    
    public List<Autor> buscarPorNombre(String nombre) {
        return em.createQuery("SELECT a FROM Autor a WHERE a.nombrenombre").
                setParameter("nombre", nombre).getResultList();
    }
    
   public boolean existeID(Integer id) {
        try {
            conectar();
            TypedQuery<Long> query = em.createQuery("SELECT COUNT(e) FROM Editorial e WHERE e.id = :id", Long.class);
            query.setParameter("id", id);
            Long count = query.getSingleResult();
            return count > 0;
        } finally {
            desconectar();
        }
    }
}
