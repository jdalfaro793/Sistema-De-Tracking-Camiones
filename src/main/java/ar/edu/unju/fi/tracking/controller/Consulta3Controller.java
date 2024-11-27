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

/**
 * Clase Consulta3Controller, permite manejar todas las peticiones
 * que necesitaremos para realizar la Consulta3 planteada en el TP
 * 
 *
 */
@Controller
@RequestMapping
public class Consulta3Controller {
	/**
	 * Inyeccion de las clases que necesitaremos para acceder a sus metodos
	 * o atributos
	 */
	@Autowired
	private Consulta3 consultaPatente;
	
	@Autowired
	VehiculoServiceImp vehiculoServiceImp;
	
	@Autowired
	RegistroServiceImp registroServiceImp;
	
	/**
	 * Peticion para la vista ConsultaPatente
	 * @param model
	 * @return la pagina ConsultaPatente
	 */
	@GetMapping("/ingresarPatente")
	public String ingresarPatente(Model model) {
		//Se cargan los model en la vista 
		model.addAttribute("consPatente", this.consultaPatente);
		//Los siguientes model estan desactivados hasta realizar cierta accion para activarlos (true)
		model.addAttribute("activarNoPatente", false);
		model.addAttribute("activarSinRegistro", false);
		model.addAttribute("activarTabla", false);
		
		return "ConsultaPatente";
	}
	/**
	 * Se envian los datos requeridos a la peticion que se envia desde la vista
	 * @param consultaPatente de tipo Consulta3
	 * @param model que se usa en la vista
	 * @return Consulta patente
	 */
	@PostMapping("/buscarPatente")
	public String buscarPatente(@Valid @ModelAttribute("consPatente") Consulta3 consultaPatente, Model model) {
		
		
		//se manda a la vista un objeto de tipo Consulta3
		model.addAttribute("consPatente", this.consultaPatente);
		
		// se crea un objeto para el vehiculo que se va a buscar
		Vehiculo vehiculoBusc = new Vehiculo();

		//se busca la patente del vehiculo y se lo almacena en
		//el objeto anteriormente creado 
		vehiculoBusc = vehiculoServiceImp.buscarPatentePorNombre(consultaPatente.getPatente());
		
		//verificar si existe la patente en la BD
		//se realiza un control para saber si el vehiculo buscado existe en la BD
		if(vehiculoBusc == null) {
			
			//en caso de que no se encuentre se activa el modal
			model.addAttribute("activarNoPatente", true);
			
			//y se muestra el modal informando que no se encontro
			model.addAttribute("noPatente", "No se encontro la patente: " + consultaPatente.getPatente());
			
		} else {
			
			// se crea un List de tipo Registro para almacenar los registros que se encuentren
			List<Registro> registrosEncontrados = new ArrayList<Registro>();
			
			// se almacena registros encontrados
			registrosEncontrados = registroServiceImp.buscarPorPatenteOrdenFechaHora(vehiculoBusc);
			
			//verificar si se encontro u registro para la patente
			if(registrosEncontrados.isEmpty()) {
				
				//se activa modal y se envia mensaje que no existen registros de ese vehiculo
				model.addAttribute("activarSinRegistro", true);
				model.addAttribute("sinRegistro", "No se han encontrado registros para la patente: " + consultaPatente.getPatente());
				
			} else {
				//se activan los modales para mostrar los registros
				model.addAttribute("activarTabla", true);
				model.addAttribute("registrosPatente", registrosEncontrados);

			}
			
		}
		
		return "ConsultaPatente";
	}

}
