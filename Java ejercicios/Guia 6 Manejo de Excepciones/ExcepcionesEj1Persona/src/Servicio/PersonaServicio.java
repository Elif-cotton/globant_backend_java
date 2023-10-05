
package Servicio;

import Entidades.Persona;
import java.util.Scanner;

/**
 *
 * @author javer
 */
public class PersonaServicio {
     private static final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    // Método para crear una persona
    public Persona crearPersona() {
        Persona persona=new Persona();
        System.out.print("Ingrese el nombre: ");
        String nombre = leer.next();
        persona.setNombre(nombre);
        System.out.print("Ingrese la edad: ");
        int edad = leer.nextInt();
        persona.setEdad(edad);
        
         // Validar el sexo 
        System.out.println("Ingrese el sexo (H - hombre, M - mujer, O - otro):");
        char sexo = leer.next().toUpperCase().charAt(0);
        while (sexo != 'H' && sexo != 'M' && sexo != 'O') {
            System.out.println("Sexo inválido, ingrese nuevamente (H - hombre, M - mujer, O - otro):");
            sexo = leer.next().toUpperCase().charAt(0);
        }
      
        System.out.print("Ingrese el peso (en kg): ");
        double peso = leer.nextDouble();
        persona.setPeso(peso);
        System.out.print("Ingrese la altura (en metros): ");
        double altura = leer.nextDouble();
        persona.setAltura(altura);

        return new Persona(nombre, edad, sexo, peso, altura);
    }
    
     // Método para calcular el IMC
     public int calcularIMC(Persona persona) {
        double imc = persona.getPeso() / Math.pow(persona.getAltura(), 2);

        if (imc < 20) {
            return -1;
        } else if (imc >= 20 && imc <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    // Método para verificar si es mayor de edad validar 
    public boolean esMayorDeEdad(Persona persona) throws Exception {
        if (persona == null) {
            throw new Exception("La persona está mal cargada");
        }
        return persona.getEdad() >= 18;
    }
}
