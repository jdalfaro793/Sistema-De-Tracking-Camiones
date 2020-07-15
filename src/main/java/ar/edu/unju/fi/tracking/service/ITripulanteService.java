package ar.edu.unju.fi.tracking.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tracking.model.Tripulante;

/**
 * Interface que permite desarrollar la logica del proyecto. Permite conectarse
 * con los datos almacenados en algun repositorio para su modificacion,
 * visualizacion o busqueda
 * 
 */
public interface ITripulanteService {

	/**
	 * Metodo que permite guardar un tripulante en el gestor de Base de datos
	 * 
	 * @param tripulante objeto de tipo tripulante que se desea guardar
	 */
	public void guardarTripulante(Tripulante tripulante);

	/**
	 * Metodo que permite guardar un Tripulante encontrado, recibe un objeto de tipo
	 * tripulante
	 * 
	 * @param tripulante objeto de tipo tripulante, a guardar
	 */
	public void guardarTripulanteEncontrado(Tripulante tripulante);

	/**
	 * Metodo que permite listar los Tripulantes almacenados
	 * 
	 * @return la lista de Tripulantes encontrados
	 */
	public List<Tripulante> obtenerTripulantes();

	/**
	 * Metodo que permite listar todos los Tripulantes almacenados
	 * 
	 * @return la lista de Tripulantes encontrados
	 */
	public List<Tripulante> buscarTodosTripulantes();

	/**
	 * Metodo para hacer una busqueda de Tripulante por su id ingresado por parametro
	 * 
	 * @param id de Tripulante a buscar
	 * @return Tripulante encontrado
	 */
	public Optional<Tripulante> obtenerUnTripulante(Long id);

	/**
	 * Metodo para hacer una eliminacion de un Tripulante almacenado en la Base de
	 * datos
	 * 
	 * @param id de Tripulante a eliminar
	 */
	public void eliminarTripulante(Long id);

	/**
	 * Metodo que implementara la eliminacion de los tripulantes almacenados en la
	 * Base de datos, no recibe parametros
	 */
	public void borrarTodosTripulantes();

	/**
	 * Metodo para hacer una busqueda de un tripulante por su atributo de tipo
	 * String y nombre documento
	 * 
	 * @param documento atributo por el que se buscara
	 * @return El tripulante encontrado
	 * @throws Exception si hay algun error
	 */
	public Tripulante buscarTripulante(String documento) throws Exception;

}
