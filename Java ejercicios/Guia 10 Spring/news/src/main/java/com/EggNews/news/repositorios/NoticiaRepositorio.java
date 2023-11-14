
package com.EggNews.news.repositorios;

import com.EggNews.news.entidades.Noticia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author javer
 */

@Repository
public interface NoticiaRepositorio extends JpaRepository<Noticia, String>{
    
    @Query("SELECT l FROM Noticia l WHERE l.titulo= :titulo")
    public Noticia buscarPorTitulo(@Param ("titulo") String titulo);
    
    @Query("SELECT l FROM Noticia l WHERE l.id= :id")
    public Noticia buscarPorId(@Param ("id") String id);
    
    Optional<Noticia> findByTitulo(String titulo);
    
    void deleteById(Long id);
}
