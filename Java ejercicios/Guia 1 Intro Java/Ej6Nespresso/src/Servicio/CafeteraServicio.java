package Servicio;

import Entidades.Cafetera;

import java.util.Scanner;

public class CafeteraServicio {
    Scanner leer=new Scanner(System.in);

    public Cafetera ingresarCafetera(){

        Cafetera c1=new Cafetera();

        System.out.println("Ingrese la cantidad actual de café que posee la cafetera en gr: ");
        c1.setCantidadActual(leer.nextDouble());
        System.out.println("Ingrese la capacidad máxima de café que posee la cafetera en gr: ");
        c1.setCapacidadMaxima(leer.nextDouble());

        return c1;
    }

    public void llenarCafetera(Cafetera c1){

        Double cantidadRestante = c1.getCapacidadMaxima() - c1.getCantidadActual();

        if (cantidadRestante==0){
            System.out.println("Se llenó la cafetera");

        }else{
            System.out.println("No alcanza a llenar la capacidad máxima de la cafetera, faltan "+ cantidadRestante+"gr");

        }
    }

    public void servirTaza(int tamanoTaza,int llenadoTaza){

        Cafetera c1=new Cafetera();
        int cantidadRestanteTaza =tamanoTaza-llenadoTaza;

        if (cantidadRestanteTaza==0){
            System.out.println("Se llenó la taza");

        }else{
            System.out.println("No se alcanzó a llenar la taza, se llenó "+llenadoTaza+"cm ,faltan llenar "+ cantidadRestanteTaza+"cm");

        }
    }

    public void vaciarCafetera(Cafetera c1){

        c1.setCantidadActual(0.0);
        System.out.println("Cantidad actual de café es:"+c1.getCantidadActual());
    }

    public void agregarCafé(Double cantidadCafe){
        Cafetera c1=new Cafetera();

        c1.setCantidadActual((cantidadCafe));
        System.out.println("Cantidad actual de café es:"+c1.getCantidadActual());

    }

}
