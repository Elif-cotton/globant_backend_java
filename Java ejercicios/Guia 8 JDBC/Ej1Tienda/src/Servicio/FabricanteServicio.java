
package Servicio;

import Entidades.Fabricante;
import Persistencia.FabricanteDAO;

/**
 *
 * @author javer
 */
public class FabricanteServicio {
    
     private FabricanteDAO dao;

    public FabricanteServicio() {
        this.dao = new FabricanteDAO();
    }
    
//10) Ingresar un fabricante a la base de datos
    public void agregarFabricante(Fabricante nuevoFabricante) throws Exception {
        dao.agregarFabricante(nuevoFabricante);
    }
    
    
}
