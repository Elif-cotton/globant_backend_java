
package com.EggNews.news.servicios;

import com.EggNews.news.entidades.Noticia;
import com.EggNews.news.excepciones.MiException;
import com.EggNews.news.repositorios.NoticiaRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *consulta, creación, modificación y dar de baja
 * @author javer
 */

@Service
public class NoticiaServicio {
    
    @Autowired
    private NoticiaRepositorio noticiaRepositorio;
    
    @Transactional        //método genera cambios en la BD permanente
    public void crearNoticia(String titulo, String cuerpo) throws MiException{
        
        //Validación con método validar
        validar(titulo, cuerpo);
        // Verificar si el título ya existe en la base de datos
        Optional<Noticia> noticiaExistente = noticiaRepositorio.findByTitulo(titulo);

        if (noticiaExistente.isPresent()) {
        // El título ya existe, manejar la situación según tus necesidades
            throw new MiException("El título ya existe en la base de datos");
        } else {
        // El título no existe, crear y guardar la noticia
            Noticia noticia=new Noticia();
        
            noticia.setTitulo(titulo);
            noticia.setCuerpo(cuerpo);
            noticia.setAlta(new Date());
        
            noticiaRepositorio.save(noticia);
        }
    }
    
    public List<Noticia> listarNoticias(){
        
        List<Noticia> noticias=new ArrayList();
        
        noticias= noticiaRepositorio.findAll();
                
        return noticias;        
    }
    
    public void modificarNoticia(String id, String titulo, String cuerpo) throws MiException{
        
        //Validación con método validar
        if(id==null){
            throw new MiException("El id no puede ser nulo");
        }
        validar(titulo, cuerpo);
        
        Optional<Noticia> respuesta= noticiaRepositorio.findById(id);  //si el valor está presente devuleve true
        
        Noticia noticia=new Noticia();
            
        if(respuesta.isPresent()){
            noticia=respuesta.get();
            
            noticia.setTitulo(titulo);
            noticia.setCuerpo(cuerpo);
            
            noticiaRepositorio.save(noticia);
        }
           
    }
    
    public void darBajaNoticia(String id)throws MiException{
        
        Optional<Noticia> noticiaExistente = noticiaRepositorio.findById(id);

        if (noticiaExistente.isPresent()) {
  
            noticiaRepositorio.deleteById(id);
        } else {
            
            throw new MiException("No se encontró la noticia con el ID especificado");
        }

    }
    
    private void validar(String titulo, String cuerpo) throws MiException{
       
        if(titulo.isEmpty() || titulo == null){
            throw new MiException("El titulo no puede estar vacío o ser nulo");
        }
        if(cuerpo.isEmpty() || cuerpo == null){
            throw new MiException("El cuerpo no puede estar vacío o ser nulo");
        }
        
    }
    
    public Noticia getOne(String id){
        
        return noticiaRepositorio.getOne(id);
    }
}
