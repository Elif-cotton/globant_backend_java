
package Persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author javer
 * @param <T>
 */
public abstract class DAO <T>{
    
    protected final EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestorLibrosPU");
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

    protected void guardar(T object) {
        try {
            conectar();
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("No se pudo cargar");
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            desconectar();
        }
    }

    protected void actualizar(T object) {
        try {
            conectar();
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("No se pudo actualizar");
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            desconectar();
        }
    }

    protected void eliminar(T object) {
        try {
            conectar();
            em.getTransaction().begin();
            em.remove(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("No se pudo borrar");
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            desconectar();
        }
    }
}
