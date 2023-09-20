package Servicio;

import Entidad.Circunferencia;

import java.util.Scanner;

public class CircunferenciaServicio {

    private Scanner leer=new Scanner(System.in);

    public Circunferencia crearCircunferencia(){

        Circunferencia r1=new Circunferencia();

        System.out.println("Introduzca el radio de la circunferencia: ");
        r1.setRadio(leer.nextDouble());
        return r1;
    }

    public Double area(Circunferencia r1){

        Double area= Math.PI*Math.pow(r1.getRadio(), 2);
        return area;
    }

    public Double perimetro(Circunferencia r1){

        Double perimetro=2* Math.PI*r1.getRadio();
        return perimetro;
    }

}
