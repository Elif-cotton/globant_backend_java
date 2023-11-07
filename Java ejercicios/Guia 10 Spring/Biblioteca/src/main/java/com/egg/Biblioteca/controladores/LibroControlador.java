
package com.egg.Biblioteca.controladores;

import com.egg.Biblioteca.excepciones.MiException;
import com.egg.Biblioteca.servicios.AutorServicio;
import com.egg.Biblioteca.servicios.EditorialServicio;
import com.egg.Biblioteca.servicios.LibroServicio;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author javer
 */

@Controller
@RequestMapping("/libro")
public class LibroControlador {
    
    @Autowired 
    private LibroServicio libroServicio;
    
    @Autowired 
    private AutorServicio autorServicio;
    
    @Autowired 
    private EditorialServicio editorialServicio;
    
    @GetMapping("registrar")  //localhost:8080/libro/registrar
    public String registrar(){
        return "libro_form.html";
    }
    
    @PostMapping("/resgitro")
    public String registro(@RequestParam(required=false) Long isbn, @RequestParam String titulo, 
            @RequestParam(required=false) Integer ejemplares, @RequestParam String idAutor,
            @RequestParam String idEditorial){            //(required=false) en caso de que no venga igual lo crea
        
        try{
            
            libroServicio.crearLibro(isbn, titulo, ejemplares, idAutor, idEditorial);
            
        }catch (MiException ex){
            Logger.getLogger(LibroControlador.class.getName()).log(Level.SEVERE, null, ex);
            return "libro_form.html";      //volvemos a cargar el formulario
        }
        return "index.html";    //si se creo correctamente no envía a pág inicial
    }
    
    
}
