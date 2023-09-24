import Entidades.Cancion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");

        Cancion c1=new Cancion();
        c1.setTitulo("Butter");
        c1.setAutor("BTS");

        Cancion c2=new Cancion("Super","Seventeen");

        System.out.println("Datos: "+c1.toString());
        System.out.println("Datos: "+c2.toString());
    }
}