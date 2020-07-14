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

@Controller
@RequestMapping
public class UsuarioController {
	
	@Autowired
	IUsuarioService usuarioService;
	@Autowired
	private Usuario usuario;
	
	@RequestMapping("/usuarios")
	public String main(Model model) {
		model.addAttribute("usuarioDelForm", usuario);
		List<Usuario> usuarios = usuarioService.obtenerUsuarios();
		model.addAttribute("usuarios", usuarios);
		return "usuariosListado";
	}
	
	@GetMapping("/nuevoUsuario")
	public String agregar(Model model) {
		model.addAttribute("usuario", usuario);
		return "usuarioFormulario";
	}
	
	@PostMapping("/save")
	public String guardar(@Valid Usuario usuario, Model model) {
		
		usuarioService.guardarUsuario(usuario);
		return "redirect:/usuarios";
		
	}

	// editar usuario
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Optional<Usuario> usuario = usuarioService.obtenerUnUsuario(id);
		//para mostrar el objeto con sus datos
		model.addAttribute("usuario", usuario);
		return "usuarioFormulario";
	}
	
	// eliminar usuario
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id, Model model) {
		usuarioService.eliminarUsuario(id);
		return "redirect:/usuarios";
	}
	
}
