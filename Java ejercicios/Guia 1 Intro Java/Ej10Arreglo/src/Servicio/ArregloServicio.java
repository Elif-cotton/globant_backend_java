package Servicio;

import Entidades.Arreglo;

import java.util.Scanner;

public class ArregloServicio {

    Scanner leer=new Scanner(System.in).useDelimiter("\n");

    public void mostrar(double[] arregloA){
        Arreglo a=new Arreglo();

        for (int i = 0; i <arregloA.length; i++) {

            System.out.println("[" + arregloA[i] + "]"); // Mostramos el vector

        }
        System.out.println("");
    }
}
