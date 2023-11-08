
package com.egg.Biblioteca.servicios;

import com.egg.Biblioteca.entidades.Autor;
import com.egg.Biblioteca.entidades.Editorial;
import com.egg.Biblioteca.entidades.Libro;
import com.egg.Biblioteca.excepciones.MiException;
import com.egg.Biblioteca.repositorios.AutorRepositorio;
import com.egg.Biblioteca.repositorios.EditorialRepositorio;
import com.egg.Biblioteca.repositorios.LibroRepositorio;
import java.util.ArrayList;
import java.util.Date;
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
public class LibroServicio {
    
    @Autowired
    private LibroRepositorio libroRepositorio;
    
    @Autowired
    private AutorRepositorio autorRepositorio;
    
    @Autowired
    private EditorialRepositorio editorialRepositorio;
    
    @Transactional        //método genera cambios en la BD permanente
    public void crearLibro(Long isbn, String titulo, Integer ejemplares, String idAutor,
                                                String idEditorial) throws MiException{
        
        //Validación con método validar
        validar(isbn, titulo, ejemplares, idAutor, idEditorial);
        
        Autor autor= autorRepositorio.findById(idAutor).get(); //.get() para que se guarde
        Editorial editorial=editorialRepositorio.findById(idEditorial).get();
        
        Libro libro=new Libro();
        
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setEjemplares(ejemplares);
        
        libro.setAlta(new Date());
        
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        
        libroRepositorio.save(libro);
    }
    
    //retornar lista de libros
    public List<Libro> listarLibros(){
        
        List<Libro> libros=new ArrayList();
        
        libros= libroRepositorio.findAll();
                
        return libros;        
    }
    
    //modificar libro
    public void modificarLibro(Long isbn, String titulo, Integer ejemplares, String idAutor, 
            String idEditorial) throws MiException{
        
        //Validación con método validar
        validar(isbn, titulo, ejemplares, idAutor, idEditorial);
        
        Optional<Libro> respuesta= libroRepositorio.findById(isbn);  //si el valor está presente devuleve true
        Optional<Autor> respuestaAutor= autorRepositorio.findById(idAutor);
        Optional<Editorial> respuestaEditorial= editorialRepositorio.findById(idEditorial);
        
        Autor autor=new Autor();
        Editorial editorial=new Editorial();
        
        if(respuestaAutor.isPresent()){
            autor=respuestaAutor.get();
        }
        
        if(respuestaEditorial.isPresent()){
            editorial=respuestaEditorial.get();
        }
         
        if(respuesta.isPresent()){
            Libro libro=respuesta.get();
            
            libro.setTitulo(titulo);
            libro.setEjemplares(ejemplares);
            
            libro.setAutor(autor);
            libro.setEditorial(editorial);   
            
            libroRepositorio.save(libro);
        }
           
    }
    
    
    private void validar(Long isbn, String titulo, Integer ejemplares, String idAutor,
            String idEditorial) throws MiException{
        
        if(isbn==null){
            throw new MiException("El isbn no puede ser nulo");
        }
        if(titulo.isEmpty() || titulo == null){
            throw new MiException("El titulo no puede estar vacío o ser nulo");
        }
        if(ejemplares==null){
            throw new MiException("El ejemplares no pueden ser nulo");
        }
        if(idAutor.isEmpty() || idAutor == null){
            throw new MiException("El idAutor no puede estar vacío o ser nulo");
        }
        if(idEditorial.isEmpty() || idEditorial == null){
            throw new MiException("El idEditorial no puede estar vacío o ser nulo");
        }
        
    }
}