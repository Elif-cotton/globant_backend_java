
package Servicio;

import Entidades.Electrodomestico;
import java.util.Scanner;

/**
 *
 * @author javer
 */
public class ElectrodomesticoServicio {
    
     private static Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");
    
    public char comprobarConsumoEnergetico(char letra){
        
        //if(('A'==letra) || ('B'==letra) || ('C'==letra) || ('D'==letra) || ('E'==letra) || ('F'==letra)){
        letra=Character.toUpperCase(letra);
        if((letra >= 'A') && (letra<='F')){
            return letra;
        } else{
            return 'F';
        }
    }
    
    
    public String comprobarColor(String color){
        //color=color.toLowerCase();
        if ((color.equalsIgnoreCase("BLANCO")) || (color.equalsIgnoreCase("NEGRO")) ||
                (color.equalsIgnoreCase("ROJO")) || (color.equalsIgnoreCase("AZUL"))
                || (color.equalsIgnoreCase("GRIS")) ){
            return color;
        } else{
            return "BLANCO";
        }
    }
    
    public Electrodomestico crearElectrodomestico(){
        Electrodomestico electro = new Electrodomestico();

        System.out.print("Ingrese el color: ");
        String color = leer.next();
        electro.setColor(comprobarColor(color));
        
        System.out.print("Ingrese el tipo de consumo energetico(A/B/C/D/E/F): ");
        char consumo=leer.next().charAt(0);
        electro.setConsumoEnergetico(comprobarConsumoEnergetico(consumo));
        
        electro.setPrecio(1000);
        
        System.out.print("Ingrese el peso: ");
        int peso = leer.nextInt();
        electro.setPeso(peso);
    
        return electro;
    }
    
    public void precioFinal(Electrodomestico electro){
        
        switch(electro.getConsumoEnergetico()){
            case 'A':
                electro.setPrecio(electro.getPrecio()+1000);
                break;
            case 'B':
                electro.setPrecio(electro.getPrecio()+800);
                break;
            case 'C':
                electro.setPrecio(electro.getPrecio()+600);
                break;
            case 'D':
                electro.setPrecio(electro.getPrecio()+500);
                break;
            case 'E':
                electro.setPrecio(electro.getPrecio()+300);
                break;
            case 'F':
                electro.setPrecio(electro.getPrecio()+100);
                break;
            default: // Letra de consumo no válida
                electro.setPrecio(electro.getPrecio()+100);
            break;
        }
        
        if(electro.getPeso()>=1 && electro.getPeso()<=19){
            electro.setPrecio(electro.getPrecio()+100);
        }else if (electro.getPeso()>=20 && electro.getPeso()<=49){
            electro.setPrecio(electro.getPrecio()+500);
        }else if (electro.getPeso()>=50 && electro.getPeso()<=79){
            electro.setPrecio(electro.getPrecio()+800);
        }else if(electro.getPeso()>=80){
           electro.setPrecio(electro.getPrecio()+1000);
       }
          
    
    }
}
