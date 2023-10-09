
package Servicio;

import Entidades.Producto;
import Persistencia.ProductoDAO;
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
    
    //7) Ingresar un producto a la base de datos.
    public void agregarProducto(Producto nuevoProducto) throws Exception {
        dao.agregarProducto(nuevoProducto);
    }
    
    //8) Editar un producto con datos a elección.
    public void modificarProducto(Producto producto) throws Exception {
       dao.modificarProducto(producto);
    }
    //9) Eliminar un producto por código.
    public void eliminarProducto(int codigoProducto) throws Exception {
        dao.eliminarProducto(codigoProducto);
    }
}
