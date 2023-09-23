import Entidades.Cadena;
import Servicio.CadenaServicio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in).useDelimiter("\n");
        CadenaServicio cs=new CadenaServicio();
        Cadena c=new Cadena();

        System.out.println("Ingrese una frase: ");
        c.setFrase(leer.next());

        c.setLongitud(c.getFrase().length());

        System.out.println("longitud "+c.getLongitud());

        //métodos
        cs.mostrarVocales(c);

        cs.invertirFrase(c);

        cs.invertirFrase1(c); //OTRA FORMA DE INVERTIR FRASE


        cs.vecesRepetido(c);

        // System.out.println("Ingrese una nueva frase: ");
        // String nuevaFrase= leer.nextLine();
        //cs.compararLongitud(nuevaFrase);
        System.out.println("");
        cs.compararLongitud("casa azulada",c);
        cs.compararLongitud("el niño juega feliz",c);
        cs.compararLongitud("adios",c);

        System.out.println("");
        cs.unirFrases("el cielo es azul",c);

        System.out.println("");
        cs.reemplazar("&", c);
        cs.reemplazar("%", c);

//        System.out.println("");
//        System.out.println("Ingrese una nueva letra: ");
//        String letra= leer.nextLine();
//        cs.contiene(letra, c);

        System.out.println("");
        if (cs.contiene("b",c))
            System.out.println("La frase contiene b");
        else
            System.out.println("La frase NO contiene b");

        if (cs.contiene("m",c))
            System.out.println("La frase contiene m");
        else
            System.out.println("La frase NO contiene m");
    }

}