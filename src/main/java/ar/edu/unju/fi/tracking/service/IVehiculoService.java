package ar.edu.unju.fi.tracking.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tracking.model.Vehiculo;

/**
 * Interface que permite desarrollar la logica del proyecto. Permite conectarse
 * con los datos almacenados en algun repositorio para su modificacion,
 * visualizacion o busqueda
 * 
 */
public interface IVehiculoService {

	/**
	 * Metodo que permite guardar un Vehiculo en el gestor de Base de datos
	 * 
	 * @param Vehiculo objeto de tipo Vehiculo que se desea guardar
	 */
	public void guardarVehiculo(Vehiculo vehiculo);

	/**
	 * Metodo que permite listar los Vehiculos almacenados
	 * 
	 * @return la lista de Vehiculos encontrados
	 */
	public List<Vehiculo> obtenerVehiculos();

	/**
	 * Metodo para hacer una busqueda de Vehiculo por su id ingresado por parametro
	 * 
	 * @param id de Vehiculo a buscar
	 * @return Vehiculo encontrado
	 */
	public Optional<Vehiculo> obtenerUnVehiculo(Long id);

	/**
	 * Metodo para hacer una eliminacion de un Vehiculo almacenado en la Base de
	 * datos
	 * 
	 * @param id de Vehiculo a eliminar
	 */
	public void eliminarVehiculo(Long id);

	/**
	 * Metodo para hacer una busqueda de Vehiculo por su patente ingresada por
	 * parametro
	 * 
	 * @param patente de Vehiculo a buscar
	 * @return Vehiculo encontrado
	 */
	public Optional<Vehiculo> obtenerUnVehiculo(String patente);

	/**
	 * Metodo para hacer una busqueda de un Vehiculo por su atributo de tipo String
	 * y nombre patente
	 * 
	 * @param patente atributo por el que se buscara
	 * @return El Vehiculo encontrado
	 * @throws Exception si hay algun error
	 */
	public Vehiculo buscarVehiculo(String patente) throws Exception;

	/**
	 * Metodo que permite guardar un Vehiculo encontrado, recibe un objeto de tipo
	 * Vehiculo
	 * 
	 * @param Vehiculo objeto de tipo Vehiculo, a guardar
	 */
	public void guardarVehiculoEncontrado(Vehiculo vehiculo);

	// --------- METODOSS PARA LAS LLAMADAS A CONSULTAS --------

	/**
	 * Metodo para hacer una consulta de los vehiculos por patente, recibe un
	 * atributo de tipo patente
	 * 
	 * @param patente
	 * @return Lista de los Vehiculos donde se encontro coincidencias
	 */
	public Vehiculo buscarPatentePorNombre(String patente);
}
