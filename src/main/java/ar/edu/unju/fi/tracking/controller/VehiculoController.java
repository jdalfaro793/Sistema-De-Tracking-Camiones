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

import ar.edu.unju.fi.tracking.model.Vehiculo;
import ar.edu.unju.fi.tracking.service.IVehiculoService;
/**
 * Vehiculo Controller, permite controlar las peticiones para el ABM de vehiculo
 *
 */
@Controller
@RequestMapping
public class VehiculoController {
	/**
	 * Inyeccion
	 */
	@Autowired
	IVehiculoService vehiculoService;
	@Autowired
	private Vehiculo vehiculo;
	
	/**
	 * Peticion para preparar el listado de vehiculos existentes
	 * @param model
	 * @return
	 */
	@RequestMapping("/vehiculos")
	public String main(Model model) {
		//listado de vehiculos en la BD
		List<Vehiculo> vehiculos = vehiculoService.obtenerVehiculos();
		//se muestran los vehiculos encontrados
		model.addAttribute("vehiculos", vehiculos);
		return "vehiculoListado";
		
	} 
	/**
	 * Peticion para agregar un nuevo vehiculo
	 * @param model
	 * @return al formulario de vehiculo
	 */
	@GetMapping("/nuevoVehiculo")
	public String agregar(Model model) {
		model.addAttribute("vehiculo", vehiculo);
		return "vehiculoFormulario";
	}
	/**
	 * Peticion para realizar el alta de un vehiculo
	 * @param vehiculo
	 * @param model
	 * @return
	 */
	@PostMapping("/saveVehiculo")
	public String guardar(@Valid Vehiculo vehiculo, Model model) {
		//se guarda el vehiculo en la BD
		vehiculoService.guardarVehiculo(vehiculo);
		return "redirect:/vehiculos";
		
	}
	/**
	 * Peticion para modificar datos de un vehiculo
	 * @param id
	 * @param model
	 * @return
	 */
	// editar vehiculo
	@GetMapping("/editarV/{id}")
	public String editar(@PathVariable Long id, Model model) {
		//se busca el vehiculo por ID
		Optional<Vehiculo> vehiculo = vehiculoService.obtenerUnVehiculo(id);
		//para mostrar el objeto con sus datos
		model.addAttribute("vehiculo", vehiculo);
		return "vehiculoFormulario";
	}
	/**
	 * Peticion para eliminar un vehiculo
	 * @param id
	 * @param model
	 * @return
	 */
	// eliminar vehiculo
	@GetMapping("/eliminarV/{id}")
	public String eliminar(@PathVariable Long id, Model model) {
		vehiculoService.eliminarVehiculo(id);
		return "redirect:/vehiculos";
	}
	
	
	
	//prueba
	
	/*
	 * @PostMapping("/buscarVehiculo") public String
	 * buscarVehiculo(@ModelAttribute("vehiculoDelForm") Vehiculo vehiculo, Model
	 * model) throws Exception { try {
	 * 
	 * Vehiculo vehiculoEncontrado =
	 * vehiculoService.buscarVehiculo(vehiculo.getPatente()); try {
	 * vehiculoService.guardarVehiculo(vehiculoEncontrado); } catch (Exception e) {
	 * // TODO Auto-generated catch block
	 * model.addAttribute("formVehiculoErrorMessage", e.getMessage()); }
	 * }catch(Exception e) { model.addAttribute("formVehiculoErrorMessage",
	 * e.getMessage()); } return "redirect:/vehiculos"; }
	 */
}
