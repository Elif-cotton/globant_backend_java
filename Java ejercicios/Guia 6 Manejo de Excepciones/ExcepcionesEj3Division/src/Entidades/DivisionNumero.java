
package Entidades;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author javer
 */
public class DivisionNumero {
    private static final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    private int numero1;
    private int numero2;

    public DivisionNumero() {
    }

    public DivisionNumero(int numero1, int numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }
    
    public void crearNumeros() {
       
        try {
            System.out.print("Ingrese el primer número: ");
            String num1Str = leer.next();
            numero1 = Integer.parseInt(num1Str);

            System.out.print("Ingrese el segundo número: ");
            String num2Str = leer.next();
            numero2 = Integer.parseInt(num2Str);

        } catch (InputMismatchException e) {
            System.out.println("Error de entrada: Debe ingresar números enteros.");
        } catch (NumberFormatException e) {
            System.out.println("Error de conversión: No se puede convertir la cadena en un número entero.");
        } finally {
            leer.close();
        }
    }
    
    public void realizarDivision() {
        try {
            int resultado = dividir(numero1, numero2);
            System.out.println("Resultado de la división: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error aritmético: No se puede dividir por cero.");
        }
    }
    
    public int dividir(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("No se puede dividir por cero.");
        }
        return num1 / num2;
    }

    
}
