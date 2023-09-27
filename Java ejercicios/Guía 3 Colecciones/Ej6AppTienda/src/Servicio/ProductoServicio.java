package Servicio;

import Entidades.Producto;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ProductoServicio {
    private static Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
    HashMap<Integer, Producto> tiendaList = new HashMap();
    private int contadorClaves = 1;

    public void agregarProducto() {

        System.out.print("Ingrese el nombre del Producto: ");
        String producto = leer.next();
        System.out.print("Ingrese el precio: ");
        Integer precio = leer.nextInt();

        tiendaList.put(contadorClaves, new Producto(producto, precio));
        contadorClaves++;

    }

    public ProductoServicio() {

        tiendaList.put(contadorClaves, new Producto("papas", 1200));
        contadorClaves++;
        tiendaList.put(contadorClaves, new Producto("tomate", 1800));
        contadorClaves++;
        tiendaList.put(contadorClaves, new Producto("acelga", 700));
        contadorClaves++;
        tiendaList.put(contadorClaves, new Producto("cebolla", 1900));
        contadorClaves++;

    }

    public void modificarPrecioProducto() {

        System.out.print("Ingrese el nombre del Producto al que va a modificar el precio: ");
        String prodIngresado = leer.next();

        for (Map.Entry<Integer, Producto> e : tiendaList.entrySet()) {
            Producto p = e.getValue();   //entry.getValue().getNombre()
            if (p.getNombre().equalsIgnoreCase(prodIngresado)) {
                System.out.print("Ingrese el nuevo precio: ");
                Integer precioNuevo = leer.nextInt();
                p.setPrecio(precioNuevo);
                System.out.println("El precio fué modificado exitosamente");
            }
        }
    }

    public void eliminarProducto(String producto) {

        Iterator<Map.Entry<Integer, Producto>> iterator = tiendaList.entrySet().iterator();
        boolean encontrado = false;

        while (iterator.hasNext()) {
            Map.Entry<Integer, Producto> entry = iterator.next();
            Producto p = entry.getValue();
            if (p.getNombre().equalsIgnoreCase(producto)) {
                iterator.remove(); // Elimina el producto de manera segura
                encontrado = true;
                System.out.println("El producto se ha eliminado correctamente");
                break; // No es necesario seguir buscando, ya encontramos el producto
            }
        }

        if (!encontrado) {
            System.out.println("El producto no se encontró en la tienda");
        }
    }

    public void mostrarProductos() {
        if (tiendaList.isEmpty()) {
            System.out.println("No hay productos en la tienda.");
        } else {
            System.out.println("Los productos en la tienda son: ");
            for (Map.Entry<Integer, Producto> entry : tiendaList.entrySet()) {
                Integer key = entry.getKey();
                Producto value = entry.getValue();
                System.out.println("código " + key + "," + value);
            }
        }
    }

    public void menu() {

        boolean salir = false;
        int opcion;

        while (!salir) {
            System.out.println("");
            System.out.println("**** MENU DE PRODUCTOS ****");
            System.out.println("1. Mostrar productos");
            System.out.println("2. Agregar un nuevo");
            System.out.println("3. Modificar el precio de un producto");
            System.out.println("4. Eliminar un producto");
            System.out.println("5. Salir");
            System.out.println("");
            System.out.print("Elija una opción:");

            opcion = leer.nextInt();
            String nombre;
            double precio;

            switch (opcion) {
                case 1:
                    mostrarProductos();
                    break;
                case 2:
                    agregarProducto();
                    break;
                case 3:
                    System.out.println("Modificar precio del producto: ");
                    modificarPrecioProducto();
                    break;
                case 4:
                    System.out.println("Eliminar producto: ");
                    System.out.println("Nombre del producto que desea eliminar: ");
                    nombre = leer.next();
                    eliminarProducto(nombre);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    salir = true;
                    break;
                default:
                    System.out.println("Elija una opción válida...");
                    break;
            }
        }
    }
}