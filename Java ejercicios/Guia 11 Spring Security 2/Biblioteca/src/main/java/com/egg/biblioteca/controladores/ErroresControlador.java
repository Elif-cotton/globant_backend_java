
package com.egg.biblioteca.controladores;

import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ErroresControlador implements ErrorController { //está en el framework ErrorController es una interface de spring

	@RequestMapping(value = "/error", method = { RequestMethod.GET, RequestMethod.POST })
        //todo recurso /error ingrese al método de cualquier petición 
	public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {

		ModelAndView errorPage = new ModelAndView("error");
                
		String errorMsg = "";  //se crea vacio para darle valor
                
		int httpErrorCode = getErrorCode(httpRequest);  //se guarda del metodo getErrorCode

		switch (httpErrorCode) {
		case 400: {
			errorMsg = "El recurso solicitado no existe.";
			break;
		}
		case 403: {
			errorMsg = "No tiene permisos para acceder al recurso.";
			break;
		}
		case 401: {
			errorMsg = "No se encuentra autorizado.";
			break;
		}
		case 404: {
			errorMsg = "El recurso solicitado no fue encontrado.";
			break;
		}
		case 500: {
			errorMsg = "Ocurrió un error interno.";
			break;
		}
		}

		errorPage.addObject("codigo", httpErrorCode); //inyecta bajo el nombre codigo, el valor del código formato entero
		errorPage.addObject("mensaje", errorMsg);// inyecta bajo el nombre mensaje, el mensaje que viene por el código
		return errorPage;
	}

	private int getErrorCode(HttpServletRequest httpRequest) { //trae el código en formato entero
		return (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
	}

	
	public String getErrorPath() {
		return "/error.html";
	}

}
