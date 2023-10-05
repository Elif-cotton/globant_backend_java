
package excepcionesejemplo3;

import static Entidades.Tres.metodo;

/**
 *
 * @author javer
 */
public class ExcepcionesEjemplo3 {

    
    public static void main(String[] args) {
        
        try{
            System.out.println( metodo ( ) ) ;
        } catch(Exception e) {
            System.err.println("Excepcion en metodo ( ) ") ;
            e.printStackTrace();
        }
        
    }
    
}
