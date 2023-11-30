
package servicios;

import entidades.Noticia;
import entidades.Periodista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorios.NoticiaRepositorio;
import repositorios.PeriodistaRepositorio;

/**
 *
 * @author javer
 */

@Service
public class PeriodistaServicio {
    
    @Autowired
    private NoticiaRepositorio noticiaRepositorio; 
    
    @Autowired
    private PeriodistaRepositorio periodistaRepositorio; 
    
    public void crearNoticia(String periodistaId, String titulo, String cuerpo) {
        
        Periodista periodista = periodistaRepositorio.findById(periodistaId)
                .orElseThrow(() -> new IllegalArgumentException("Periodista no encontrado"));

        if (periodista.getActivo()) {
            Noticia nuevaNoticia = new Noticia();
            nuevaNoticia.setTitulo(titulo);
            nuevaNoticia.setCuerpo(cuerpo);
            nuevaNoticia.setAlta(true);
            
            periodista.getMisNoticias().add(nuevaNoticia);
        
            noticiaRepositorio.save(nuevaNoticia);
        } else {
            throw new IllegalStateException("El periodista no está activo. No puede crear noticias.");
        }
    }
    
    
    public void modificarNoticia(String noticiaId, String nuevoTitulo, String nuevoCuerpo) {
        
        Noticia noticia = noticiaRepositorio.findById(noticiaId)
                .orElseThrow(() -> new IllegalArgumentException("Noticia no encontrada"));

        noticia.setTitulo(nuevoTitulo);
        noticia.setCuerpo(nuevoCuerpo);
        noticiaRepositorio.save(noticia);
    }
    
}
