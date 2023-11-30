
package repositorios;

import entidades.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author javer
 */

@Repository
public interface AdministradorRepositorio extends JpaRepository<Administrador, String>{
    
    @Query("SELECT a FROM Administrador a WHERE a.email = :email")
    public Administrador buscarPorEmail(@Param("email") String email);
    
}
