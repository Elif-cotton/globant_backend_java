
package com.egg.Biblioteca.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author javer
 */

@Controller
@RequestMapping("/")  
public class PortalControlador {    //localhost:8080/
    
    @GetMapping("/")              //mapea la url cuando se ingresa la barra /, se ejecuta el método
    public String index(){        //localhost:8080/
        
        return "index.html";
    }
    
}
