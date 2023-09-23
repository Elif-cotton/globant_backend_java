import Entidades.Curso;
import Servicio.CursoServicio;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");

        CursoServicio cs=new CursoServicio();

        Curso c=cs.crearCurso();

        System.out.println("Los alumnos que asistieron a clase son : "+ Arrays.toString(c.getAlumnos()));
        System.out.println("Datos"+c.toString());
        System.out.println("Las ganancias semanales fueron: "+cs.calcularGananciaSemanal(c));
    }
}