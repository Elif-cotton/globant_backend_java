
package Persistencia;
//10) Ingresar un fabricante a la base de datos

import Entidades.Fabricante;
import java.sql.SQLException;

/**
 *
 * @author javer
 */
public final class FabricanteDAO extends DAO{
    
    public void agregarFabricante(Fabricante fabricante) throws Exception{
        
        try{
            if(fabricante==null){
               throw new Exception ("Debe indicar un fabricante");
            }
            String sql= "INSERT INTO fabricante (codigo, nombre)" 
                    + "VALUES ( '" + fabricante.getCodigo() 
                    + "' , '" + fabricante.getNombre() + "' );";      
            
            insertarModificarEliminar(sql);
            desconectarBase();
        }catch (Exception e){
            throw e;
            
        }finally {
            desconectarBase();
        }
    }
   
    
    public boolean fabricanteExiste(int codigoFab) throws SQLException, Exception {
        // Realiza una consulta a la base de datos para verificar si el fabricante existe
         String sql = "SELECT COUNT(*) FROM fabricante WHERE codigo = " + codigoFab;
            conectarBase();
    
        try {
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
            if (resultado.next()) {
                int count = resultado.getInt(1);
                return count > 0;
             }
        } finally {
             desconectarBase();
         }
    
         return false;
    }
}
