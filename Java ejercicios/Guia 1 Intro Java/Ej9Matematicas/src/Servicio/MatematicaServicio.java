package Servicio;

import Entidades.Matematica;

import java.util.Scanner;

public class MatematicaServicio {
    Scanner leer=new Scanner(System.in).useDelimiter("\n");
    Matematica m=new Matematica();

    public static double devolverMayor(Matematica m) {

        return Math.max(m.getNum1(), m.getNum2());
    }

    public static double calcularPotencia(Matematica m){

        double mayor=Math.max(m.getNum1(), m.getNum2());
        double menor=Math.min(m.getNum1(), m.getNum2());

        int mayorRound=(int) Math.round(mayor);
        int menorRound=(int) Math.round(menor);

        return Math.pow(mayorRound, menorRound);

    }

    public static double calcularRaiz(Matematica m){

        double menor=Math.min(m.getNum1(), m.getNum2());

        int menorRound=(int) Math.round(menor);

        return Math.sqrt(menorRound);

    }

}
