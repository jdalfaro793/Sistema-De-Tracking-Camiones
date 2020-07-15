package ar.edu.unju.fi.tracking.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tracking.model.Localidad;

public interface ILocalidadService {

	
public void guardarLocalidad(Localidad localidad);
	
	public List<Localidad> obtenerLocalidades();
	
	
	// metodo para editar un usuario
	public Optional<Localidad> obtenerUnaLocalidad(Long id);
	
	// metodo para eliminar un usuario
	public void eliminarLocalidad(Long id);
	
	

	
}
