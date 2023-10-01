
package relacionesej3extraaseguradora;

import Servicio.ClienteServicio;
import Servicio.PolizaServicio;
import Servicio.VehiculoServicio;

/**
 *
 * @author javer
 */
public class RelacionesEj3ExtraAseguradora {

    public static void main(String[] args) {
       
        ClienteServicio clienteServicio = new ClienteServicio();
        VehiculoServicio vehiculoServicio = new VehiculoServicio();
        PolizaServicio polizaServicio = new PolizaServicio();
       
//        clienteServicio.MostrarCliente();
//        vehiculoServicio.MostrarVehiculos();
        
        vehiculoServicio.mostrarClientesYVehiculos();
        
    }
}
