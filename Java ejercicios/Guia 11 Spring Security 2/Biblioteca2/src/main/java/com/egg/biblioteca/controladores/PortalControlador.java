package com.egg.biblioteca.controladores;

import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.servicios.UsuarioServicio;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PortalControlador {

    @Autowired 
    UsuarioServicio usuarioServicio;
    
    @GetMapping("/")
    public String index() {

        return "index.html";
    }

    @GetMapping("/registrar")
    public String registrar() {

        return "registro.html";
    }
    
    @PostMapping("/registro")   //recibir valores del formualrio
    public String registro(@RequestParam String nombre,@RequestParam String email,
            @RequestParam String password, String password2, ModelMap modelo) {
        
        try {
            usuarioServicio.registrar(nombre, email, password, password2);
            
            modelo.put("exito", "Usuario registrado correctamente!");
            return "index.html";
            
        } catch (MiException ex) {
            
            modelo.put("error", ex.getMessage());
            modelo.put("nombre",nombre); //en caso de error no tengamos que escribirlos otra vez, quedan guardados
            modelo.put("email",email);
            return "registro.html";
        }
        
    }
    
    @GetMapping("/login")
    public String login(@RequestParam(required = false)String error, ModelMap modelo) {   //puede o no venir un error
        if(error!=null){
            modelo.put("error", "Usuario o contraseña invalidos!");
        }
        return "login.html";
    }
    
    @GetMapping("/inicio")
    public String inicio() {

        return "inicio.html";
    }
}
