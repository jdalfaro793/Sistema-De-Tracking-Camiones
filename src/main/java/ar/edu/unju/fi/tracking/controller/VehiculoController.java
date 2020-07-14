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

@Controller
@RequestMapping
public class VehiculoController {

	@Autowired
	IVehiculoService vehiculoService;
	@Autowired
	private Vehiculo vehiculo;
	
	@RequestMapping("/vehiculos")
	public String main(Model model) {
		List<Vehiculo> vehiculos = vehiculoService.obtenerVehiculos();
		model.addAttribute("vehiculos", vehiculos);
		return "vehiculoListado";
		
	} 
	
	@GetMapping("/nuevoVehiculo")
	public String agregar(Model model) {
		model.addAttribute("vehiculo", vehiculo);
		return "vehiculoFormulario";
	}
	
	@PostMapping("/saveVehiculo")
	public String guardar(@Valid Vehiculo vehiculo, Model model) {
		vehiculoService.guardarVehiculo(vehiculo);
		return "redirect:/vehiculos";
		
	}

	// editar usuario
	@GetMapping("/editarV/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Optional<Vehiculo> vehiculo = vehiculoService.obtenerUnVehiculo(id);
		//para mostrar el objeto con sus datos
		model.addAttribute("vehiculo", vehiculo);
		return "vehiculoFormulario";
	}
	
	// eliminar usuario
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
