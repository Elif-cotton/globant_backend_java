import Entidades.Persona;
import Servicio.PersonaServicio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leer=new Scanner(System.in).useDelimiter("\n");
        PersonaServicio ps=new PersonaServicio();
        Persona p=ps.crearPersona();

        ps.calcularEdad(p);

        System.out.println("es menor que 30? "+ ps.menorQue(p, 30));
        ps.mostrarEdad(p);
        ps.mostrarPersona(p);
    }
}