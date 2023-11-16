package gm.contactos.controladores;

import gm.contactos.entidades.Noticia;
import gm.contactos.servicios.NoticiaServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class NoticiaControlador {

    private static final Logger logger=
            LoggerFactory.getLogger(NoticiaControlador.class);  //mandar información

    @Autowired
    private NoticiaServicio noticiaServicio;

   // @GetMapping("/")
    //public String iniciar(ModelMap modelo){
     //   List<Noticia> noticias = noticiaServicio.listarNoticias();

      //  noticias.forEach(noticia -> logger.info(noticia.toString()));
      //  modelo.put("noticias", noticias);
      //  return "index";    //index.html
    //}

    @GetMapping("/")
    public String iniciar(ModelMap modelo) {
        List<Noticia> noticias = noticiaServicio.listarNoticias();

        noticias.forEach(noticia -> logger.info(noticia.toString()));
        modelo.put("noticias", noticias);
        return "index"; // index.html
    }

    @GetMapping("/agregar")  //muestra pág formulario
    public String mostrarAgregar(){

        return "agregar";   //redirecciona a la pag agregar.html
    }

    @PostMapping("/agregar")   //recibe información
    public String agregar(@ModelAttribute ("noticiaForma") Noticia noticia){
        logger.info("Noticia a agregar"+ noticia);

        noticiaServicio.guardarNoticia(noticia);

        return "redirect:/";  //redirigimos al controlador el path "/" de inicio
    }

    @GetMapping("/editar/{id}")   //muestra el formulario de editar
    public String mostrarEditar(@PathVariable(value = "id") int id, ModelMap modelo){

        Noticia noticia = noticiaServicio.buscarNoticiaPorId(id);

        logger.info("Noticia a editar (mostrar): "+ noticia);

        modelo.put("noticia", noticia);  //vista pueda acceder al objeto
        return "editar"; //editar.html
    }

    @PostMapping("/editar")
    public String editar(@ModelAttribute("noticia") Noticia noticia){

        logger.info("Noticia a guardar (editar): "+ noticia);

        noticiaServicio.guardarNoticia(noticia);

        return "redirect:/";  //redirigimos al controlador el path "/" de inicio
    }


    @GetMapping("/eliminar/{id}")
    public String mostrarEliminar(@PathVariable(value = "id") int id){

        Noticia noticia =new Noticia();
        noticia.setId(id);
        noticiaServicio.eliminarNoticia(noticia);

        return "redirect:/";
    }

    @GetMapping("/darBaja/{id}")
    public String darBajaNoticia(@PathVariable(value = "id") int id) {

        System.out.println("Entrando a darBajaNoticia con id: " + id);
        Noticia noticia = noticiaServicio.buscarNoticiaPorId(id);

        if (noticia != null) {
            noticiaServicio.darBajaNoticia(noticia);
        }

        return "redirect:/"; // Redirigir a la página de listado de noticias después de dar de baja
    }
}
