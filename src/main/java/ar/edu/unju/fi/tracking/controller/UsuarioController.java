package ar.edu.unju.fi.tracking.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.tracking.model.Usuario;
import ar.edu.unju.fi.tracking.service.IUsuarioService;
/**
 * UsuarioController, permite administrar las peticiones para el ABM de usuarios y sus roles
 * @author RODOLFO
 *
 */
@Controller
@RequestMapping
public class UsuarioController {
	/**
	 * Inyecciones
	 */
	@Autowired
	IUsuarioService usuarioService;
	@Autowired
	private Usuario usuario;
	
	/**
	 * Peticion para preparar la informacion que se va a mostrar en la vista
	 * @param model
	 * @return
	 */
	@RequestMapping("/usuarios")
	public String main(Model model) {
		model.addAttribute("usuarioDelForm", usuario);
		//se crea un list para recuperar los usuarios de la BD
		List<Usuario> usuarios = usuarioService.obtenerUsuarios();
		//se muestran los usuarios encontrados
		model.addAttribute("usuarios", usuarios);
		return "usuariosListado";
	}
	/**
	 * Peticion para mostrar el formulario de alta de usuario
	 * @param model
	 * @return
	 */
	@GetMapping("/nuevoUsuario")
	public String agregar(Model model) {
		//se muestra formulario de usuario
		model.addAttribute("usuario", usuario);
		return "usuarioFormulario";
	}
	/**
	 * Peticion para guardar los datos del usuario nuevo
	 * @param usuario
	 * @param model
	 * @return
	 */
	@PostMapping("/save")
	public String guardar(@Valid Usuario usuario, Model model) {
		//se guarda usuario nuevo
		usuarioService.guardarUsuario(usuario);
		return "redirect:/usuarios";
		
	}
	
	/**
	 * Peticion para poder modificar datos del usuario
	 * @param id
	 * @param model
	 * @return
	 */
	// editar usuario
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		//se busca el usuario para modificarlo
		Optional<Usuario> usuario = usuarioService.obtenerUnUsuario(id);
		//para mostrar el objeto con sus datos
		model.addAttribute("usuario", usuario);
		return "usuarioFormulario";
	}
	/**
	 * Peticion para eliminar un usuario
	 * @param id
	 * @param model
	 * @return
	 */
	// eliminar usuario
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id, Model model) {
		usuarioService.eliminarUsuario(id);
		return "redirect:/usuarios";
	}
	
}
