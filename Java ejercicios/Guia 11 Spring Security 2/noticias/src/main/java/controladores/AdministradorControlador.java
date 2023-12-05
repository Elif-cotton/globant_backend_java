
package controladores;

import entidades.Noticia;
import excepciones.MiException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import servicios.AdministradorServicio;
import servicios.NoticiaServicio;

/**
 *
 * @author javer
 */

@Controller
@RequestMapping("/admin")
public class AdministradorControlador {
    
    @Autowired
    private AdministradorServicio administradorServicio;
    
    @Autowired
    private NoticiaServicio noticiaServicio;

    @PostMapping("/crear-noticia")
    public void crearNoticia(@RequestParam String titulo, @RequestParam String cuerpo) {
        administradorServicio.crearNoticia(titulo, cuerpo);
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


//    @DeleteMapping("/eliminar-noticia/{noticiaId}")
//    public void eliminarNoticia(@PathVariable String noticiaId) {
//        
//        administradorServicio.eliminarNoticia(noticiaId);
//    }
//
//    @PutMapping("/baja-periodista/{periodistaId}")
//    public void darDeAltaBajaPeriodista(@PathVariable String periodistaId) {
//        
//        administradorServicio.darDeBajaPeriodista(periodistaId);
//    }
//    
//    @PutMapping("/alta-periodista/{periodistaId}")
//    public void darDeAltaPeriodista(@PathVariable String periodistaId) {
//        
//        administradorServicio.darDeAltaPeriodista(periodistaId);
//    }
//
//    @PutMapping("/asignar-sueldo/{periodistaId}")
//    public void asignarSueldoMensual(@PathVariable String periodistaId, @RequestParam int sueldo) {
//        
//        administradorServicio.asignarSueldoMensual(periodistaId, sueldo);
//    }

    
}
