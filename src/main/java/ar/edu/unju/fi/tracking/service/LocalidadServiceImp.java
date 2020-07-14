package ar.edu.unju.fi.tracking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tracking.model.Localidad;
import ar.edu.unju.fi.tracking.repository.ILocalidad;

@Service
public class LocalidadServiceImp implements ILocalidadService{

	@Autowired
	ILocalidad localidadImp;
	
	@Override
	public void guardarLocalidad(Localidad localidad) {
		localidadImp.save(localidad);
		
	}

	@Override
	public List<Localidad> obtenerLocalidades() {
		
		return localidadImp.obtenerLocalidades();
	}

	@Override
	public Optional<Localidad> obtenerUnaLocalidad(Long id) {
		Optional<Localidad> localidad = localidadImp.findById(id);
		return localidad;
	}

	@Override
	public void eliminarLocalidad(Long id) {
		localidadImp.deleteById(id);
		
	}


}
