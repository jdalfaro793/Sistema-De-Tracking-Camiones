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
		@GetMapping({"index"})
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
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 * cosas a borrar
	 * 
	 * 
	 */
	
	
	
//	@RequestMapping("/usuarios")
//	public String main(Model model) {
//		List<Usuario> usuarios = usuarioService.obtenerUsuarios();
//		model.addAttribute("usuarios", usuarios);
//		return "usuariosListado";
//	}
//
//	@GetMapping("nuevoUsuario")
//	public String agregar(Model model) {
//		model.addAttribute("usuario", usuario);
//		return "usuarioFormulario";
//	}
//
//	@PostMapping("/save")
//	public String guardar(@Valid Usuario usuario, Model model) {
//
//		usuarioService.guardarUsuario(usuario);
//		return "redirect:/usuarios";
//
//	}
//
//	
//
//	@RequestMapping("/vehiculos")
//	public String vehiculo(Model model) {
//		List<Vehiculo> vehiculos = vehiculoService.obtenerVehiculos();
//		model.addAttribute("vehiculos", vehiculos);
//		return "vehiculosListado";
//	}
//
//	@GetMapping("nuevoVehiculo")
//	public String agregar1(Model model) {
//		model.addAttribute("vehiculo", vehiculo);
//		return "vehiculosFormulario";
//	}
//
//	@PostMapping("/saveVehiculo")
//	public String guardar(@Valid Vehiculo vehiculo, Model model) {
//
//		vehiculoService.guardarVehiculo(vehiculo);
//		return "redirect:/vehiculos";
//	}





