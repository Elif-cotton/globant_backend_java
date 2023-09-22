package Servicio;

import Entidades.Persona;
import Enumeracion.Sexo;

import java.util.Scanner;

public class PersonaServicio {
    Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");

    public Persona crearPersona(){
        Persona p=new Persona();

        System.out.println("Ingrese el nombre de la persona: ");
        p.setNombre(leer.next());


        System.out.println("Ingrese la edad de la persona: ");
        p.setEdad(leer.nextInt());

        leer.nextLine();

        do{
            System.out.println("Ingrese el sexo de la persona: HOMBRE, MUJER y OTRO ");
            String sexoIngresado=leer.nextLine().toUpperCase();

            try{
                p.setSexo(Sexo.valueOf(sexoIngresado));
                break; // La entrada es válida, salir del bucle
            }catch(IllegalArgumentException e){
                System.out.println("Entrada inválida. Por favor, ingrese 'HOMBRE' , 'MUJER' u 'OTRO'.");
            }
        }while(true);

        System.out.println("Ingrese el peso de la persona en kg: ");
        p.setPeso(leer.nextDouble());

        System.out.println("Ingrese la altura de la persona en metros: ");
        p.setAltura(leer.nextDouble());


        return p;

    }


    public double calcularIMC(Persona p) {

        double imc = p.getPeso() / Math.pow(p.getAltura(), 2);

        if (imc < 20) {
            return -1;
        } else if (imc >= 20 && imc <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad(Persona p){
        return p.getEdad()>=18;
    }

    public void getDetails(Persona person) {

        System.out.println(person.toString());
    }

}
