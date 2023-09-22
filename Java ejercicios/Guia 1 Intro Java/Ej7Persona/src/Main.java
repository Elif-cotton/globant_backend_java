import Entidades.Persona;
import Servicio.PersonaServicio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");

        PersonaServicio ps=new PersonaServicio();

        Persona p1=ps.crearPersona();
        ps.calcularIMC(p1);
        ps.esMayorDeEdad(p1);

        //crear 4 personas, la altura se ingresa con , ej: 1,70 metros
        Persona p2=ps.crearPersona();
//       Persona p3=ps.crearPersona();
//       Persona p4=ps.crearPersona();


        //Calcular el imc para cada persona
        ps.calcularIMC(p1);
//       ps.calcularIMC(p2);
//       ps.calcularIMC(p3);
//       ps.calcularIMC(p4);

        //Calcular si es mayor de edad
        ps.esMayorDeEdad(p1);
//       ps.esMayorDeEdad(p2);
//       ps.esMayorDeEdad(p3);
//       ps.esMayorDeEdad(p4);
        System.out.println("");
        System.out.println("Información :"+p1.toString());
        System.out.println("¿Está en su peso "+p1.getNombre()+" ? " );
        System.out.println("Su retorno es: "+ps.calcularIMC(p1));
        if (ps.calcularIMC(p1) == -1) {
            System.out.println("Por debajo del peso ideal.");
        } else if (ps.calcularIMC(p1) == 0) {
            System.out.println("Peso ideal.");
        } else {
            System.out.println("Sobrepeso.");
        }
        System.out.println("¿Es mayor de edad "+p1.getNombre()+" ? "+ps.esMayorDeEdad(p1));


        System.out.println("");
        System.out.println("Información :"+p2.toString());
        System.out.println("¿Está en su peso "+p2.getNombre()+" ? " );
        System.out.println("Su retorno es: "+ps.calcularIMC(p2));
        if (ps.calcularIMC(p2) == -1) {
            System.out.println("Por debajo del peso ideal.");
        } else if (ps.calcularIMC(p2) == 0) {
            System.out.println("Peso ideal.");
        } else {
            System.out.println("Sobrepeso.");
        }
        System.out.println("¿Es mayor de edad "+p2.getNombre()+" ? "+ps.esMayorDeEdad(p2));


    }
}