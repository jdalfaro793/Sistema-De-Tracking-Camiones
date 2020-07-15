package ar.edu.unju.fi.tracking.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.tracking.model.Registro;
import ar.edu.unju.fi.tracking.model.Tripulante;
import ar.edu.unju.fi.tracking.service.RegistroServiceImp;
import ar.edu.unju.fi.tracking.service.TripulanteServiceImp;
import ar.edu.unju.fi.tracking.util.Consulta2;

@Controller
@RequestMapping
public class Consulta2Controller {

	@Autowired
	private Consulta2 consultaTripulante;

	@Autowired
	TripulanteServiceImp tripulanteServiceImp;
	
	@Autowired
	RegistroServiceImp registroTrackingServiceImp;
	
	
	@GetMapping("/ingresarTripulante")
	public String ingresarDNITipulante(Model model) {

		model.addAttribute("consultTrip", this.consultaTripulante);
		model.addAttribute("activarNoTripu", false);
		model.addAttribute("activarVerTripuBusc", false);
		model.addAttribute("activarSinReg", false);
		model.addAttribute("activarTabla", false);

		return "ConsultaTripulante";
	}

	@PostMapping("/BuscarTripulanteDNI")
	public String buscarTripulante(@Valid @ModelAttribute("consultTrip") Consulta2 consultaTripulante, Model model) {

		// enviar un objeto a la vista
		model.addAttribute("consultTrip", this.consultaTripulante);

		// instanciar un objeto de tipo Tripulante
		Tripulante tripulanteBusc = new Tripulante();

		// busco el DNI del tripulante
		tripulanteBusc = tripulanteServiceImp.buscarTripulanteDNI(consultaTripulante.getDni().toString());

		// verifico si esque se encontro el tripulante
		if (tripulanteBusc == null) {

			// activar el panel de error
			model.addAttribute("activarNoTripu", true);

			// enviar mensaje de no encontrado
			model.addAttribute("noTripu", "No se encontro la tripulante con DNI: " + consultaTripulante.getDni());

		} else {
			// tripuEncontrado
			model.addAttribute("activarVerTripuBusc", true);
			model.addAttribute("tripuEncontrado", tripulanteBusc);

			// instanciar un List que alamcenara registros
			List<Registro> registrosEnco = new ArrayList<Registro>();

			// buscar los registros para un tripulante
			registrosEnco = registroTrackingServiceImp.buscarPorTripulanteOrdenFechaHora(tripulanteBusc);

			// verificar si hay registros
			if (registrosEnco.isEmpty()) {

				// enviar mensaje correspondiente
				model.addAttribute("activarSinReg", true);
				model.addAttribute("msgSinTripu", "No se encontraron registros para el tripulante seleccionado");

			} else {

				// activar vista de registros
				model.addAttribute("activarTabla", true);

				// enviar registros encontrados
				model.addAttribute("registrosTrip", registrosEnco);

			}

		}

		return "ConsultaTripulante";
	}

}
