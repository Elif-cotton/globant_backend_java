
package excepcionesej1;

import static Entidades.Uno.metodo;

/**
 *
 * @author javer
 */
public class ExcepcionesEj1 {

 
    public static void main(String[] args) {
        
        try {
            System.out.println (metodo()) ;
        }catch(Exception e) {
            System.err.println("Excepcion en metodo() ") ;
            e.printStackTrace();
        }
        
    }
    
}
