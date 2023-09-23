import Entidades.Curso;
import Servicio.CursoServicio;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        CursoServicio cs=new CursoServicio();

        Curso c=cs.crearCurso();

        System.out.println("Los estudiantes que asistieron a clases son: "+ Arrays.toString(c.getAlumnos()));

        System.out.println("La ganancia semanal es de $"+cs.calcularGananciaSemanal(c));


    }
}