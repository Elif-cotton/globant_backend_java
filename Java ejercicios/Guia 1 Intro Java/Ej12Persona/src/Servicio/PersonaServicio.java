package Servicio;

import Entidades.Persona;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class PersonaServicio {

    Scanner leer=new Scanner(System.in).useDelimiter("\n");


    public Persona crearPersona(){
        Persona p=new Persona();

        System.out.println("Ingrese su nombre ");
        String nombre=leer.next();
        p.setNombre(nombre);

        System.out.println("Ingrese el día ");
        int dia=leer.nextInt();

        System.out.println("Ingrese el mes ");
        int mes=leer.nextInt();

        System.out.println("Ingrese el año ");
        int anio=leer.nextInt();

        p.setFechaNacimiento(LocalDate.of(anio,mes,dia));
        System.out.println(p.getFechaNacimiento());
        return p;
    }

    public int calcularEdad(Persona p){

        LocalDate fechaHoy = LocalDate.now();
        System.out.println(fechaHoy);
        System.out.println(p.getFechaNacimiento());
        Period edad = Period.between(p.getFechaNacimiento(), fechaHoy);

        return edad.getYears();

    }

    public void mostrarEdad(Persona p) {

        System.out.println("Edad es: " + calcularEdad(p));

    }


    public boolean menorQue(Persona p, int edad){

        return calcularEdad(p)<edad;

    }

    public void mostrarPersona(Persona p){

        System.out.println(p.toString());
    }
}
