
package Servicio;

import Entidades.Producto;
import Persistencia.FabricanteDAO;
import Persistencia.ProductoDAO;
import java.sql.SQLException;
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
/**
 *
 * @author javer
 */
public class ProductoServicio {
    
    private ProductoDAO dao;

    public ProductoServicio() {
        this.dao = new ProductoDAO();
    }
   
    //1) Lista el nombre de todos los productos que hay en la tabla producto.
     public void selectAll() throws Exception {
          dao.selectAll();
    }
     
    //2) Listar por parámetro todos los productos
    public void selectPorParametro(String parametro) throws Exception {
        dao.selectUnParametro(parametro);
    }
    
    //3) Lista los nombres y los precios de todos los productos de la tabla producto.
     public void selectPorParametro(String nombre, String precio) throws Exception {
        dao.selectDosParametro(nombre, precio);
    }
    //4) Listar aquellos productos que su precio esté entre 120 y 202.
     public void listarPorPrecio(double precioMin, double precioMax) throws Exception {
        dao.listarPorPrecio(precioMin, precioMax);
    }
    //5) Buscar y listar todos los Portátiles de la tabla producto.
      public void listarPortatiles() throws Exception {
        dao.listarPortatiles();
    }
    //6) Listar el nombre y el precio del producto más barato.
     public void obtenerProductoMasBarato() throws Exception {
        dao.obtenerProductoMasBarato();
    }

    //7) Ingresar un producto a la base de datos.
    public void agregarProducto(String nombre, double precio, int codigoFabricante) throws Exception {
        
        try {
            //Validamos
           
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre del producto");
            }
            if (precio <= 0.0) {
                 throw new Exception("El precio del producto debe ser mayor que cero");
            }
            FabricanteDAO daoF= new FabricanteDAO();
            // Verificar si el código de fabricante existe
            if (!daoF.fabricanteExiste(codigoFabricante)) {
             // El código de fabricante no existe, agreguémoslo
                throw new Exception("El código del fabricante " + codigoFabricante + " no existe en la base de datos debe agregarlo primero antes de continuar");  
            }
       
            //Creamos el fabricante
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigo_fabricante(codigoFabricante);
            
            dao.agregarProducto(producto);
            
        } catch (Exception e) {
            throw e;
        }
      
    }
    
    //8) Editar un producto con datos a elección.
    public void modificarProducto(int codigo, String nombre2, double precio2, int codigoFab) throws Exception {
        try {
            // Validar los valores de entrada
            if (nombre2 == null || nombre2.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre del producto");
            }

            
            try {
               
                if (precio2 <= 0.0) {
                    throw new Exception("El precio del producto debe ser mayor que cero");
                }
            } catch (NumberFormatException ex) {
                throw new Exception("El precio no es un número válido");
            }

            // Crear un objeto Producto con los valores válidos
            Producto producto = new Producto();
            producto.setCodigo(codigo);
            producto.setNombre(nombre2);
            producto.setPrecio(precio2);
            producto.setCodigo_fabricante(codigoFab);

             // Llamar al método 'modificarProducto' del objeto 'dao' para modificar el producto en la base de datos
             dao.modificarProducto(producto);
        } catch (Exception e) {
            // Capturar y re-lanzar cualquier excepción que ocurra
            throw e;
        }
    }
    
    //9) Eliminar un producto por código. 
    public void eliminarProducto(int codigoProducto) throws Exception {
        try {
             // Aquí puedes agregar validaciones antes de llamar al método de DAO
            if (codigoProducto <= 0) {
                throw new Exception("El código del producto debe ser un número mayor que cero.");
        }
            
         // Validar si el producto existe antes de intentar eliminarlo
        if (!dao.productoExiste(codigoProducto)) {
            throw new Exception("El producto con el código " + codigoProducto + " no existe en la base de datos.");
        }   
        
        dao.eliminarProducto(codigoProducto);
        } catch (SQLException e) {
        // Capturar y manejar cualquier excepción de SQL
            throw e;
        } catch (Exception e) {
        // Capturar y manejar excepciones generadas por las validaciones
            throw e;
         }
    }
    
    
}
