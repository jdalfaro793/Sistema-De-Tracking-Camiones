package ar.edu.unju.fi.tracking.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tracking.model.Tripulante;


public interface ITripulanteService {

	public void guardarTripulante(Tripulante tripulante);
	
	public List<Tripulante> obtenerTripulantes();
	
	
	// metodo para editar un usuario
	public Optional<Tripulante> obtenerUnTripulante(Long id);
	
	// metodo para eliminar un usuario
	public void eliminarTripulante(Long id);
	
	//probando
	public void guardarTripulanteEncontrado(Tripulante tripulante);
	public Tripulante buscarTripulante (String documento) throws Exception;
	public List<Tripulante> buscarTodosTripulantes();
	public void borrarTodosTripulantes();	
		
}
