package Servicio;

import Entidades.Raices;

import java.util.Scanner;

public class RaicesServicio {
    Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");

    public Double getDiscriminante(Raices r){

        double discriminante=Math.round(Math.pow(r.getB(), 2)-(4*r.getA()*r.getC())) ;
        //(b^2)-4*a*c

        return discriminante;
    }

    public boolean tieneRaices(Raices r){

        double d = getDiscriminante(r);

        return d>=0;

    }

    public boolean tieneRaiz(Raices r){

        double d = getDiscriminante(r);

        return d==0;

    }


    public void obtenerRaices(Raices r){

        boolean s = tieneRaices(r);
        if (s==true){
            double x1 = (-r.getB() + Math.sqrt(getDiscriminante(r))) / (2 * r.getA());
            double x2 = (-r.getB() - Math.sqrt(getDiscriminante(r))) / (2 * r.getA());

            System.out.println("Las posibles soluciones son: x1 = " + x1 + ", x2 = " + x2);
        } else {
            System.out.println("No hay una única solución");
        }

    }

    public void obtenerRaiz(Raices r){

        boolean so = tieneRaiz(r);
        if (so==true){
            double x = -r.getB()/(2 * r.getA());

            System.out.println("La posible solución es: x = " + x );
        } else {
            System.out.println("No hay solución");
        }

    }

    //    Método calcular(): esté método llamará tieneRaices() y a tieneRaíz(), y mostrará por
//pantalla las posibles soluciones que tiene nuestra ecuación con los métodos
//obtenerRaices() o obtenerRaiz(), según lo que devuelvan nuestros métodos y en caso
//de no existir solución, se mostrará un mensaje.
    public void calcular(Raices r){
        if (getDiscriminante(r) > 0) {
            obtenerRaices(r);
        } else {
            obtenerRaiz(r);

        }
    }
}
