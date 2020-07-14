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

import ar.edu.unju.fi.tracking.model.Localidad;
import ar.edu.unju.fi.tracking.service.ILocalidadService;


@Controller
@RequestMapping
public class LocalidadController {

	@Autowired
	ILocalidadService localidadService;
	@Autowired
	private Localidad localidad;
	
	@RequestMapping("/localidades")
	public String main(Model model) {
		List<Localidad> localidades = localidadService.obtenerLocalidades();
		model.addAttribute("localidades", localidades);
		return "localidadListado";
		
	} 
	
	@GetMapping("/nuevoLocalidad")
	public String agregar(Model model) {
		model.addAttribute("localidad", localidad);
		return "localidadFormulario";
	}
	
	@PostMapping("/saveLocalidad")
	public String guardar(@Valid Localidad localidad, Model model) {
		localidadService.guardarLocalidad(localidad);
		return "redirect:/localidades";
		
	}

	// editar usuario
	@GetMapping("/editarL/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Optional<Localidad> localidad = localidadService.obtenerUnaLocalidad(id);
		//para mostrar el objeto con sus datos
		model.addAttribute("localidad", localidad);
		return "localidadFormulario";
	}
	
	// eliminar usuario
	@GetMapping("/eliminarL/{id}")
	public String eliminar(@PathVariable Long id, Model model) {
		localidadService.eliminarLocalidad(id);
		return "redirect:/localidades";
	}
}
