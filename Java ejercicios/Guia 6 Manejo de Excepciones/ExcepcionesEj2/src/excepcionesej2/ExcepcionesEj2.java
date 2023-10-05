
package excepcionesej2;

import static Entidades.Dos.metodo;

/**
 *
 * @author javer
 */
public class ExcepcionesEj2 {

    
    public static void main(String[] args) {
        
        try{
            System.out.println ( metodo ( ) ) ;
        } catch(Exception e) {
            System.err.println ( " Excepcion en metodo ( ) " ) ;
            e.printStackTrace();
        }
        
    }
    
}
