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
import ar.edu.unju.fi.tracking.model.Vehiculo;
import ar.edu.unju.fi.tracking.service.RegistroServiceImp;
import ar.edu.unju.fi.tracking.service.VehiculoServiceImp;
import ar.edu.unju.fi.tracking.util.Consulta3;


@Controller
@RequestMapping
public class Consulta3Controller {
	
	@Autowired
	private Consulta3 consultaPatente;
	
	@Autowired
	VehiculoServiceImp vehiculoServiceImp;
	
	@Autowired
	RegistroServiceImp registroServiceImp;
	
	@GetMapping("/ingresarPatente")
	public String ingresarPatente(Model model) {
		
		model.addAttribute("consPatente", this.consultaPatente);
		model.addAttribute("activarNoPatente", false);
		model.addAttribute("activarSinRegistro", false);
		model.addAttribute("activarTabla", false);
		
		return "ConsultaPatente";
	}
	
	@PostMapping("/buscarPatente")
	public String buscarPatente(@Valid @ModelAttribute("consPatente") Consulta3 consultaPatente, Model model) {
		
		//enviar objeto a la vista
		model.addAttribute("consPatente", this.consultaPatente);
		
		// instancir una clase Vehiculo a buscar
		Vehiculo vehiculoBusc = new Vehiculo();

		// busco la patente en la base de datos
		vehiculoBusc = vehiculoServiceImp.buscarPatentePorNombre(consultaPatente.getPatente());
		
		//verificar si existe la patente en la BD
		if(vehiculoBusc == null) {
			
			//activar el panel de error
			model.addAttribute("activarNoPatente", true);
			
			//enviar mensaje de no encontrado
			model.addAttribute("noPatente", "No se encontro la patente: " + consultaPatente.getPatente());
			
		} else {
			
			//instanciar un objeto para guardar los registros encontrados
			List<Registro> registrosEncontrados = new ArrayList<Registro>();
			
			//guardar los registros encontrados
			registrosEncontrados = registroServiceImp.buscarPorPatenteOrdenFechaHora(vehiculoBusc);
			
			//verificar si se encontro u registro para la patente
			if(registrosEncontrados.isEmpty()) {
				
				//enviar mensaje de sin registros para la patente
				model.addAttribute("activarSinRegistro", true);
				model.addAttribute("sinRegistro", "No se han encontrado registros para la patente: " + consultaPatente.getPatente());
				
			} else {
				//activar tabla para ver registros
				model.addAttribute("activarTabla", true);
				//mostrar los registros encontrados
				model.addAttribute("registrosPatente", registrosEncontrados);
				
			}
			
		}
		
		return "ConsultaPatente";
	}

}
