
package Persistencia;

import Entidades.Editorial;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author javer
 */
public class EditorialDAO extends DAO <Editorial>{
    
    @Override
    public void guardar(Editorial editorial) {
        super.guardar(editorial);
    }
    
    @Override
    public void editar(Editorial editorial) {
        super.editar(editorial);
    }
    
    @Override
    public void eliminar(Editorial editorial) {
        super.eliminar(editorial);
    }
    
    public Editorial buscarEditorialId(Integer id){
        Editorial editorial=em.find(Editorial.class, id);
        return editorial;
    }
    
    
    public void editar(Integer id) throws Exception {
        Editorial editorial = buscarPorId(id);
        super.editar(editorial);
    }
    
    public void eliminar(Integer id) throws Exception {
        Editorial editorial = buscarPorId(id);
        super.eliminar(editorial);
    }
    
    public Editorial buscarPorId(Integer id) throws Exception {
        conectar();
        Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.id LIKE :id").setParameter("id", id).getSingleResult();
        desconectar();
        return editorial;
    }

    public List<Editorial> listarTodos() throws Exception {
        conectar();
        List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e").getResultList();
        desconectar();
        return editoriales;
    }
    
    public boolean existeEditorial(String nombre) {
        conectar();
        Query query = em.createQuery("SELECT COUNT(e) FROM Editorial e WHERE e.nombre = :nombre", Long.class);
        query.setParameter("nombre", nombre);
        long cantidad = (long) query.getSingleResult();
        desconectar();
        return cantidad > 0;
    }
    
//    public boolean existeEditorial(int id) {
//        try {
//            conectar();
//            TypedQuery<Long> query = em.createQuery("SELECT COUNT(e) FROM Editorial e WHERE e.id = :id", Long.class);
//            query.setParameter("id", id);
//            Long count = query.getSingleResult();
//            return count > 0;
//        } finally {
//            desconectar();
//        }
//    }

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
