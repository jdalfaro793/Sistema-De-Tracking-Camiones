package ar.edu.unju.fi.tracking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Main Controller, maneja las peticiones para el login
 * deacuerdo al rol de cada usuario se le presentara una vista diferente
 * @author RODOLFO
 *
 */
@Controller
@RequestMapping
public class MainController {



		/**
		 * Peticion para mostrar la vista LOGIN
		 * @param model
		 * @return la vista LOGIN
		 */
		@GetMapping({"/","/login"})
		public String ingresar(Model model) {
			return "login";
		}
		/**
		 * Peticion para mostrar la vista INDEX
		 * @param model
		 * @return
		 */

		public String home(Model model) {
			return "index";
		}

		/**
		 * Peticion para mostrar la vista del usuario CONSULTOR
		 * @param model
		 * @return la vista CONSULTOR
		 */
		@GetMapping({"/consultor"})
		public String ingresarConsultor(Model model) {
			return "consultor";
		}
		
		/**
		 * Peticion para mostrar la vista del usuario ADMIN
		 * @param model
		 * @return la vista ADMIN
		 */
		@GetMapping({"/admin"})
		public String ingresarAdministrador(Model model) {
			return "admin";
		}
		/**
		 * Peticion para mostrar la vista del usuario REGISTRADOR
		 * @param model
		 * @return la vista REGISTRADOR
		 */
		@GetMapping({"/registrador"})
		public String ingresarRegistrador(Model model) {
			return "registrador";
		}
		/**
		 * Muestra la pagina sinPermisos usada por webSecurityConfig ante la peticion /sinPermisos  
		 * @return pagina sin permisos
		 */
		@GetMapping("/sinPermisos")
		public String sinPermisos() {
			return "sinPermisos";
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	




