
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
    public void agregarFabricante(String nombre) throws Exception {
         try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre del fabricante");
            }
            
            //Creamos el fabricante
            Fabricante fabricante = new Fabricante();
            fabricante.setNombre(nombre);
            
            dao.agregarFabricante(fabricante);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    
}
