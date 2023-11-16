package gm.contactos.repositorios;

import gm.contactos.entidades.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticiaRepositorio extends JpaRepository<Noticia, Integer> {

    List<Noticia> findByBajaFalse();
}
