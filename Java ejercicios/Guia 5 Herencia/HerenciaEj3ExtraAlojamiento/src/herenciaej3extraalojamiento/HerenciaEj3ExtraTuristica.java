
package herenciaej3extraalojamiento;

import Entidades.Alojamiento;
import Entidades.Camping;
import Entidades.Hotel;
import Entidades.HotelCinco;
import Entidades.HotelCuatro;
import Entidades.Residencia;
import Enumeracion.TipoGimnasio;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author javer
 */
public class HerenciaEj3ExtraTuristica {
    private static Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");
    public static void main(String[] args) {
        
        List<Alojamiento> alojamientos = new ArrayList<>();

        // Agrega algunos alojamientos a la lista (puedes agregar más según tus necesidades)
        alojamientos.add(new HotelCuatro(TipoGimnasio.A, "Restaurante1", 40, 100, 200, 5, 120.0, 
                "Hotel 1", "Dirección 1", "Localidad 1", "Gerente 1"));
        alojamientos.add(new HotelCinco(5, 10, 3, TipoGimnasio.B, "Restaurante2", 50, 150, 250, 7,
                180.0, "Hotel 2", "Dirección 2", "Localidad 2", "Gerente 2"));
        alojamientos.add(new Camping(50, 20, true, true, 200.0, "Camping 1", "Dirección 3", "Localidad 3",
                "Gerente 3"));
        alojamientos.add(new Residencia(30, true, true, false, 150.0, "Residencia 1", "Dirección 4", 
                "Localidad 4", "Gerente 4"));

        //Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú de Consulta de Alojamientos");
            System.out.println("1. Mostrar todos los alojamientos");
            System.out.println("2. Mostrar hoteles del más caro al más barato");
            System.out.println("3. Mostrar campings con restaurante");
            System.out.println("4. Mostrar residencias con descuento");
            System.out.println("5. Mostrar precio final por habitación del Hotel de Cuatro Estrellas");
            System.out.println("6. Mostrar precio final por habitación del Hotel de Cinco Estrellas");
            System.out.println("7. Salir");

            System.out.print("Elija una opción: ");
            int opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    // Mostrar todos los alojamientos
                    for (Alojamiento alojamiento : alojamientos) {
                        System.out.println(alojamiento);
                    }
                    break;
                case 2:
                    // Mostrar hoteles de más caro a más barato
                    List<Hotel> hoteles = new ArrayList<>();
                    for (Alojamiento alojamiento : alojamientos) {
                        if (alojamiento instanceof Hotel) {
                            hoteles.add((Hotel) alojamiento);
                        }
                    }
                    Collections.sort(hoteles, Comparator.comparingDouble(Hotel::getPrecioHabitacion).reversed());
                    for (Hotel hotel : hoteles) {
                        System.out.println(hotel);
                    }
                    break;
                case 3:
                    // Mostrar campings con restaurante
                    for (Alojamiento alojamiento : alojamientos) {
                        if (alojamiento instanceof Camping && ((Camping) alojamiento).isTieneRestaurante()) {
                            System.out.println(alojamiento);
                        }
                    }
                    break;
                case 4:
                    // Mostrar residencias con descuento
                    for (Alojamiento alojamiento : alojamientos) {
                        if (alojamiento instanceof Residencia && ((Residencia) alojamiento).isDescuentoGremios()) {
                            System.out.println(alojamiento);
                        }
                    }
                    break;
                case 5:
                    // Mostrar precio final por habitación del Hotel de Cuatro Estrellas
                    for (Alojamiento alojamiento : alojamientos) {
                        if (alojamiento instanceof HotelCuatro) {
                            HotelCuatro hotelCuatro = (HotelCuatro) alojamiento;
                            double precioFinal = hotelCuatro.calcularPrecioHabitacion();
                            System.out.println("Hotel Cuatro Estrellas:");
                            System.out.println(hotelCuatro);
                            System.out.println("Precio Final por Habitación: $" + precioFinal);
                        }
                    }
                    break;
                 case 6:
                    // Mostrar precio final por habitación del Hotel de Cinco Estrellas
                    for (Alojamiento alojamiento : alojamientos) {
                        if (alojamiento instanceof HotelCinco) {
                            HotelCinco hotelCinco = (HotelCinco) alojamiento;
                            double precioFinal = hotelCinco.calcularPrecioHabitacion();
                            System.out.println("Hotel Cinco Estrellas:");
                            System.out.println(hotelCinco);
                            System.out.println("Precio Final por Habitación: $" + precioFinal);
                        }
                    }
                    break;
               case 7:
                    // Salir del programa
                    leer.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
        }
    

        
    }
    
}
