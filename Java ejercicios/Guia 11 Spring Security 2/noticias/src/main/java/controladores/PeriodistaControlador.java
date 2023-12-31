
package controladores;

import entidades.Noticia;
import excepciones.MiException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import servicios.NoticiaServicio;
import servicios.PeriodistaServicio;

/**
 *
 * @author javer
 */

@Controller
@RequestMapping("/reporter")
public class PeriodistaControlador {
    
    @Autowired
    private PeriodistaServicio periodistaServicio;
    
    @Autowired
    private NoticiaServicio noticiaServicio;

    @PostMapping("/{reporterId}/crear-noticia")
    public void crearNoticia(@PathVariable String periodistaId, @RequestParam String titulo,
            @RequestParam String cuerpo) {
        
        periodistaServicio.crearNoticia(periodistaId, titulo, cuerpo);
    }

    @GetMapping("/modificar/{noticiaId}")
    public String modificar(@PathVariable String noticiaId, ModelMap modelo) {
      
        modelo.put("noticia", noticiaServicio.getOne(noticiaId));
        
        List<Noticia> noticias = noticiaServicio.listarNoticias();
        
        modelo.addAttribute("noticias", noticias);
     
        return "noticia_modificar.html";
        
    }
    
    @PostMapping("/modificar/{noticiaId}")
    public String modificar(@PathVariable String noticiaId, String titulo, String cuerpo,
            ModelMap modelo) {
        
        try {
            List<Noticia> noticias = noticiaServicio.listarNoticias();
            
            modelo.addAttribute("noticias", noticias);
           
            noticiaServicio.modificar(noticiaId, titulo, cuerpo);
                       
            return "redirect:../lista";

        } catch (MiException ex) {
            List<Noticia> noticias = noticiaServicio.listarNoticias();
            
            modelo.put("error", ex.getMessage());
            
            modelo.addAttribute("noticias", noticias);
            
            return "noticia_modificar.html";
        }

    }
    
    
}
