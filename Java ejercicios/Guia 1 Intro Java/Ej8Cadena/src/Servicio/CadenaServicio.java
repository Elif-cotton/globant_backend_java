package Servicio;

import Entidades.Cadena;

import java.util.Scanner;

public class CadenaServicio {
    Scanner leer=new Scanner(System.in).useDelimiter("\n");
    Cadena c=new Cadena();

    public void mostrarVocales(Cadena c){

        int contarVocales=0;

        for (int i=0; i<c.getFrase().length(); i++){
            char f=Character.toLowerCase(c.getFrase().charAt(i)); //poner la frase en minúscula y para separala en carácteres

            if (f=='a' || f=='e' || f=='i' || f=='o' || f=='u'){

                contarVocales++;
            }

        }

        System.out.println("La cantidad de vocales de la frase son: "+ contarVocales);

    }

    public void invertirFrase(Cadena c){

        String fraseInvertida = " ";

        for (int i = 0; i < c.getFrase().length(); i++) {
            fraseInvertida = c.getFrase().charAt(i) + fraseInvertida;
        }

        System.out.println(fraseInvertida);

    }

    public void invertirFrase1(Cadena c) {

        StringBuilder fraseInvertida = new StringBuilder(c.getFrase());

        fraseInvertida.reverse();
        System.out.println("Frase invertida: " + fraseInvertida.toString());
    }

    public void vecesRepetido(Cadena c){

        int contador=0;
        System.out.println("Ingrese una letra: ");
        char letra= leer.next().charAt(0);

        for (int i=0; i<c.getFrase().length();i++){
            if (c.getFrase().charAt(i)== letra) {

                contador++;
            }
        }
        System.out.println("El carácter '" + letra + "' se repite " + contador + " veces.");

    }

    public void compararLongitud(String nuevaFrase, Cadena c){

        //System.out.println("Ingrese una nueva frase: ");
        // String nuevaFrase= leer.nextLine();

        if (c.getFrase().length() == nuevaFrase.length()){
            System.out.println("Las longitudes de las frases son iguales");

        } else if (c.getFrase().length() < nuevaFrase.length()) {
            System.out.println("La frase ingresada es más larga que la frase guardada.");
        } else {
            System.out.println("La frase guardada es más larga que la frase ingresada.");
        }
    }

    public void unirFrases(String otraFrase, Cadena c) {

        String fraseUnida = c.getFrase()+" "+otraFrase;
        System.out.println("Frase resultante: " + fraseUnida);
    }

    public void reemplazar(String letra, Cadena c){

        String nuevaFrase = c.getFrase().replace('a', letra.charAt(0));
        System.out.println("Frase resultante: " + nuevaFrase);
    }

    public boolean contiene(String letra, Cadena c){

        return c.getFrase().contains(letra);
    }
}
