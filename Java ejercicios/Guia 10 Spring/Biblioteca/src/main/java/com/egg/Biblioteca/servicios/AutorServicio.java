
package com.egg.Biblioteca.servicios;

import com.egg.Biblioteca.entidades.Autor;
import com.egg.Biblioteca.excepciones.MiException;
import com.egg.Biblioteca.repositorios.AutorRepositorio;
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
public class AutorServicio {
    
    @Autowired
    private AutorRepositorio autorRepositorio;
    
    @Transactional
    public void crearAutor(String nombre) throws MiException{       //id se genera de forma automática
        
        //validación 
        validar(nombre);
        
        Autor autor=new Autor();
       
        autor.setNombre(nombre);
        
        autorRepositorio.save(autor);
    }
    
    public List<Autor> listarAutores(){
        
        List<Autor> autores=new ArrayList();
        
        autores= autorRepositorio.findAll();
                
        return autores;        
    }
    
    public void modificarAutor(String id, String nombre) throws MiException{
        
        //Validaciones
        if(id==null){
            throw new MiException("El id no puede ser nulo");
        }
        validar(nombre);
        
        Optional<Autor> respuesta= autorRepositorio.findById(id);
        
        if(respuesta.isPresent()){
            
            Autor autor= respuesta.get();
            
            autor.setNombre(nombre);
            
            autorRepositorio.save(autor);
        }
    }
    
    private void validar(String nombre) throws MiException{
        
        if(nombre.isEmpty() || nombre == null){
            throw new MiException("El nombre no puede estar vacío o ser nulo");
        }   
        
    }
}
