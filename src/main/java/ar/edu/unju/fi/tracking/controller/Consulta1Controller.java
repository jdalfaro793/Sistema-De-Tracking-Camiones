package ar.edu.unju.fi.tracking.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.tracking.model.Localidad;
import ar.edu.unju.fi.tracking.model.Registro;
import ar.edu.unju.fi.tracking.service.LocalidadServiceImp;
import ar.edu.unju.fi.tracking.service.RegistroServiceImp;
import ar.edu.unju.fi.tracking.util.Consulta1;


@Controller
@RequestMapping
public class Consulta1Controller {

	@Autowired
	private Consulta1 consultaLocalidad;
	
	@Autowired
	private LocalidadServiceImp localidadServiceImp;
	
	
	@Autowired
	
	private RegistroServiceImp registroTrackingServiceImp;
	
	
	
	@GetMapping("/ingresarLocalidadYFecha")
	public String ingresarLocaidadFecha(Model model) {
		
		// envio la clase de consulta
		model.addAttribute("consulta", this.consultaLocalidad);

		// lista con localidades guardadas
		model.addAttribute("localidades", localidadServiceImp.obtenerLocalidades());

		// desactivar losmensajes en esta vista
		model.addAttribute("activar", false);
		model.addAttribute("activarSinRegistro", false);
		model.addAttribute("mensajeErr", false);
		model.addAttribute("activarRegLocFech", false);
				
		return "ConsultaLocalidad";
	}
	
	/**
	 * Metodo controlador de consultas post para buscar por localidad y un rango de
	 * fechas ingresado por el usuario
	 * 
	 * @param consultaLocalidad datos que recibe desde la vista para realizar la
	 *                         busqueda
	 * @param model            interfaz de modelo
	 * @param result           interfaz de errores
	 * @return la vista html a enviar
	 */
	@PostMapping("/buscarPorLocalidadYRangoFechaHora")
	public String buscarPorLocalidadYRangoFechaHora(
			@Valid @ModelAttribute("consulta") Consulta1 consultaLocalidad, Model model, BindingResult result) {
		/*
		 * ------------- ENVIO DE DATOS A LA VISTA ----------------
		 */

		// envio la clase de consulta
		model.addAttribute("consulta", this.consultaLocalidad);

		// envio de una clase Vehiculo
		model.addAttribute("vehiculo", new String());

		// lista con localidades guardadas
		model.addAttribute("localidades", localidadServiceImp.obtenerLocalidades());

		// todos los registros
		model.addAttribute("todosRegistros", registroTrackingServiceImp.obtenerRegistros());
		// model.addAttribute("activar", false);

		/*
		 * -------------- INSTANCIAR ELEMENTOS ---------------------
		 */

		// se instancia una clase de tipo Localidad
		Localidad localidadBuscar = new Localidad();

		// se instancia una clase de tipo RegistroTracking
		List<Registro> registrosEncontrados = new ArrayList<Registro>();

		/*
		 * ------------ EMPEZAR A VERIFICAR
		 */

		if (result.hasErrors() == false) {

			// verifico que fechaDesde sea antes que fechaHasta
			if (consultaLocalidad.getFechaDesde().compareTo(consultaLocalidad.getFechaHasta()) < 0) {

				model.addAttribute("activar", true);

				// buscar la localidad seleccionada anteriormente
				try {
					localidadBuscar = localidadServiceImp.buscarNombreLocalidad(consultaLocalidad.getLocalidad().getNombre());
				} catch (Exception e) {
					e.printStackTrace();
				}

				// model.addAttribute("activar", true);
				model.addAttribute("verBuscado", consultaLocalidad.getFechaDesde());
				model.addAttribute("mostrarLocalidad", localidadBuscar.getNombre());

				// buscar registros para la localidad encontrada y elrango de fechas
				// seleccionado
				registrosEncontrados = registroTrackingServiceImp.buscarRegistrosRangoFechasYLocalidad(
						consultaLocalidad.getFechaDesde(), consultaLocalidad.getFechaHasta(), localidadBuscar);

				// model.addAttribute("verReg", registrosEncontrados.get(0).getId());

				// verificar si se encontraron registros
				if (registrosEncontrados.isEmpty()) {

					// activar mensaje de sin registros
					model.addAttribute("activarSinRegistro", true);
					// enviar el mensaje
					model.addAttribute("registroVacio", "No se encontraron registros para el rango de fechas seleccionado");

				} else {

					model.addAttribute("activarRegLocFech", true);
					// enviar los registros encontrados a la vista
					model.addAttribute("registrosLocalidadFechas", registrosEncontrados);

				}

				return "ConsultaLocalidad";

			} else if (consultaLocalidad.getFechaDesde().compareTo(consultaLocalidad.getFechaHasta()) > 0) {

				// activo el mensaje de la vista
				model.addAttribute("mensajeErr", true);
				// mando el mensaje de error
				model.addAttribute("errorFecha",
						"¡ATENCIÓN!: La fecha inicial es mayor a la fecha final, intente nuevamente");

				return "ConsultaLocalidad";
			}

		} else {

			return "ConsultaLocalidad";
		}

		return "ConsultaLocalidad";
	}
	
	/**
	 * Permite mostrar el registro y sus tripulantes
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/mostrarTripulante/{id}")
	public String mostrarTripulantes(@PathVariable(name = "id") Long id, Model model) {
		
		//model.addAttribute("activarMostrarTripus", true);
		
		Optional<Registro> registroEnc = registroTrackingServiceImp.obtenerUnRegistro(id);
		
		//verificar que se haya encontrado el registro
		if(registroEnc.isEmpty()) {
			
			model.addAttribute("activo", true);
			model.addAttribute("noEncontrado", "No se encontraron los registros...");
			
		} else {
			
			Registro registro = new Registro();
			
			registro = registroEnc.get();
			
			model.addAttribute("activarTripus", true);
			//enviar registro
			model.addAttribute("registro", registro);
			
			model.addAttribute("tripulantes", registro.getTripulante());
			
		}
		
		return "mostrarTripulantes";
	}	
	
	
	
	
	
	
}
