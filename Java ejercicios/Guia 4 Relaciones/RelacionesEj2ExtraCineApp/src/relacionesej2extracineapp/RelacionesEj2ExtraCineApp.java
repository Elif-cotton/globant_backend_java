
package relacionesej2extracineapp;

import Entidad.Cine;
import Entidad.Espectador;
import Entidad.Pelicula;
import Servicio.Metodos;

/**
 *
 * @author javer
 */
public class RelacionesEj2ExtraCineApp {


    public static void main(String[] args) {
        
        Pelicula pelicula=new Pelicula("Harry Potter", 156, 16,"Chris Columbus" );
        
        Cine cine= new Cine(8,9,5.5, pelicula);
        
        int numEspectadores=5;
        int fila=0;
        char letra=0;
        
        Espectador espectador;
        for(int i=0; i< numEspectadores && cine.haySitio();i++){
            espectador=new Espectador(
                    Metodos.nombres[Metodos.generarNumeroEnteroAleatorio(0, Metodos.nombres.length-1)],//Nombre al azar
                    Metodos.generarNumeroEnteroAleatorio(10, 30), //Genera una edad entre 10 y 30
                    Metodos.generarNumeroRealAleatorio(1, 10));//Genera el dinero entre 1 y 10 euros
            
            System.out.println(espectador); //muestra info espectador
            
            do{
                fila= Metodos.generarNumeroEnteroAleatorio(0, cine.getFilas()-1);  //0 a 7 filas
                letra=(char) Metodos.generarNumeroEnteroAleatorio('A','A'+ (cine.getColumnas()-1));  //convertir de número a char
             
            }while(cine.haySitioButaca(fila, letra));  //si no hay sitio que lo genere otra vez, hasta encontrar una libre
            
            //si el espactador cumple con las condiciones
            if(cine.sePuedeSentar(fila, letra, espectador)){   //comprobar si se puede sentar 
                espectador.pagar(cine.getPrecio());  //El espectador paga el precio de la entrada
                cine.sentar(fila, letra, espectador);  //El espectador se puede sentar
                    
            }
        }
        System.out.println("");
        cine.mostrarCine();
        
        System.out.println("Ha comprado correctamente");
    }
    
}
