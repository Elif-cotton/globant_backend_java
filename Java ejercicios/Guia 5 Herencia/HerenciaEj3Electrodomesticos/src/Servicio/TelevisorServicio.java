
package Servicio;

import Entidades.Electrodomestico;
import Entidades.Televisor;
import java.util.Scanner;

/**
 *
 * @author javer
 */
public class TelevisorServicio extends ElectrodomesticoServicio {
    
     private static Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");
    
    public Televisor crearTelevisor() {
        
        Electrodomestico electro = crearElectrodomestico();
       
        Televisor televisor = new Televisor();
        televisor.setPrecio(electro.getPrecio());
        televisor.setColor(electro.getColor());
        televisor.setConsumoEnergetico(electro.getConsumoEnergetico());
        televisor.setPeso(electro.getPeso());
        
        System.out.println("Ingrese la resolución en pulgadas: ");
        int pulgadas= leer.nextInt();
        televisor.setResolucion(pulgadas);

        System.out.print("Tú tienes un sincronizador? (S/N): ");
        if (leer.next().charAt(0)=='S'){
            televisor.setSintonizador(true);
        } else{
            televisor.setSintonizador(false);
        }
        
        return televisor;
    }
    
    public void precioFinal(Televisor televisor) {
        
         super.precioFinal(televisor);
        
        if(televisor.getResolucion()>40){
           televisor.setPrecio(televisor.getPrecio()*1.3);
        }
        if(televisor.isSintonizador()){
           televisor.setPrecio(televisor.getPrecio()+500);
        }
        
        System.out.println("El precio final del televisor es: "+televisor.getPrecio());
    }

   
}
