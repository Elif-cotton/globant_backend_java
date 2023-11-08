
package com.egg.Biblioteca.controladores;

import com.egg.Biblioteca.excepciones.MiException;
import com.egg.Biblioteca.servicios.AutorServicio;
import com.egg.Biblioteca.servicios.EditorialServicio;
import com.egg.Biblioteca.servicios.LibroServicio;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    
    @PostMapping("/registro")
    public String registro(@RequestParam(required=false) Long isbn, @RequestParam String titulo, 
            @RequestParam(required=false) Integer ejemplares, @RequestParam String idAutor,
            @RequestParam String idEditorial, ModelMap modelo){            //(required=false) en caso de que no venga igual lo crea
                                         //ModelMap mostrar información que aparece por pantalla o interfaz del usuario       
        try{
            
            libroServicio.crearLibro(isbn, titulo, ejemplares, idAutor, idEditorial); //si todo sale bien
            
            modelo.put("exito" ,"El libro fue cargado correctamente!" );
            
        }catch (MiException ex){
            
            modelo.put("error", ex.getMessage());
            
            return "libro_form.html";      //volvemos a cargar el formulario
        }
        return "index.html";    //si se creo correctamente no envía a pág inicial
    }
    
    
}
