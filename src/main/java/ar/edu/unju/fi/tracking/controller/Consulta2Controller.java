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
/**
 * Esta clase permite manejar todas las peticiones para realizar la consulta numero 2
 * que pide listar el recorrido de tripulantes por fecha
 * 
 *
 */
@Controller
@RequestMapping
public class Consulta2Controller {
	/**
	 * Inyeccion de las clases que se van a necesitar para acceder
	 * a sus metodos o atributos
	 */
	//Clase Consulta2, una clase auxiliar
	@Autowired
	private Consulta2 consultaTripulante;
	
	@Autowired
	TripulanteServiceImp tripulanteServiceImp;
	
	@Autowired
	RegistroServiceImp registroTrackingServiceImp;
	
	/**
	 * Peticion para la pagina ConsultaTripulante
	 * @param model
	 * @return Vista ConsultaTripulante
	 */
	@GetMapping("/ingresarTripulante")
	public String ingresarDNITipulante(Model model) {
		// Se carga los model en las vistas
		model.addAttribute("consultTrip", this.consultaTripulante);
		//Los siguientes model estan desactivados hasta realizar cierta accion para activarlos (true)
		model.addAttribute("activarNoTripu", false);
		model.addAttribute("activarVerTripuBusc", false);
		model.addAttribute("activarSinReg", false);
		model.addAttribute("activarTabla", false);
		//Devuelve la pagina ConsultaTripulante
		return "ConsultaTripulante";
	}
	/**
	 * Se envia la informacion solicitada a la vista
	 * @param consultaTripulante
	 * @param model
	 * @return la vista Consulta Tripulante
	 */
	@PostMapping("/BuscarTripulanteDNI")
	public String buscarTripulante(@Valid @ModelAttribute("consultTrip") Consulta2 consultaTripulante, Model model) {

		
		// se manda el objeto de la clase auxiliar a la vista
		model.addAttribute("consultTrip", this.consultaTripulante);

		// se crea un objeto de tipo Tripulante
		Tripulante tripulanteBusc = new Tripulante();

		// se busca el documento del tripulante
		tripulanteBusc = tripulanteServiceImp.buscarTripulanteDNI(consultaTripulante.getDni().toString());

		// se verifica que el tripulante buscado exista
		if (tripulanteBusc == null) {

			// si no existe se activa el model de error
			model.addAttribute("activarNoTripu", true);

			//  y se envia el mensaje de tripulante no encontrado
			model.addAttribute("noTripu", "No se encontro la tripulante con DNI: " + consultaTripulante.getDni());

		} else {
			// sino se muestra el tripulante encontrado y se activa el modal
			model.addAttribute("activarVerTripuBusc", true);
			model.addAttribute("tripuEncontrado", tripulanteBusc);

			
			//se crea un list para guardar los registros encontrados de ese tripulante
			List<Registro> registrosEnco = new ArrayList<Registro>();

			
			//se busca los registros pertenecientes a el tripulante encontrado
			registrosEnco = registroTrackingServiceImp.buscarPorTripulanteOrdenFechaHora(tripulanteBusc);

			
			//condicional que permite ver si existen registros de ese tripulante
			if (registrosEnco.isEmpty()) {

				//se activa modal y se envia mensaje que no existen registros de ese tripulante
				model.addAttribute("activarSinReg", true);
				model.addAttribute("msgSinTripu", "No se encontraron registros para el tripulante seleccionado");

			} else {
				//se activa el modal para mostrar los registros y se envian los registros 
				//que se encontraron del tripulante
				
				model.addAttribute("activarTabla", true);
				model.addAttribute("registrosTrip", registrosEnco);
			}

		}

		return "ConsultaTripulante";
	}

}
