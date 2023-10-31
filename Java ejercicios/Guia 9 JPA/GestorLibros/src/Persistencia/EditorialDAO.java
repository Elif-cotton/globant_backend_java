
package Persistencia;

import Entidades.Editorial;
import java.util.List;

/**
 *
 * @author javer
 */
public class EditorialDAO extends DAO<Editorial> {
    
    @Override
    public void guardar(Editorial editorial) {
        super.guardar(editorial);
    }

    @Override
    public void actualizar(Editorial editorial) {
        super.actualizar(editorial);
    }

    @Override
    public void eliminar(Editorial editorial) {
        super.eliminar(editorial);
    }
    
     public Editorial buscarEditorial(Integer id) {
        conectar();
        Editorial editorial = em.find(Editorial.class, id);
        desconectar();
        return editorial;
    }

    public List<Editorial> buscarEditorialNombre(String nombre) {
        conectar();
        List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e where e.nombre = :nombre AND e.alta = TRUE").setParameter("nombre", nombre).getResultList();
        desconectar();
        return editoriales;
    }
    
        public List<Editorial> validarEditorialNombre(String nombre) {
        conectar();
        List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e where e.nombre = :nombre").setParameter("nombre", nombre).getResultList();
        desconectar();
        return editoriales;
    }
        
    public List<Editorial> listarTodos() throws Exception {
        conectar();
        List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e").getResultList();
        desconectar();
        return editoriales;
    }
}
