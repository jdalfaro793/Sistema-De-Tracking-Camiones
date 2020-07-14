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

@Controller
@RequestMapping
public class RegistroController {

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
	// ========================================================================================

	@RequestMapping("/registros")
	public String main(Model model) {
		List<Registro> registros = registroService.obtenerRegistros();
		model.addAttribute("registros", registros);
		return "registroListado";
	}

	@GetMapping("/nuevoRegistro")
	public String agregar(Model model) {
		model.addAttribute("registro", registro);
		List<Localidad> localidades = localidadService.obtenerLocalidades();
		model.addAttribute("localidades", localidades);
		model.addAttribute("tripulantes", tripulanteService.buscarTodosTripulantes());
		model.addAttribute("tripulanteDelForm", tripulante);
		model.addAttribute("vehiculo", vehiculo);
		return "registroFormulario";
	}

	// ========================================================================================

	@PostMapping("/agregarTripulante")
	public String crearTripulante(@ModelAttribute("tripulanteDelForm") Tripulante tripulante, Model model)
			throws Exception {
		try {
			tripulanteService.guardarTripulante(tripulante);
		} catch (Exception f) {
			// TODO: handle exception
			model.addAttribute("formTripulanteErrorMessage", f.getMessage());
		}
		return agregar(model);
	}

	@PostMapping("/buscarTripulante")
	public String buscarTripulante(@ModelAttribute("tripulanteDelForm") Tripulante tripulante, Model model)
			throws Exception {
		try {
			Tripulante tripulanteEncontrado = tripulanteService.buscarTripulante(tripulante.getDocumento());
			try {
				tripulanteService.guardarTripulanteEncontrado(tripulanteEncontrado);
			} catch (Exception e) {
				model.addAttribute("formTripulanteErrorMessage", e.getMessage());
			}
		} catch (Exception e) {
			model.addAttribute("formTripulanteErrorMessage", e.getMessage());
		}
		return agregar(model);

	}

	// ========================================================================================

	@PostMapping("/buscarVehiculo")
	public String buscarVehiculo(@ModelAttribute("vehiculo") Vehiculo vehiculo, Model model) throws Exception {
		try {
			vehiculoEncontrado = vehiculoService.buscarVehiculo(vehiculo.getPatente());
			model.addAttribute("vehiculoEncontrado", vehiculoEncontrado);
			System.out.println("///: " + vehiculoEncontrado);
		} catch (Exception e) {
			model.addAttribute("formVehiculoErrorMessage", e.getMessage());
		}
		return agregar(model);

	}

	@PostMapping("/agregarVehiculo")
	public String crearVehiculo(@ModelAttribute("vehiculo") Vehiculo vehiculo, Model model) throws Exception {
		try {
			vehiculoService.guardarVehiculo(vehiculo);
			vehiculoAgregado = vehiculo;
			model.addAttribute("vehiculoGuardado", vehiculo);
			
		} catch (Exception f) {
			// TODO: handle exception
			model.addAttribute("vehiculoGuardado", f.getMessage());
		}
		return agregar(model);

	}

	// ===========================================================================

	@PostMapping("/saveRegistro")
	public String guardar(@ModelAttribute("registro") Registro registro, Model model) {

		if (vehiculoEncontrado != null) {
			registro.setVehiculo(vehiculoEncontrado);
		} else {

			if (vehiculoAgregado!= null) {
				registro.setVehiculo(vehiculoAgregado);
			}
		}

		registro.setTripulante(tripulanteService.buscarTodosTripulantes());
		try {
			registroService.guardarRegistro(registro);

		} catch (Exception e) {
			model.addAttribute("formTripulanteErrorMessage", e.getMessage());
		}
		tripulanteService.borrarTodosTripulantes();
		return "redirect:/registros";
	}
	
	
	@GetMapping("/cancelarRegistro")
	public String cancelarRegistro(ModelMap model) {
		return "redirect:/registros";
	}
	

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
