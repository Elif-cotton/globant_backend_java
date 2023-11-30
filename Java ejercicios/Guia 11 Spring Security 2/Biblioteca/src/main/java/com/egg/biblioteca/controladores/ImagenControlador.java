
package com.egg.biblioteca.controladores;

import com.egg.biblioteca.entidades.Usuario;
import com.egg.biblioteca.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/imagen")
public class ImagenControlador {
    
    @Autowired
    UsuarioServicio usuarioServicio;
    
    @GetMapping("/perfil/{id}")
    public ResponseEntity<byte[]> imagenUsuario (@PathVariable String id){ //recibe el id del usuario al que está asociado la imagen
        Usuario usuario = usuarioServicio.getOne(id);
        //El método getOne() obtiene una referencia a la entidad de la base de datos sin cargarla 
        //completamente en la memoria. Esto significa que solo se cargan los datos básicos de la entidad, 
        //lo que puede ser suficiente para mostrar la imagen de perfil del usuario. 
       byte[] imagen= usuario.getImagen().getContenido();
       
       HttpHeaders headers = new HttpHeaders();  //cabecera dice que devuelve una imgagen
       
       headers.setContentType(MediaType.IMAGE_JPEG);
       
        
        
       return new ResponseEntity<>(imagen,headers, HttpStatus.OK); 
    }
}
