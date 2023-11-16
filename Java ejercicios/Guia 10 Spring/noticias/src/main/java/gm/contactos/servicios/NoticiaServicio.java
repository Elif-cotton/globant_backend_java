package gm.contactos.servicios;

import gm.contactos.entidades.Noticia;
import gm.contactos.repositorios.NoticiaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticiaServicio implements INoticiaServicio {

    @Autowired
    private NoticiaRepositorio noticiaRepositorio;

    //@Override
   // public List<Noticia> listarNoticias() {

      //  return noticiaRepositorio.findAll();
    //}
    @Override
    public List<Noticia> listarNoticias() {
        return noticiaRepositorio.findByBajaFalse();
    }


    @Override
    public Noticia buscarNoticiaPorId(Integer id) {
        Noticia noticia = noticiaRepositorio.findById(id).orElse(null);
        return noticia;
    }

    @Override
    public void guardarNoticia(Noticia noticia) {
        noticia.setBaja(false);
        noticiaRepositorio.save(noticia);
    }

    @Override
    public void eliminarNoticia(Noticia noticia) {

        noticiaRepositorio.delete(noticia);
    }

    @Override
    public void darBajaNoticia(Noticia noticia){
        noticia.setBaja(true);
        noticiaRepositorio.save(noticia);
    }
}
