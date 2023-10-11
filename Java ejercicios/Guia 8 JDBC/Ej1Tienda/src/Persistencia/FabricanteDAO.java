
package Persistencia;
//10) Ingresar un fabricante a la base de datos

import Entidades.Fabricante;

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
}
