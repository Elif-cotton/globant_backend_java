
package controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import servicios.PeriodistaServicio;

/**
 *
 * @author javer
 */

@Controller
@RequestMapping("/periodista")
public class PeriodistaControlador {
    
    @Autowired
    private PeriodistaServicio periodistaServicio;

    @PostMapping("/{periodistaId}/crear-noticia")
    public void crearNoticia(@PathVariable String periodistaId, @RequestParam String titulo,
            @RequestParam String cuerpo) {
        
        periodistaServicio.crearNoticia(periodistaId, titulo, cuerpo);
    }

    @PutMapping("/modificar-noticia/{noticiaId}")
    public void modificarNoticia(@PathVariable String noticiaId, @RequestParam String nuevoTitulo,
            @RequestParam String nuevoCuerpo) {
        
        periodistaServicio.modificarNoticia(noticiaId, nuevoTitulo, nuevoCuerpo);
    }
    
}
