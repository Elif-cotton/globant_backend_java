package Servicio;

import Entidades.Punto;

import java.util.Scanner;

public class PuntoServicio {
    Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");

    public Punto crearPuntos() {

        Punto p = new Punto();

        System.out.println("Ingrese el valor de x1: ");
        p.setX1(leer.nextDouble());

        System.out.println("Ingrese el valor de y1: ");
        p.setY1(leer.nextDouble());

        System.out.println("Ingrese el valor de x2: ");
        p.setX2(leer.nextDouble());

        System.out.println("Ingrese el valor de y2: ");
        p.setY2(leer.nextDouble());

        return p;

    }

    public void calcularDistancia(Punto p) {

//        double x=p.getX2()-p.getX1();
//        double y=p.getY2()-p.getY1();
        //double resultado= Math.pow(p.getX2()-p.getX1(), 2)+Math.pow(p.getY2()-p.getY1(),2);
        double distancia = Math.sqrt((Math.pow(p.getX2() - p.getX1(), 2) + Math.pow(p.getY2() - p.getY1(), 2)));

        System.out.println("La distancia entre dos puntos es: " + Math.round(distancia));

    }
}
