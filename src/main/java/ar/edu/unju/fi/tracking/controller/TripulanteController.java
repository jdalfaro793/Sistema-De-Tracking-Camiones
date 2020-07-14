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

import ar.edu.unju.fi.tracking.model.Tripulante;
import ar.edu.unju.fi.tracking.service.ITripulanteService;

@Controller
@RequestMapping
public class TripulanteController {

	@Autowired
	ITripulanteService tripulanteService;
	@Autowired
	private Tripulante tripulante;
	
	@RequestMapping("/tripulantes")
	public String main(Model model) {
		List<Tripulante> tripulantes = tripulanteService.obtenerTripulantes();
		model.addAttribute("tripulantes", tripulantes);
		return "tripulanteListado";
		
	} 
	
	@GetMapping("/nuevoTripulante")
	public String agregar(Model model) {
		model.addAttribute("tripulante", tripulante);
		return "tripulanteFormulario";
	}
	
	@PostMapping("/saveTripulante")
	public String guardar(@Valid Tripulante tripulante, Model model) {
		tripulanteService.guardarTripulante(tripulante);
		return "redirect:/tripulantes";
		
	}

	// editar usuario
	@GetMapping("/editarT/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Optional<Tripulante> tripulante = tripulanteService.obtenerUnTripulante(id);
		//para mostrar el objeto con sus datos
		model.addAttribute("tripulante", tripulante);
		return "tripulanteFormulario";
	}
	
	// eliminar usuario
	@GetMapping("/eliminarT/{id}")
	public String eliminar(@PathVariable Long id, Model model) {
		tripulanteService.eliminarTripulante(id);
		return "redirect:/tripulantes";
	}
}
