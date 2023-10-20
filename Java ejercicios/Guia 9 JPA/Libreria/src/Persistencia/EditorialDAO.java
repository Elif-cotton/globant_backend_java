
package Persistencia;

import Entidades.Editorial;
import java.util.List;

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
        super.guardar(editorial);
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
}
