package ar.edu.unju.fi.tracking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.tracking.model.Tripulante;
import ar.edu.unju.fi.tracking.service.ITripulanteService;
/**
 * TripulanteController, nos permite administrar las peticiones que necesitaremos 
 * para hacer el ABM de la clase Tripulantes
 * @author RODOLFO DEL JUICIO
 *
 */
@Controller
@RequestMapping
public class TripulanteController {
	/**
	 * Inyecciones
	 */
	@Autowired
	ITripulanteService tripulanteService;
	@Autowired
	private Tripulante tripulante;

	/**
	 * Peticion para cargar el listado de tripulantes
	 * @param model
	 * @return
	 */
	@RequestMapping("/tripulantes")
	public String main(Model model) {
		//recuperar tripulantes que ya existan en la BD
		List<Tripulante> tripulantes = tripulanteService.obtenerTripulantes();
		//mostrar los tripulantes recuperados
		model.addAttribute("tripulantes", tripulantes);
		return "tripulanteListado";
		
	} 

	/**
	 * Peticion para poder dar de alta un tripulante nuevo
	 * @param model
	 * @return
	 */
	@GetMapping("/nuevoTripulante")
	public String agregar(Model model) {
		//se muestra el modal con el formulario de tripulante
		model.addAttribute("tripulante", tripulante);
		return "tripulanteFormulario";
	}
	/**
	 * Peticion para recuperar los datos del tripulante que se va a guardar
	 * @param tripulante
	 * @param model
	 * @return
	  
	 */
	@PostMapping("/saveTripulante")
	public String guardar(Tripulante tripulante, Model model)throws Exception {
		//se guarda el tripulante nuevo
		tripulanteService.guardarTripulante(tripulante);
		System.out.println("Exito");
		return "redirect:/tripulantes";
		
	}
	/**
	 * Peticion para poder modificar el tripulante que se requiera
	 * @param id
	 * @param model
	 * @return
	 */
	// editar Tripulante
	@GetMapping("/editarT/{id}")
	public String editar(@PathVariable Long id, Model model) {
		//recuperar un tripulante con su ID
		Optional<Tripulante> tripulante = tripulanteService.obtenerUnTripulante(id);
		//para mostrar el objeto con sus datos
		model.addAttribute("tripulante", tripulante);
		return "tripulanteFormulario";
	}
	/**
	 * Peticion para eliminar un tripulante 
	 * @param id
	 * @param model
	 * @return
	 */
	// eliminar Tripulante
	@GetMapping("/eliminarT/{id}")
	public String eliminar(@PathVariable Long id, Model model) {
		tripulanteService.eliminarTripulante(id);
		return "redirect:/tripulantes";
	}
}
