
package excepcionesej2dato;

import Entidades.MiArray;

/**
 *
 * @author javer
 */
public class ExcepcionesEj2Dato {

    
    public static void main(String[] args) {
        
        MiArray miObjeto = new MiArray(5);

        // Intentamos asignar valores a índices fuera de rango
        miObjeto.asignarValor(7, 42);

        // Intentamos obtener valores de índices fuera de rango
        int valor = miObjeto.obtenerValor(10);
        System.out.println("Valor obtenido: " + valor);
        
    }
    
}
