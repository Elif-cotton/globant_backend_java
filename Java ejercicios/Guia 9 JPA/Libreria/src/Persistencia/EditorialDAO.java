
package Persistencia;

import Entidades.Editorial;
import java.util.List;
import javax.persistence.NoResultException;
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
    
    public Editorial buscarEditorialPorId(Integer editorialId) {
        try {
            String jpql = "SELECT e FROM Editorial e WHERE e.id = :editorialId";
            TypedQuery<Editorial> query = em.createQuery(jpql, Editorial.class);
            query.setParameter("editorialId", editorialId);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null; // Si no se encuentra la editorial, devuelve null
        }
    }
    
    public Editorial buscarEditorialPorNombre(String nombre) {
        try {
            String jpql = "SELECT e FROM Editorial e WHERE e.nombre = :nombre";
            TypedQuery<Editorial> query = em.createQuery(jpql, Editorial.class);
            query.setParameter("nombre", nombre);
            List<Editorial> resultados = query.getResultList();
        
            if (resultados.isEmpty()) {
                return null; // Si no se encuentra la editorial, devuelve null
            } else {
                return resultados.get(0); // Devuelve el primer resultado si hay múltiples coincidencias
            }
        } catch (NoResultException e) {
            return null; // Si no se encuentra la editorial, devuelve null
        
    }
}







}
