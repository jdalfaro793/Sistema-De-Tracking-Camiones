package ar.edu.unju.fi.tracking.service;

import java.time.LocalDateTime;
import java.util.List;

import java.util.Optional;

import ar.edu.unju.fi.tracking.model.Localidad;
import ar.edu.unju.fi.tracking.model.Registro;
import ar.edu.unju.fi.tracking.model.Tripulante;
import ar.edu.unju.fi.tracking.model.Vehiculo;

/**
 * Interface que permite desarrollar la logica del proyecto. Permite conectarse
 * con los datos almacenados en algun repositorio para su modificacion,
 * visualizacion o busqueda
 * 
 */
public interface IRegistroService {

	/**
	 * Metodo que permite guardar un registro en el gestor de Base de datos
	 * 
	 * @param registro objeto de tipo registro que se desea guardar
	 */
	public void guardarRegistro(Registro registro);

	/**
	 * Metodo que permite listar los registros almacenados
	 * 
	 * @return la lista de registros encontrados
	 */
	public List<Registro> obtenerRegistros();

	/**
	 * Metodo para hacer una busqueda de Registro por su id ingresado por parametro
	 * 
	 * @param id de Registro a buscar
	 * @return Registro encontrado
	 */
	public Optional<Registro> obtenerUnRegistro(Long id);

	/**
	 * Metodo para hacer una eliminacion de un Registro almacenado en la Base de
	 * datos
	 * 
	 * @param id de Registro a eliminar
	 */
	public void eliminarRegistro(Long id);

	// -------- METODOS PARA LAS LLAMADAS A CONSULTAS -------- //

	/**
	 * Metodo para hacer una consulta de los registros por patente ordenados por
	 * fecha y hora, recibe un objeto de tipo Vehiculo
	 * 
	 * @param vehiculo
	 * @return Lista de los registros donde se encontro coincidencias
	 */
	public List<Registro> buscarPorPatenteOrdenFechaHora(Vehiculo vehiculo);

	/**
	 * Metodo para hacer una consulta sobre los registros por tripulante ordenados
	 * por fecha y hora, recibe un objeto de tipo Tripulante
	 * 
	 * @param tripulante
	 * @return Lista de los registros donde se encontro coincidencias
	 */
	public List<Registro> buscarPorTripulanteOrdenFechaHora(Tripulante tripulante);

	public List<Registro> buscarRegistrosRangoFechasYLocalidad(LocalDateTime fechaDesde, LocalDateTime fechaHasta,
			Localidad localidad);
}
