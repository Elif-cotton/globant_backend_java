
package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidades.Usuario;
import com.egg.biblioteca.enumeraciones.Rol;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author javer
 */

@Service
public class UsuarioServicio implements UserDetailsService{
    
    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    
    @Transactional
    public void registrar(String nombre, String email, String password, String password2) throws MiException{
        
        validar(nombre, email, password, password2);
        
        Usuario usuario=new Usuario();
        
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setPassword(password);
        
        usuario.setRol(Rol.USER);
        
        usuarioRepositorio.save(usuario);
        
    }
    
    private void validar(String nombre, String email, String password, String password2) throws MiException {

        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("el nombre no puede ser nulo o estar vacío");
        }
        if (email.isEmpty() || email == null) {
            throw new MiException("el email no puede ser nulo o estar vacio");
        }
        if (password.isEmpty() || password == null || password.length() <= 5) {
            throw new MiException("La contraseña no puede estar vacía, y debe tener más de 5 dígitos");
        }

        if (!password.equals(password2)) {
            throw new MiException("Las contraseñas ingresadas deben ser iguales");
        }

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {  //recibir el email para autenticar
        
        Usuario usuario= usuarioRepositorio.buscarPorEmail(email);
        
        if (usuario!=null){
            
        }
        return null;
    }

    
}
