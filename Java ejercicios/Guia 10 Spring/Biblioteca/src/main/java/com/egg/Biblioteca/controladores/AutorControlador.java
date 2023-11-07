
package com.egg.Biblioteca.controladores;

import com.egg.Biblioteca.excepciones.MiException;
import com.egg.Biblioteca.servicios.AutorServicio;
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
@RequestMapping("/autor")    //localhost:8080/autor
public class AutorControlador {
    
    @Autowired 
    private AutorServicio autorServicio;
    
    @GetMapping("/registrar")   //localhost:8080/autor/registrar
    public String registrar(){
        
        return "autor_form.html";
    }
    
    @PostMapping("/registro")
    public String registro(@RequestParam String nombre){  //recibe
        
        try {
             //System.out.println("Nombre: "+nombre); //para saber si esta recibiendo los nombres 
        
            autorServicio.crearAutor(nombre);
        } catch (MiException ex) {
            Logger.getLogger(AutorControlador.class.getName()).log(Level.SEVERE, null, ex);
            return "autor_form.html";
        }
        
        return "index.html";
    }
  
}
