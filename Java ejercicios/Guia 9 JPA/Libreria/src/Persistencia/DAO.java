
package Persistencia;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author javer
 */
public class DAO {
    
    EntityManager em = Persistence.createEntityManagerFactory("PersistenciaPU")
                        .createEntityManager();
}
