package servicios;

import entidades.Noticia;
import excepciones.MiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorios.NoticiaRepositorio;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class NoticiaServicio {

    @Autowired
    private NoticiaRepositorio noticiaRepositorio;

    @Transactional
    public void crearNoticia(String titulo, String cuerpo) throws MiException {

        validarDatos(titulo, cuerpo);

        Noticia noticia = new Noticia();
        noticia.setTitulo(titulo);
        noticia.setCuerpo(cuerpo);
        noticia.setAlta(true);

        noticiaRepositorio.save(noticia);
    }

    @Transactional 
    public void modificar(String id, String titulo, String cuerpo) throws MiException {

        validarDatos(titulo, cuerpo);

        Optional<Noticia> respuesta = noticiaRepositorio.findById(id);

        if (respuesta.isPresent()) {
            Noticia noticia = respuesta.get();
            noticia.setTitulo(titulo);
            noticia.setCuerpo(cuerpo);

            noticiaRepositorio.save(noticia);
        }
    }

    public void validarDatos(String titulo, String cuerpo) throws MiException {
        if (titulo == null || titulo.isEmpty()) {
            throw new MiException("El titulo no puede estar vacío o ser nulo");
        }
        if (cuerpo == null || cuerpo.isEmpty()) {
            throw new MiException("El cuerpo no puede estar vacío o ser nulo");
        }
    }

    public Noticia getOne(String id) {
        return noticiaRepositorio.getOne(id);
    }

    public void darDeBaja(String id) {

        Optional<Noticia> respuesta = noticiaRepositorio.findById(id);

        if (respuesta.isPresent()) {
            Noticia noticia = respuesta.get();
            noticia.setAlta(false);

            noticiaRepositorio.save(noticia);
        }
    }

    public void darDeAlta(String id) {

        Optional<Noticia> respuesta = noticiaRepositorio.findById(id);

        if (respuesta.isPresent()) {
            Noticia noticia = respuesta.get();
            noticia.setAlta(true);
            noticiaRepositorio.save(noticia);
        }
    }

    public List<Noticia> listarNoticias() {
        return noticiaRepositorio.findAll();
    }
    
  
}
