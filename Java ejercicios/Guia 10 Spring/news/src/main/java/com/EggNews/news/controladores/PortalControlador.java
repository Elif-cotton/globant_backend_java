
package com.EggNews.news.controladores;

import com.EggNews.news.entidades.Noticia;
import com.EggNews.news.servicios.NoticiaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author javer
 */

@Controller
@RequestMapping("/")
public class PortalControlador {
    
     @Autowired
    private NoticiaServicio noticiaServicio;

    @GetMapping("/")
    public String index(Model model) {
        // Obtener la lista de noticias desde el servicio
        List<Noticia> noticias = noticiaServicio.listarNoticias();

        // Agregar la lista de noticias al modelo para que esté disponible en la vista
        model.addAttribute("noticias", noticias);

        // Devolver la vista index.html
        return "index.html";
    }
    
}
