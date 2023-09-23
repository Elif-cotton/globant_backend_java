import Entidades.Fecha;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leer=new Scanner(System.in).useDelimiter("\n");

        Fecha f=new Fecha();

        System.out.println("Ingrese el día ");
        int dia=leer.nextInt();

        System.out.println("Ingrese el mes ");
        int mes=leer.nextInt();

        System.out.println("Ingrese el año ");
        int anio=leer.nextInt();

        // Crear la fecha ingresada por el usuario
        LocalDate fechaIngresada = LocalDate.of(anio,mes,dia); // Creamos el objeto tipo Date
        f.setFechaIngresada(LocalDate.of(anio,mes,dia));

        System.out.println("La fecha ingresada es: "+f.getFechaIngresada());

        // Obtener la fecha actual
        LocalDate fechaHoy = LocalDate.now();
        System.out.println("La fecha actual es: "+ fechaHoy);

        Period diferenciaAnios = Period.between(f.getFechaIngresada(), fechaHoy);

        System.out.println("La diferencia de años entre la fecha ingresada: "+ fechaIngresada+
                " y la fecha actual "+fechaHoy.toString()+" es: "+diferenciaAnios.getYears());



    }
}