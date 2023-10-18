
package Persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author javer
 */
public class DAO <T>{
    
//    EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU")
//                        .createEntityManager();
    
    protected final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    protected EntityManager em = emf.createEntityManager();
    
    protected void conectar() {
        if (!em.isOpen()) {
            em = emf.createEntityManager();
        }
    }
    
    protected void desconectar() {
        if (em.isOpen()) {
            em.close();
        }
    }
    
    protected void guardar(T objeto){
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    protected void editar(T objeto){
        conectar();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    protected void eliminar(T objeto){
        conectar();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
}
