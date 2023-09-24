
package Servicio;
//Crea una clase DiscountCalculator que calcule el descuento aplicado a un producto.
//Escribe pruebas unitarias para verificar que el cálculo del descuento se realiza correctamente

import java.util.Scanner;

//para diferentes escenarios (por ejemplo, descuento del 10%, descuento máximo, sin descuento, etc.).

public class ServicioDescuento {
    private static final Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");
    
    public double realizarDescuento(double precio, double tasaDescuento){
        
        double descuento=precio*tasaDescuento/100;
        
        return precio-descuento;
         
    }
    
}
