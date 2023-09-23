import Entidades.Arreglo;
import Servicio.ArregloServicio;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        Random random = new Random();

        Arreglo a=new Arreglo();
        ArregloServicio as=new ArregloServicio();

        double arregloA[] = new double[50];
        double arregloB[] = new double[20];


        for (int i = 0; i < arregloA.length; i++) {

            arregloA[i] = Math.floor(random.nextDouble() * 100); // Genera un número aleatorio entre 0 y 100

        }

        a.setArregloA(arregloA);


        // Mostrar arregloA por pantalla
        System.out.println("Arreglo A (desordenado):");
        as.mostrar(arregloA);

        // Ordenar arregloA de menor a mayor
        System.out.println("Arreglo A (ordenado):");
        Arrays.sort(arregloA);
        as.mostrar(arregloA);


        System.out.println("Arreglo B:");
        // Copiar los primeros 10 números ordenados a arregloB
        for (int i = 0; i < 10; i++) {
            arregloB[i] = arregloA[i];
        }

        // Rellenar los 10 últimos elementos de arregloB con el valor 0.5
        for (int i = 10; i < arregloB.length; i++) {
            arregloB[i] = 0.5;
        }

        as.mostrar(arregloB);

        //Arrays.toString(arregloA);

    }
}