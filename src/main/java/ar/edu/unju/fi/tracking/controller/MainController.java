package ar.edu.unju.fi.tracking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MainController {



	
	
		@GetMapping({"/","/login"})
		public String ingresar(Model model) {
			return "login";
		}

		
		@GetMapping({"/consultor"})
		public String ingresarConsultor(Model model) {
			return "consultor";
		}
		
		
		@GetMapping({"/admin"})
		public String ingresarAdministrador(Model model) {
			return "admin";
		}
		
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





