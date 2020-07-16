package ar.edu.unju.fi.tracking.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tracking.model.Localidad;
import ar.edu.unju.fi.tracking.model.Registro;
import ar.edu.unju.fi.tracking.model.Tripulante;
import ar.edu.unju.fi.tracking.model.Vehiculo;

/**
 * Interface Registro, permite acceder a los datos de los registros
 * guardados en la BD
 * 
 * @author RODOLFO
 *
 */
@Repository
public interface IRegistro extends JpaRepository<Registro, Long>{
	
	/**
	 * Metodo que permite obtener un listado de todos los registros
	 * @return registros encontrados en una lista
	 */
	@Query("from Registro e order by e.detalleLugarRegistro")
	public List<Registro> obtenerRegistros();
	
	
	//Consulta1
	//public List<Registro>findAllByFechaBetweenAndLocalidadOrderByFecha(LocalDateTime fechaDesde, LocalDateTime fechaHasta, Localidad localidad);
	
	/**
	 * Metodo que permite buscar los vehiculos por orden de fecha
	 * @param vehiculo
	 * @return una lista de registros ordenada por fecha
	 */
	public List<Registro> findAllByVehiculoOrderByFechaHora(Vehiculo vehiculo);

	/**
	 * Metodo que permite buscar los tripulantes por orden de fecha
	 * @param tripulante
	 * @return una lista de registros ordenada por fecha
	 */
	public List<Registro> findAllByTripulanteOrderByFechaHora(Tripulante tripulante);

	public List<Registro> findAllByFechaHoraBetweenAndLocalidadOrderByFechaHora(LocalDateTime fechaDesde, LocalDateTime fechaHasta, Localidad localidad);

}


