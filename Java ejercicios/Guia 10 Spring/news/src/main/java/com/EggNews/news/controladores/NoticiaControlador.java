
package com.EggNews.news.controladores;

import com.EggNews.news.entidades.Noticia;
import com.EggNews.news.excepciones.MiException;
import com.EggNews.news.servicios.NoticiaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *gestión de noticias (guardar/modificar noticia, listar
noticias, dar de baja, etc).
 * @author javer
 */

@Controller
@RequestMapping("/noticia")
public class NoticiaControlador {
    
    @Autowired 
    private NoticiaServicio noticiaServicio;
    
    @GetMapping("/registrar")   //localhost:8080/noticia/ingresar
    public String registrar(){
        
        return "noticia_form.html";
    }
    
    @PostMapping("/registro")
    public String registro(@RequestParam String titulo, String cuerpo, ModelMap modelo){  //recibe
        //ModelMap envía la variable al HTML
        
        try {
            noticiaServicio.crearNoticia(titulo, cuerpo);
            modelo.put("exito" ,"La noticia fue cargada correctamente!" );
             
        } catch (MiException ex) {
            List<Noticia> noticias= noticiaServicio.listarNoticias();
            
            modelo.addAttribute("noticias", noticias);
                   
            modelo.put("error", ex.getMessage());
            return "noticia_form.html";
        }
        
        return "index.html";
    }
    
    @GetMapping("/lista")
    public String listar(ModelMap modelo){
        
        List<Noticia> noticias= noticiaServicio.listarNoticias();
        
        modelo.addAttribute("noticias", noticias);
        
        return "noticia_list.html";
    }
    
    @GetMapping("/modificar/{id}")   //id viaja en esa url
    public String modificar(@PathVariable(required = false) String id, ModelMap modelo){ //envian el id para modificar
        
        modelo.put("noticia", noticiaServicio.getOne(id));
        
        return "noticia_modificar.html";
    }
    
    @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable(required = false) String id, String titulo, String cuerpo, ModelMap modelo) throws MiException{
        try{
        noticiaServicio.modificarNoticia(id, titulo, cuerpo);
        
        modelo.put("éxito", "Se modificó correctamente la noticia");
        
        }catch(MiException ex){
           modelo.put("error", ex.getMessage());
           return "noticia_modificar.html";
        }
        return "index.html";
    }
    
    
    @GetMapping("/darBaja/{id}")
    public String darBajaNoticia(@PathVariable String id, ModelMap modelo) {
        try {
            noticiaServicio.darDeBajaNoticia(id);
            modelo.put("éxito", "Se eliminó correctamente la noticia");
        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());
            return "noticia_modificar.html"; // o el nombre de tu página de error
        }
        return "redirect:/index"; // o la ruta a la página principal después de la eliminación
    }
    
//    @PostMapping("/{id}/darDeBaja")
//    public String darDeBajaNoticia(@PathVariable Long id, RedirectAttributes redirectAttributes) {
//        noticiaServicio.darDeBajaNoticia(id);
//        redirectAttributes.addFlashAttribute("mensaje", "Noticia con ID " + id + " ha sido dada de baja correctamente.");
//        return "redirect:/noticias/mensaje";
//    }
//
//    @GetMapping("/mensaje")
//    public String mostrarMensaje(Model model) {
//        return "mensaje";
//    }
}
