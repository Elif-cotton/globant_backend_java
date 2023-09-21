package Servicio;

import Entidades.Operacion;

import java.util.Scanner;

public class OperacionServicio {

    Scanner leer=new Scanner(System.in);

    public Operacion ingresarNumeros(){

        Operacion o1=new Operacion();

        System.out.println("Ingrese el primer número: ");
        o1.setNumero1(leer.nextDouble());

        System.out.println("Ingrese el primer número: ");
        o1.setNumero2(leer.nextDouble());

        return o1;
    }

    public Double sumar(Operacion o1){
        return o1.getNumero1()+o1.getNumero2();
    }

    public Double restar(Operacion o1){
        return o1.getNumero1()-o1.getNumero2();
    }

    public double multiplicar(Operacion o1){
        if (o1.getNumero2() == 0 || o1.getNumero2() ==0) {
            System.out.println("Error: No se puede multiplicar por cero.");
            return 0;
        } else {
            return o1.getNumero1()*o1.getNumero2();
        }
    }

    public double dividir(Operacion o1){
        if (o1.getNumero2() == 0) {
            System.out.println("Error: No se puede multiplicar por cero.");
            return 0;
        } else {
            return o1.getNumero1()/o1.getNumero2();
        }
    }

}
