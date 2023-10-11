
package ej1tienda;

import Entidades.Fabricante;
import Entidades.Producto;
import Servicio.FabricanteServicio;
import Servicio.ProductoServicio;
import java.util.Scanner;
//Las consultas a realizar sobre la BD son las siguientes:
//1) Lista el nombre de todos los productos que hay en la tabla producto.
//2) Listar por parámetro todos los productos
//3) Lista los nombres y los precios de todos los productos de la tabla producto.
//4) Listar aquellos productos que su precio esté entre 120 y 202.
//5) Buscar y listar todos los Portátiles de la tabla producto.
//6) Listar el nombre y el precio del producto más barato.
//7) Ingresar un producto a la base de datos.
//8) Editar un producto con datos a elección.
//9) Eliminar un producto.
//10) Ingresar un fabricante a la base de datos
/**
 *
 * @author javer
 */
public class Ej1Tienda {
    
    public static Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public static void main(String[] args) throws Exception{

        ProductoServicio productoServicio = new ProductoServicio();
        FabricanteServicio fabricanteServicio = new FabricanteServicio();
        
        while (true) {
            System.out.println("");
            System.out.println("1. Listar todos los productos");
            System.out.println("2. Listar por parámetro todos los productos");
            System.out.println("3. Listar nombres y precios de todos los productos");
            System.out.println("4. Listar productos con precios entre 120 y 202");
            System.out.println("5. Listar todos los portátiles");
            System.out.println("6. Listar el producto más barato");
            System.out.println("7. Agregar producto");
            System.out.println("8. Editar un producto");
            System.out.println("9. Eliminar un producto");
            System.out.println("10. Agregar un Fabricante");
            System.out.println("11. Salir");

            System.out.println("Por favor, selecciona una opción: ");
            int option = leer.nextInt();

            switch (option) {
                case 1:
                    productoServicio.selectAll();
                    break;
                case 2:
                    System.out.println("Selecciona el parámetro que desea consultar del producto:");
                    System.out.println("1- codigo");
                    System.out.println("2- nombre");
                    System.out.println("3- precio");
                    System.out.println("4- codigo fabricante");
                    int opcion = leer.nextInt();
                    String parametro;
                    switch (opcion) {
                        case 1:
                            parametro = "codigo";
                            break;
                        case 2:
                            parametro = "nombre";
                            break;
                        case 3:
                            parametro = "precio";
                            break;
                        case 4:
                            parametro = "codigo_fabricante";
                            break;
                        default:
                            parametro = "*";
                    }
                    productoServicio.selectPorParametro(parametro);
                    break;
                case 3:
                    productoServicio.selectPorParametro("nombre", "precio");
                    break;
                case 4:
                    productoServicio.listarPorPrecio(120, 202);
                    break;
                case 5:
                    productoServicio.listarPortatiles();
                    break;
                case 6:
                    productoServicio.obtenerProductoMasBarato();
                    break;
                case 7:
                    System.out.println("Ingrese el código del producto a agregar");
                    int codigo = leer.nextInt();
                    System.out.println("Ingrese el nombre del producto");
                    String nombre = leer.next();
                    System.out.println("Ingrese el precio del producto");
                    double precio = leer.nextDouble();
                    System.out.println("Ingrese el código del fabricante");
                    int fabricante = leer.nextInt();
                    productoServicio.agregarProducto(codigo,nombre,precio,fabricante);
                    break;
                case 8:
                    try {
                        System.out.println("Ingrese el código del producto que desea modificar");
                        int codigo2 = leer.nextInt();
                        System.out.println("Ingrese el nombre del producto");
                        String nombre2 = leer.next();
                        System.out.println("Ingrese el precio del producto");
                        double precio2 = leer.nextDouble();
                        productoServicio.modificarProducto(codigo2, nombre2, precio2);
                       
                    } catch (Exception e) {
                        System.out.println("No se pudo cargar uno de los datos");
                    }
                    break;
                case 9:
                    System.out.println("Ingrese el código del producto que desea eliminar");
                    int codigoEliminar = leer.nextInt();
                    productoServicio.eliminarProducto(codigoEliminar);
                    break;
                case 10:
                    System.out.println("Ingrese el código del fabricante");
                    int codigoFabricante = leer.nextInt();
                    System.out.println("Ingrese el nombre del fabricante");
                    String nombreFabricante = leer.next();
                    fabricanteServicio.agregarFabricante(codigoFabricante, nombreFabricante);
                    break;
                case 11:
                    System.out.println("Adiós!");
                    return;
                default:
                    System.out.println("Opción no reconocida. Por favor, selecciona una opción del menú.");
            }
        }
  
    
    }
    
}
