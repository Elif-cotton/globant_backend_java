package Servicio;

import Entidades.Electrodomestico;
import Entidades.Lavadora;

import java.util.Scanner;

public class LavadoraServicio extends ElectrodomesticoServicio{
    private static Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");

    public Lavadora crearLavadora() {
        Electrodomestico electro = crearElectrodomestico();

        Lavadora lavadora= new Lavadora();
        lavadora.setPrecio(electro.getPrecio());
        lavadora.setColor(electro.getColor());
        lavadora.setConsumoEnergetico(electro.getConsumoEnergetico());
        lavadora.setPeso(electro.getPeso());

        System.out.println("Ingrese la carga de la lavadora: ");
        int carga=leer.nextInt();
        lavadora.setCarga(carga);

        return lavadora;
    }

    public void precioFinal(Lavadora lavadora){

        super.precioFinal(lavadora);

        if(lavadora.getCarga()>30){
            lavadora.setPrecio(lavadora.getPrecio()+500);
        }
        System.out.println("El precio de la lavadora es: "+lavadora.getPrecio());
    }

}
