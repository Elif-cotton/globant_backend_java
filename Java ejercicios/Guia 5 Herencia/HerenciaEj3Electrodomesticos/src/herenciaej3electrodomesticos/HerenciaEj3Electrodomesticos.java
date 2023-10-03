
package herenciaej3electrodomesticos;

import Entidades.Electrodomestico;
import Entidades.Lavadora;
import Entidades.Televisor;
import Servicio.LavadoraServicio;
import Servicio.TelevisorServicio;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author javer
 */
public class HerenciaEj3Electrodomesticos {

    private static Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");
    public static void main(String[] args) {
       
        ArrayList<Electrodomestico> electrodomesticosList = new ArrayList<>();
        
        LavadoraServicio ls=new LavadoraServicio();
        TelevisorServicio ts=new TelevisorServicio();
        
        int opcion;
        for (int i = 0; i < 4; i++) {
            do{
                System.out.println("1- Crear lavadora");
                System.out.println("2- Crear un Televisor");
                System.out.println("3- Salir");
                System.out.println("Seleccione una opción");
                opcion=leer.nextInt();
            }while(opcion !=1 && opcion!=2);
            
            switch(opcion){
                case 1:
                    Lavadora lavadora=ls.crearLavadora();
                    electrodomesticosList.add(lavadora);
                    break;
                case 2:
                    Televisor televisor=ts.crearTelevisor();
                    electrodomesticosList.add(televisor);
                    break;
                case 3:
                    System.out.println("Vuelva pronto");
                    break;
                default:
                    System.out.println("No se reconoce la opción ingresada");
            }
        }
        
        double precioTotalElectrodomesticos = 0;
        double precioTotalLavadoras = 0;
        double precioTotalTelevisores = 0;
        
        for (Electrodomestico electrodomestico : electrodomesticosList) {
            if (electrodomestico instanceof Lavadora){
                Lavadora lavadora= (Lavadora) electrodomestico; //transformar un objeto de una clase a otra clase siempre 
                                                                 //y cuando haya una relación de herencia entre ambas
                ls.precioFinal(lavadora);
                precioTotalElectrodomesticos += lavadora.getPrecio();
                precioTotalLavadoras += lavadora.getPrecio();
            }else{
                Televisor televisor= (Televisor) electrodomestico;
                ts.precioFinal(televisor);
                precioTotalElectrodomesticos += televisor.getPrecio();
                precioTotalTelevisores += televisor.getPrecio();

            }
        }
        
        System.out.println("Precio total de electrodomésticos: " + precioTotalElectrodomesticos);
        System.out.println("Precio total de lavadoras: " + precioTotalLavadoras);
        System.out.println("Precio total de televisores: " + precioTotalTelevisores);
    }
    
}
