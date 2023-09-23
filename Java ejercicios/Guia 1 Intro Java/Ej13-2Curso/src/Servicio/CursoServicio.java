package Servicio;

import Entidades.Curso;
import Enumeracion.Turno;

import java.util.Scanner;

public class CursoServicio {
    Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");

    public void cargarAlumnos(Curso c){

        String[] alumnos=c.getAlumnos();
        for (int i=0;i<alumnos.length;i++){

            System.out.print("Ingrese el nombre del alumno que asistió a clases "+(i+1)+": ");

            alumnos[i]=leer.nextLine();

        }

    }

    public Curso crearCurso(){
        Curso c=new Curso();

        System.out.println("Ingrese el nombre del curso: ");
        c.setNombreCurso(leer.nextLine());

        System.out.println("Ingrese la cantidad de horas por día: ");
        c.setCantidadHorasPorDia(leer.nextInt());

        System.out.println("Ingrese la cantidad de días por semana: ");
        c.setCantidadDiasPorSemana(leer.nextInt());

        leer.nextLine();


//        System.out.println("Ingrese si el turno es de mañana o tarde: ");
//        String turno = leer.nextLine().toUpperCase();
//
//        c.setTurno(Turno.valueOf(turno));

        do {
            System.out.println("Ingrese si el turno es de mañana o tarde: ");
            String turnoIngresado = leer.nextLine().toUpperCase();

            try {
                c.setTurno(Turno.valueOf(turnoIngresado));
                break;  // La entrada es válida, salir del bucle
            } catch (IllegalArgumentException e) {
                System.out.println("Entrada inválida. Por favor, ingrese 'Mañana' o 'Tarde'.");
            }
        } while (true);


        System.out.println("Ingrese el precio por hora: ");
        c.setPrecioPorHora(leer.nextInt());

        leer.nextLine();

        cargarAlumnos(c);   //llamar el método cargar alumnos

        return c;
    }


    public double calcularGananciaSemanal(Curso c){

        double gananciaCurso=c.getCantidadHorasPorDia()*c.getPrecioPorHora()*c.getAlumnos().length*c.getCantidadDiasPorSemana();

        return gananciaCurso;
    }
}
