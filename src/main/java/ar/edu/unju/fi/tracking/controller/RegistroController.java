package ar.edu.unju.fi.tracking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.tracking.model.Localidad;
import ar.edu.unju.fi.tracking.model.Registro;
import ar.edu.unju.fi.tracking.model.Tripulante;
import ar.edu.unju.fi.tracking.model.Vehiculo;
import ar.edu.unju.fi.tracking.service.ILocalidadService;
import ar.edu.unju.fi.tracking.service.IRegistroService;
import ar.edu.unju.fi.tracking.service.ITripulanteService;
import ar.edu.unju.fi.tracking.service.IVehiculoService;
/**
 * RegistroController, en este controlador se inyectan otros objetos
 * que se necesitan para levantar un registro completo, vehiculo, localidad y tripulantes
 * @author RODOLFO
 *
 */
@Controller
@RequestMapping
public class RegistroController {

	/**
	 * Inyeccion de clases para poder acceder a sus metodos o atributos
	 */
	@Autowired
	IRegistroService registroService;
	@Autowired
	private Registro registro;
	@Autowired
	ILocalidadService localidadService;
	@Autowired
	IVehiculoService vehiculoService;
	@Autowired
	Vehiculo vehiculo;

	@Autowired
	Tripulante tripulante;
	@Autowired
	ITripulanteService tripulanteService;

	Vehiculo vehiculoEncontrado;
	Vehiculo vehiculoAgregado;
	// ======= FIN de Inyecciones==================================================================

	/**
	 * Peticion para mostrar los registros
	 * @param model
	 * @return
	 */
	@RequestMapping("/registros")
	public String main(Model model) {
		//se crea un List para recuperar los registros de la BD
		List<Registro> registros = registroService.obtenerRegistros();
		// se muestra el list con los registros encontrados
		model.addAttribute("registros", registros);
		return "registroListado";
	}
	/**
	 * Peticion para poder dar de alta un registro completo
	 * @param model
	 * @return al formulario registro para ver dicha alta
	 */
	@GetMapping("/nuevoRegistro")
	public String agregar(Model model) {
		model.addAttribute("registro", registro);
		//se recuperan las localidades
		List<Localidad> localidades = localidadService.obtenerLocalidades();
		//se muestra en el modal las localidades encontradas
		model.addAttribute("localidades", localidades);
		
		//se muestra el modal de tripulantes y su busqueda o agregar
		model.addAttribute("tripulantes", tripulanteService.buscarTodosTripulantes());
		model.addAttribute("tripulanteDelForm", tripulante);
		//se muestra el modal de vehiculo y su busqueda o agregar
		model.addAttribute("vehiculo", vehiculo);
		return "registroFormulario";
	}

	// ========================================================================================
	// TRIPULANTES
	/**
	 * Peticion para enviar datos a la vista, agregar un tripulante nuevo
	 * @param tripulante
	 * @param model
	 * @return al model agregar que lleva al formulario
	 * @throws Exception
	 */
	@PostMapping("/agregarTripulante")
	public String crearTripulante(@ModelAttribute("tripulanteDelForm") Tripulante tripulante, Model model)
			throws Exception {
		try {
			//Se guarda el tripulante nuevo
			tripulanteService.guardarTripulante(tripulante);
		} catch (Exception f) {
			// en caso de no poder guardar se muestra un mensaje de error
			model.addAttribute("formTripulanteErrorMessage", f.getMessage());
		}
		return agregar(model);
	}
	/**
	 * Peticion para la busqueda de tripulantes, para evitar agregar uno mismo
	 * @param tripulante
	 * @param model
	 * @return al formulario del registro
	 * @throws Exception
	 */
	@PostMapping("/buscarTripulante")
	public String buscarTripulante(@ModelAttribute("tripulanteDelForm") Tripulante tripulante, Model model)
			throws Exception {
		try {
			//se realiza la busqueda del tripulante 
			Tripulante tripulanteEncontrado = tripulanteService.buscarTripulante(tripulante.getDocumento());
			try {
				//sino lo encuentra permite agregarlo
				tripulanteService.guardarTripulanteEncontrado(tripulanteEncontrado);
			} catch (Exception e) {
				//en caso se no poder agregarlo, muestra un mensaje error
				model.addAttribute("formTripulanteErrorMessage", e.getMessage());
			}
		} catch (Exception e) {
			//en caso de no encontrarlo muestra un mensaje de error
			model.addAttribute("formTripulanteErrorMessage", e.getMessage());
		}
		return agregar(model);

	}

