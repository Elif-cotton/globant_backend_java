
package herenciaej1extraarrendar;

import Entidades.Alquiler;
import Entidades.BarcoMotor;
import Entidades.Velero;
import Entidades.YateLujo;
import java.time.LocalDate;

/**
 *
 * @author javer
 */
public class HerenciaEj1ExtraArrendar {

    
    public static void main(String[] args) {
        // Crear un Velero
        Velero velero = new Velero(2,"ABC123", 12.5, 2015);
        // Crear un Alquiler para el Velero
        Alquiler alquilerVelero = new Alquiler("Juan Perez", "12345678", LocalDate.of(2023, 8, 1),
                                               LocalDate.of(2023, 8, 10), 1, velero);
         // Calcular y mostrar precio final del alquiler del Velero
        System.out.println("Alquiler del Velero:");
        double precioAlquilerVelero = alquilerVelero.calcularPrecio(velero);
        System.out.println("Precio final del alquiler: $" + precioAlquilerVelero);
        System.out.println(velero.getInfo());
        
        System.out.println("-----------------------------");
        
        // Crear un YateDeLujo
        YateLujo yate = new YateLujo(150, 5, "ABC123", 20.5, 2018);
        
        // Crear un Alquiler para el YateDeLujo
        LocalDate fechaAlquilerYate = LocalDate.of(2023, 8, 1);
        LocalDate fechaDevolucionYate = LocalDate.of(2023, 8, 10);
        Alquiler alquilerYate = new Alquiler("Cliente1", "123456789", fechaAlquilerYate, fechaDevolucionYate, 1, yate);
        
        // Calcular y mostrar precio final del alquiler del YateDeLujo
        System.out.println("Alquiler de Yate de Lujo:");
        double precioYate = alquilerYate.calcularPrecio(yate);
        System.out.println("Precio final del alquiler: $" + precioYate);
        System.out.println(yate.getInfo());
        
        System.out.println("-----------------------------");
        
        // Crear un BarcoAMotor
        BarcoMotor barcoMotor = new BarcoMotor(250,"XYZ789", 15.0, 2020);
        
        // Crear un Alquiler para el BarcoAMotor
        LocalDate fechaAlquilerMotor = LocalDate.of(2023, 8, 1);
        LocalDate fechaDevolucionMotor = LocalDate.of(2023, 8, 5);
        Alquiler alquilerMotor = new Alquiler("Cliente2", "987654321", fechaAlquilerMotor, fechaDevolucionMotor, 2, barcoMotor);
        
        // Calcular y mostrar precio final del alquiler del BarcoAMotor
        System.out.println("Alquiler de Barco a Motor:");
        double precioMotor = alquilerMotor.calcularPrecio(barcoMotor);
        System.out.println("Precio final del alquiler: $" + precioMotor);
        System.out.println(barcoMotor.getInfo());
    
    }
    
}
