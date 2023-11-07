
package com.egg.Biblioteca.servicios;

import com.egg.Biblioteca.entidades.Editorial;
import com.egg.Biblioteca.excepciones.MiException;
import com.egg.Biblioteca.repositorios.EditorialRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author javer
 */

@Service
public class EditorialServicio {
    
    @Autowired
    private EditorialRepositorio editorialRepositorio;
    
    @Transactional
    public void crearEditorial(String nombre) throws MiException{
        
        //validación 
        validar(nombre);
        
        Editorial editorial=new Editorial();
       
        editorial.setNombre(nombre);
        
        editorialRepositorio.save(editorial);
    }
    
    public List<Editorial> listarEditoriales(){
        
        List<Editorial> editoriales=new ArrayList();
        
        editoriales= editorialRepositorio.findAll();
                
        return editoriales;        
    }
    
    public void modificarEditorial(String id, String nombre) throws MiException{
        
          //Validaciones
        if(id==null){
            throw new MiException("El id no puede ser nulo");
        }
        validar(nombre);
         
        Optional<Editorial> respuesta= editorialRepositorio.findById(id);
        
        if(respuesta.isPresent()){
            
            Editorial editorial= respuesta.get();
            
            editorial.setNombre(nombre);
            
            editorialRepositorio.save(editorial);
        }
    }
    
    private void validar(String nombre) throws MiException{
        
        if(nombre.isEmpty() || nombre == null){
            throw new MiException("El nombre no puede estar vacío o ser nulo");
        }   
        
    }
}
