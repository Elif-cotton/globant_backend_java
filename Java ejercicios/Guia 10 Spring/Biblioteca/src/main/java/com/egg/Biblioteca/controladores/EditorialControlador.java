
package com.egg.Biblioteca.controladores;

import com.egg.Biblioteca.entidades.Editorial;
import com.egg.Biblioteca.excepciones.MiException;
import com.egg.Biblioteca.servicios.EditorialServicio;
import java.util.List;
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
@RequestMapping("/editorial")
public class EditorialControlador {
    
    @Autowired 
    private EditorialServicio editorialServicio;
    
    @GetMapping("/registrar")   //localhost:8080/editorial/registrar
    public String registrar(){
        
        return "editorial_form.html";
    }
    
    @PostMapping("/registro")
    public String registro(@RequestParam String nombre){  //recibe
        
        try {
        
            editorialServicio.crearEditorial(nombre);
            
        } catch (MiException ex) {
            Logger.getLogger(EditorialControlador.class.getName()).log(Level.SEVERE, null, ex);
            return "editorial_form.html";
        }
        
        return "index.html";
    }
    
    
     @GetMapping("/lista")
    public String listar(ModelMap modelo){
        
        List<Editorial> editoriales= editorialServicio.listarEditoriales();
        
        modelo.addAttribute("editoriales", editoriales);
        
        return "editorial_list.html";
    }
    
}
