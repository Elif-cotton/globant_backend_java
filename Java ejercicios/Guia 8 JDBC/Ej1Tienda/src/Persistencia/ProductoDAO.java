
package Persistencia;

//Las consultas a realizar sobre la BD son las siguientes:

import Entidades.Producto;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.SQLIntegrityConstraintViolationException;

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
public final class ProductoDAO extends DAO {
    
      
    //7) Ingresar un producto a la base de datos.
    public void agregarProducto(Producto producto) throws Exception {
        try {
            String sql = "INSERT INTO producto (nombre, precio, codigo_fabricante) VALUES ("
                    + "'" + producto.getNombre() + "',"
                    + producto.getPrecio() + ","
                    + producto.getCodigoFabricante() + ")";

            insertarModificarEliminar(sql);
        } catch (MySQLIntegrityConstraintViolationException e) {
            // Capturar una excepción específica para la violación de restricción de integridad
            System.out.println("Error: El código de fabricante no existe en la base de datos. Por favor, introduce un código de fabricante válido.");
        } catch (Exception e) {
            throw e;
        }
    }
    
    //8) Editar un producto con datos a elección.
    public void modificarProducto(Producto producto) throws Exception {
        try {
            String sql = "UPDATE producto SET nombre='" + producto.getNombre()
                    + "', precio=" + producto.getPrecio()
                    + ", codigo_fabricante=" + producto.getCodigoFabricante()
                    + " WHERE codigo=" + producto.getCodigo();
            insertarModificarEliminar(sql);
            
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Error: El fabricante con el código " + producto.getCodigoFabricante() + " no existe.");
        } catch (Exception e) {
            // Capturar cualquier otra excepción que pueda ocurrir durante la ejecución
            e.printStackTrace();
        }
    }
    //9) Eliminar un producto por código.
    public void eliminarProducto(int codigoProducto) throws Exception {
        try {
            String sql = "DELETE FROM producto WHERE codigo= '" + codigoProducto + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
}