	// ========================================================================================
	// VEHICULO
	/**
	 * Peticion para enviar los datos de una busqueda de vehiculo
	 * @param vehiculo
	 * @param model
	 * @return agregar(model)
	 * @throws Exception
	 */
	@PostMapping("/buscarVehiculo")
	public String buscarVehiculo(@ModelAttribute("vehiculo") Vehiculo vehiculo, Model model) throws Exception {
		try {
			//busqueda del vehiculo
			vehiculoEncontrado = vehiculoService.buscarVehiculo(vehiculo.getPatente());
			//tabla con los datos del vehiculo encontrado
			model.addAttribute("vehiculoEncontrado", vehiculoEncontrado);
			//comprobando si por consola lo encuentra
			System.out.println("///: " + vehiculoEncontrado);
		} catch (Exception e) {
			//en caso de no encontrarlo muestra un mensaje error
			model.addAttribute("formVehiculoErrorMessage", e.getMessage());
		}
		return agregar(model);

	}
	/**
	 * Peticion para agregar un nuevo vehiculo en caso de que no existiera
	 * @param vehiculo
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/agregarVehiculo")
	public String crearVehiculo(@ModelAttribute("vehiculo") Vehiculo vehiculo, Model model) throws Exception {
		try {
			//guarda un vehiculo nuevo
			vehiculoService.guardarVehiculo(vehiculo);
			vehiculoAgregado = vehiculo;
			//muestra el vehiculo nuevo en la vista
			model.addAttribute("vehiculoGuardado", vehiculo);
			
		} catch (Exception f) {
			// en caso de no poder agregarlo, muestra un mensaje de error
			model.addAttribute("vehiculoGuardado", f.getMessage());
		}
		return agregar(model);

	}

	// ===========================================================================
	// REGISTRO
	/**
	 * Peticion para guardar el registro con los datos previamente cargados
	 * @param registro
	 * @param model
	 * @return listado de registros
	 */
	@PostMapping("/saveRegistro")
	public String guardar(@ModelAttribute("registro") Registro registro, Model model) {
		//se verifica si se encontro el vehiculo buscado sino agrega un nuevo
		if (vehiculoEncontrado != null) {
			registro.setVehiculo(vehiculoEncontrado);
		} else {

			if (vehiculoAgregado!= null) {
				registro.setVehiculo(vehiculoAgregado);
			}
		}
		//se guardan los tripulantes agregados en el registro
		registro.setTripulante(tripulanteService.buscarTodosTripulantes());
		//se guarda el registro sino muestra un cartel de error
		try {
			registroService.guardarRegistro(registro);

		} catch (Exception e) {
			model.addAttribute("formTripulanteErrorMessage", e.getMessage());
		}
		//se borran los tripulantes para para no cargarlos nuevamente
		tripulanteService.borrarTodosTripulantes();
		return "redirect:/registros";
	}
	
	/**
	 * Peticion para un boton que redireccione al listado de registros
	 * @param model
	 * @return
	 */
	@GetMapping("/cancelarRegistro")
	public String cancelarRegistro(ModelMap model) {
		return "redirect:/registros";
	}
	
	//Botones que no se piden pero que se podria incluir en caso de un mal tipeo o en caso de un registro mal echo
	// editar registro
	@GetMapping("/editarR/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Optional<Registro> registro = registroService.obtenerUnRegistro(id);
		// para mostrar el objeto con sus datos
		model.addAttribute("registro", registro);
		return "registroFormulario";
	}

	// eliminar registro
	@GetMapping("/eliminarR/{id}")
	public String eliminar(@PathVariable Long id, Model model) {
		registroService.eliminarRegistro(id);
		return "redirect:/registros";
	}

}
