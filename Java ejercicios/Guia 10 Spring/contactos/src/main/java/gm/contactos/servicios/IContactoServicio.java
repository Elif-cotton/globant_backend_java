package gm.contactos.servicios;

import gm.contactos.entidades.Contacto;

import java.util.List;

public interface IContactoServicio {

    public List<Contacto> listarContactos();

    public Contacto buscarContactoPorId(Integer idContacto);

    public void guardarContacto(Contacto contacto);    //guardar y actualizar

    public void eliminarContacto(Contacto contacto);
}
