package Servicio;

import java.util.ArrayList;
import java.util.Scanner;

public class NumeroServicio {
    private static Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");

    ArrayList<Integer> numerosList= new ArrayList();

    public ArrayList <Integer> agregarNumeros(){
        int numero;

        do{
            System.out.println("Ingrese un número entero (-99 para terminar): ");
            numero = leer.nextInt();
            if (numero!=-99){
                numerosList.add(numero);
            }
        }while(numero!=-99);
        return numerosList;
    }

    public ArrayList<Integer> getPeliculas() {

        return numerosList;
    }

    public void mostrarNumeros(){
        for (Integer numero : numerosList) {
            System.out.println(numero);
        }

    }

    public void mostrarResultados(){

        int totalValores=numerosList.size();
        int suma=0;
        double promedio=0;

        for (Integer numero : numerosList) {
            suma+=numero;
        }

        promedio=(double)suma/totalValores;

        System.out.println("\nResultados:");
        System.out.println("Número de valores leídos: " + totalValores);
        System.out.println("Suma de los valores: " + suma);
        System.out.println("Media (promedio) de los valores: " + promedio);

    }
}
