package gm.contactos.servicios;

import gm.contactos.entidades.Noticia;

import java.util.List;

public interface INoticiaServicio {

    public List<Noticia> listarNoticias();

    public Noticia buscarNoticiaPorId(Integer id);

    public void guardarNoticia(Noticia noticia);    //guardar y actualizar

    public void eliminarNoticia(Noticia noticia);

    public void darBajaNoticia(Noticia noticia);
}
