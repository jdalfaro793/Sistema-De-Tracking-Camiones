package ar.edu.unju.fi.tracking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tracking.model.Localidad;
import ar.edu.unju.fi.tracking.repository.ILocalidad;

/**
 * Clase que va a implementar la interface ILocalidadService
 *
 */
@Service
public class LocalidadServiceImp implements ILocalidadService {

	/*
	 * Inyeccion de la interfaz del repositorio ILocalidad
	 */
	@Autowired
	ILocalidad localidadImp;

	/**
	 * Metodo que permite guardar una localidad en el gestor MYSQL, recibe por
	 * parametro un objeto de tipo Localidad a guardar
	 */
	@Override
	public void guardarLocalidad(Localidad localidad) {
		localidadImp.save(localidad);

	}

	/**
	 * Metodo que permite listar las localides encontradas
	 */
	@Override
	public List<Localidad> obtenerLocalidades() {

		return localidadImp.obtenerLocalidades();
	}

	/**
	 * Metodo que permite obtener una localidad para su modificacion, recibe por
	 * parametro su id
	 */
	@Override
	public Optional<Localidad> obtenerUnaLocalidad(Long id) {
		Optional<Localidad> localidad = localidadImp.findById(id);
		return localidad;
	}

	/**
	 * Metodo que permite eliminar una localidad, recibe por parametro su id
	 */
	@Override
	public void eliminarLocalidad(Long id) {
		localidadImp.deleteById(id);

	}

}
