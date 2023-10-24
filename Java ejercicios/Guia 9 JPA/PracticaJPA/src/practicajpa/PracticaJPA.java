
package practicajpa;

import Servicios.ServiciosGenerales;

/**
 *
 * @author javer
 */
public class PracticaJPA {

   
    public static void main(String[] args) {
        ServiciosGenerales serviciosGenerales =  new ServiciosGenerales();
        serviciosGenerales.cargarBase();
        serviciosGenerales.consultas();
    }
    
}
