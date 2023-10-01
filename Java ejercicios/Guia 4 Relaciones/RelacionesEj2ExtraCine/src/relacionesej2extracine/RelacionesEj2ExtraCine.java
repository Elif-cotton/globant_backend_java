
package relacionesej2extracine;

import Entidad.Cine;
import Entidad.Pelicula;
import java.util.Scanner;

/**
 *
 * @author javer
 */
public class RelacionesEj2ExtraCine {
    private static Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");
    
    public static void main(String[] args) {
        
        Pelicula pelicula = new Pelicula("Harry Potter", 156, 13, "Chris Columbus");
        Cine cine = new Cine(pelicula, 3500);
        
        cine.generarEspectadorAleatorio();
        cine.llenarSala();
        cine.mostrarSala();

    
    }
    
}
