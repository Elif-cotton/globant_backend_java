
package Persistencia;

import Entidades.Cliente;
import java.util.List;

/**
 *
 * @author javer
 */
public class ClienteDAO extends DAO<Cliente>{
    
    @Override
    public void guardar(Cliente cliente) {
        super.guardar(cliente);
    }

    @Override
    public void actualizar(Cliente cliente) {
        super.actualizar(cliente);
    }

    @Override
    public void eliminar(Cliente cliente) {
        super.eliminar(cliente);
    }
    
    public Cliente buscarCliente(Integer id) {
        conectar();
        Cliente cliente = em.find(Cliente.class, id);
        desconectar();
        return cliente;
    }

    public List<Cliente> buscarClienteNombre(String nombre) {
        conectar();
        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c where c.nombre = :nombre c.alta = TRUE").setParameter("nombre", nombre).getResultList();
        desconectar();
        return clientes;
    }

    public List<Cliente> buscarClienteDocumento(long dni) {
        conectar();
        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c where c.documento = :documento AND c.alta = TRUE").setParameter("documento", dni).getResultList();
        desconectar();
        return clientes;
    }

    public Cliente buscarClienteId(Long id) {
        conectar();
        Cliente cliente = em.find(Cliente.class, id);  //método fin cuándo se busca por llave primaria
        desconectar();
        return cliente;
    }
}

