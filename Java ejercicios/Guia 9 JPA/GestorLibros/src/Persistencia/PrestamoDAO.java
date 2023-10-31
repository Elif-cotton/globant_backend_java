
package Persistencia;

import Entidades.Prestamo;
import java.util.List;

/**
 *
 * @author javer
 */
public class PrestamoDAO extends DAO<Prestamo>{
    
    @Override
    public void guardar(Prestamo prestamo) {
        super.guardar(prestamo);
    }

    @Override
    public void actualizar(Prestamo prestamo) {
        super.actualizar(prestamo);
    }

    @Override
    public void eliminar(Prestamo prestamo) {
        super.eliminar(prestamo);
    }
    
     public Prestamo buscarPrestamoId(Integer id) {
        conectar();
        Prestamo prestamo = em.find(Prestamo.class, id);
        desconectar();
        return prestamo;
    }

    public List<Prestamo> buscarPrestamoCliente(Long dni) {
        conectar();
        List<Prestamo> prestamos = em.createQuery("SELECT P FROM Prestamo p WHERE p.cliente.documento = :dni AND p.alta = TRUE").setParameter("dni", dni).getResultList();
        desconectar();
        return prestamos;
    }
}
