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

/**
 * LocalidadController, va a manejar todas las peticiones para poder tener un ABM
 * sobre las localidades disponibles para el registro
 * @author RODOLFO
 *
 */
@Controller
@RequestMapping
public class LocalidadController {
	/**
	 * Inyeccion de Clases para acceder a sus metodos o atributos
	 */
	@Autowired
	ILocalidadService localidadService;
	@Autowired
	private Localidad localidad;
	
	/**
	 * Peticion para cargar los datos en la vista
	 * @param model
	 * @return la vista del Listado de Localidad
	 */
	@RequestMapping("/localidades")
	public String main(Model model) {
		// Se crea un list con las localidades que estan en la BD
		List<Localidad> localidades = localidadService.obtenerLocalidades();
		// Se muestra el modal con las localidades
		model.addAttribute("localidades", localidades);
		return "localidadListado";
		
	} 
	/**
	 * Peticion para mostrar el formulario de Localidad
	 * @param model
	 * @return la vista de Formulario Localidad
	 */
	@GetMapping("/nuevoLocalidad")
	public String agregar(Model model) {
		model.addAttribute("localidad", localidad);
		return "localidadFormulario";
	}
	/**
	 * Peticion para enviar los datos de la Localidad que se haya guardado
	 * @param localidad
	 * @param model
	 * @return redirecciona a Localidad Listado
	 */
	@PostMapping("/saveLocalidad")
	public String guardar(@Valid Localidad localidad, Model model) {
		// se guarda la localidad en la BD
		localidadService.guardarLocalidad(localidad);
		return "redirect:/localidades";
		
	}
	/**
	 * Peticion que permite acceder a la modificacion de Localidad
	 * @param id
	 * @param model
	 * @return al Formulario para poder editar los datos de Localidad
	 */
	// editar localidad
	@GetMapping("/editarL/{id}")
	public String editar(@PathVariable Long id, Model model) {
		//Se crea un Optional para poder recuperar los datos de una localidad con su ID
		Optional<Localidad> localidad = localidadService.obtenerUnaLocalidad(id);
		//model para mostrar el objeto con sus datos
		model.addAttribute("localidad", localidad);
		return "localidadFormulario";
	}
	/**
	 * Peticion que permite eliminar la Localidad seleccionada
	 * @param id
	 * @param model
	 * @return al Listado de localidades para verificar que la localidad se elimino
	 */
	// eliminar localidad
	@GetMapping("/eliminarL/{id}")
	public String eliminar(@PathVariable Long id, Model model) {
		//se busca la localidad por ID y se elimina
		localidadService.eliminarLocalidad(id);
		return "redirect:/localidades";
	}
}
