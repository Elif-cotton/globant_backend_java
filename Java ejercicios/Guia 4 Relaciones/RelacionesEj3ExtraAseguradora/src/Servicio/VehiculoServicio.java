
package Servicio;

import Entidad.Cliente;
import Entidad.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author javer
 */
public class VehiculoServicio {
    private static Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");
    private List<Vehiculo> vehiculos= new ArrayList<>();
    private List<Cliente> clientes= new ArrayList<>();

    public void crearVehiculoParaCliente(Cliente clientes) {
        
        System.out.println("Ingrese la marca del vehículo:");
        String marca = leer.next();
        System.out.println("Ingrese el modelo del vehículo:");
        String modelo = leer.next();
        System.out.println("Ingrese el año del vehículo:");
        int anio = leer.nextInt();
        leer.nextLine();
        System.out.println("Ingrese el número de motor del vehículo:");
        String numeroMotor = leer.next();
        System.out.println("Ingrese el chasis del vehículo:");
        String chasis = leer.next();
        System.out.println("Ingrese el color del vehículo:");
        String color = leer.next();
        System.out.println("Ingrese el tipo del vehículo:");
        String tipo = leer.next();
        
        Vehiculo vehiculo = new Vehiculo((List<Cliente>) clientes, marca, modelo, anio, numeroMotor, chasis, color, tipo);
        // Asignar el vehículo al cliente correspondiente
        vehiculos.add(vehiculo);

        System.out.println("Vehículo creado y asignado al cliente con éxito.");
    }
        
    public VehiculoServicio() {
        
        List<Cliente> clientes = new ArrayList();
        vehiculos.add(new Vehiculo( clientes, "Toyota", "Corolla", 2022, "ABC123",
                                                           "123456", "Blanco", "Sedán"));
        vehiculos.add(new Vehiculo( clientes, "Ford", "Escape", 2023, "DEF456",
                                                          "789012", "Gris", "SUV"));
        vehiculos.add(new Vehiculo( clientes, "Honda", "Civic", 2021, "GHI789",
                                                          "345678", "Negro", "Sedán"));
    }
    
      public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    
    public void MostrarVehiculos() {
        for (Vehiculo aux : vehiculos) {
            System.out.println(aux);
        }
    }
     
   }
