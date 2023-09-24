import Entidades.Raices;
import Servicio.RaicesServicio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");

        RaicesServicio rs=new RaicesServicio();

        Raices r1 =new Raices(1.2,8.3,1.0);
        Raices r2 =new Raices(6.2,-1.3,8.0);
        Raices r3=new Raices(2.0, 4.0,2.0);

        Raices[] ecuaciones={r1,r2,r3};

        for (Raices r : ecuaciones){
            System.out.println("**************");
            System.out.println(
                    String.format("%,.0fx^2 + %,.0fx + %,.0f",
                            r.getA(),r.getB(),r.getC())
            );
            System.out.println("Discriminante: "+rs.getDiscriminante(r));
            rs.calcular(r);
        }

//        System.out.println("Discriminante:"+rs.getDiscriminante(r1));
//
//        System.out.println("");
//        System.out.println("¿Tienes dos soluciones? "+rs.tieneRaices(r1));
//        System.out.println("¿Tienes una solución? "+rs.tieneRaiz(r1));
//        rs.obtenerRaices(r1);
//        rs.obtenerRaiz(r1);
//        System.out.println("");
//
//
//        System.out.println("Discriminante:"+rs.getDiscriminante(r2));
//        System.out.println("¿Tienes dos soluciones? "+rs.tieneRaices(r2));
//        System.out.println("¿Tienes una solución? "+rs.tieneRaiz(r2));
//        rs.obtenerRaices(r2);
//        System.out.println("");
//        rs.obtenerRaiz(r2);
//        System.out.println("");

    }
}