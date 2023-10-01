
package Servicio;

import Entidad.Carta;

/**
 *
 * @author javer
 */
public class BarajaServicio {
    
    public static int generaNumeroEnteroAleatorio(int minimo, int maximo) {
        int num = (int) (Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
        return num;
    }
}
