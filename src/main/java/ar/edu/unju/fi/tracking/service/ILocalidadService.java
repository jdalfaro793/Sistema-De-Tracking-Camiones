package ar.edu.unju.fi.tracking.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tracking.model.Localidad;

/**
 * Interface que permite desarrollar la logica del proyecto. Permite conectarse
 * con los datos almacenados en algun repositorio para su modificacion,
 * visualizacion o busqueda
 * 
 */

public interface ILocalidadService {

	/**
	 * Metodo que permite guardar una localidad en el gestor de Base de datos
	 * 
	 * @param localidad objeto de tipo localidad que se desea guardar
	 */
	public void guardarLocalidad(Localidad localidad);

	/**
	 * Metodo que permite listar las localidades almacenadas
	 * 
	 * @return la lista de localidades encontradas
	 */
	public List<Localidad> obtenerLocalidades();

	/**
	 * Metodo para hacer una busqueda de localidad por su id ingresado por parametro
	 * 
	 * @param id de localidad a buscar
	 * @return localidad encontrada
	 */
	public Optional<Localidad> obtenerUnaLocalidad(Long id);

	/**
	 * Metodo para hacer una eliminacion de la localidad almacenada en la base de
	 * datos
	 * 
	 * @param id de localidad a eliminar
	 */
	public void eliminarLocalidad(Long id);

	public Localidad buscarNombreLocalidad(String nombre) throws Exception;

}
