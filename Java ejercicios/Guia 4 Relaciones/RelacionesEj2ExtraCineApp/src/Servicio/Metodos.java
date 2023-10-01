
package Servicio;

/**
 *
 * @author javer
 */
public class Metodos {
    
   public static final String nombres[] = {"María", "Luis", "Roberto", "Estefania","Sara", "Mauricio"};
 
    
    public static int generarNumeroEnteroAleatorio(int minimo, int maximo){
        int num=(int) Math.floor(Math.random()*(minimo-(maximo+1))+(maximo+1));
        return num;
    }
    
    public static double generarNumeroRealAleatorio(int minimo, int maximo){
        double num= Math.floor(Math.random()*(minimo-(maximo+1))+(maximo+1));
        return num;
    }
}
