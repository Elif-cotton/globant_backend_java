
package servicios;

import entidades.Noticia;
import entidades.Periodista;
import enumeraciones.Rol;
import excepciones.MiException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import repositorios.NoticiaRepositorio;
import repositorios.PeriodistaRepositorio;

/**
 *
 * @author javer
 */

@Service
public class PeriodistaServicio implements UserDetailsService{
    
    @Autowired
    private NoticiaRepositorio noticiaRepositorio; 
    
    @Autowired
    private PeriodistaRepositorio periodistaRepositorio;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        Periodista periodista = periodistaRepositorio.buscarPorEmail(email); 
        
        if (periodista != null) {
            List<GrantedAuthority> permisos = new ArrayList<>();
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + periodista.getRol().toString());
            permisos.add(p);

            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();

            HttpSession session = attr.getRequest().getSession(true);

            session.setAttribute("periodista", periodista);

            return new User(periodista.getEmail(), periodista.getPassword(), permisos);
        } else {
            return null;
        }
    }
    
    public void registrar(String nombre, String email, String password, String password2) throws MiException {
        validar(nombre, email, password, password2);

        Periodista periodista = new Periodista();

        periodista.setNombre(nombre);
        periodista.setEmail(email);
        periodista.setPassword(new BCryptPasswordEncoder().encode(password));

        periodista.setRol(Rol.REPORTER);

        periodistaRepositorio.save(periodista);
    }

    public void validar(String nombre, String email, String password, String password2) throws MiException {
        if (nombre == null || nombre.isEmpty()) {
            throw new MiException("El nombre no puede estar vacío");
        }
        if (email == null || email.isEmpty()) {
            throw new MiException("El email no puede estar vacío");
        }
        if (password == null || password.isEmpty() || password.length() <= 5) {
            throw new MiException("La contraseña no puede estar vacía ni tener menos de 5 caracteres");
        }
        if (!password.equals(password2)) {
            throw new MiException("Las contraseñas deben ser iguales");
        }
    }

    
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
