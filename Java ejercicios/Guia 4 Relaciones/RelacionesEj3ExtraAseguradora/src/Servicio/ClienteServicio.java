
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
public class ClienteServicio {
    private static Scanner leer=new Scanner(System.in,"ISO-8859-1").useDelimiter("\n");
    private List<Cliente> clientes= new ArrayList<>();

    public void crearCliente() {
        
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = leer.next();
        System.out.println("Ingrese el apellido del cliente:");
        String apellido = leer.next();
        System.out.println("Ingrese el documento del cliente:");
        String documento = leer.next();
        System.out.println("Ingrese el e-mail del cliente:");
        String email = leer.next();
        System.out.println("Ingrese el domicilio del cliente:");
        String domicilio = leer.next();
        System.out.println("Ingrese el teléfono del cliente:");
        String telefono = leer.next();
        
        Cliente cliente = new Cliente(nombre, apellido, documento, email, domicilio, telefono);
        clientes.add(cliente);
        
        System.out.println("Cliente creado con éxito.");
    }
    
    public ClienteServicio() {
        
        clientes.add(new Cliente("Juan", "Pérez", "12345678", "juan@example.com",
                                                       "Calle A, Ciudad", "1234567890"));
        clientes.add(new Cliente("María", "González", "23456789", "maria@example.com",
                                                       "Calle B, Ciudad", "9876543210"));
        clientes.add(new Cliente("Carlos", "López", "34567890", "carlos@example.com",
                                                       "Calle C, Ciudad", "4567890123"));
        
    }
    
    public List<Cliente> getClientes() {
        return clientes;
    }
    
    
    public void MostrarCliente() {
        for (Cliente aux : clientes) {
            System.out.println(aux);
        }
    }
    
    public Cliente buscarClientePorDocumento(String documento) {
        for (Cliente cliente : clientes) {
            if (cliente.getDocumento().equals(documento)) {
                return cliente;
            }
        }
        return null; // Cliente no encontrado
    }
    
    public void mostrarVehiculoAsociado() {
        System.out.println("Ingrese el documento del cliente:");
        String documento = leer.next();

        Cliente cliente = buscarClientePorDocumento(documento);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
        } else if (cliente.getVehiculos().isEmpty()) {
            System.out.println("El cliente no tiene vehículos asociados.");
        } else {
            System.out.println("Vehículo(s) asociado(s) al cliente:");
            for (Vehiculo vehiculo : cliente.getVehiculos()) {
                System.out.println(vehiculo);
            }
        }
    }
}
