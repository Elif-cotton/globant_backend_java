
package com.egg.Biblioteca.controladores;

import com.egg.Biblioteca.entidades.Autor;
import com.egg.Biblioteca.excepciones.MiException;
import com.egg.Biblioteca.servicios.AutorServicio;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String registro(@RequestParam String nombre, ModelMap modelo){  //recibe
        
        try {
             //System.out.println("Nombre: "+nombre); //para saber si esta recibiendo los nombres 
        
            autorServicio.crearAutor(nombre);
            modelo.put("exito" ,"El libro fue cargado correctamente!" );
             
        } catch (MiException ex) {
            List<Autor> autores= autorServicio.listarAutores();
            
            modelo.addAttribute("autores", autores);
                   
            modelo.put("error", ex.getMessage());
            return "autor_form.html";
        }
        
        return "index.html";
    }
    
    
    @GetMapping("/lista")
    public String listar(ModelMap modelo){
        
        List<Autor> autores= autorServicio.listarAutores();
        
        modelo.addAttribute("autores", autores);
        
        return "autor_list.html";
    }
    
    
    
    @GetMapping("/modificar/{id}")   //id viaja en esa url
    public String modificar(@PathVariable String id, ModelMap modelo){ //envian el id para modificar
        
        modelo.put("autor", autorServicio.getOne(id));
        
        return "autor_modificar.html";
    }
  
    @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable String id, String nombre, ModelMap modelo) throws MiException{
        try{
        autorServicio.modificarAutor(id, nombre);
        
        return "redirect:../lista";
        
        }catch(MiException ex){
           modelo.put("error", ex.getMessage());
           return "autor_modificar.html";
        }
    }
}
