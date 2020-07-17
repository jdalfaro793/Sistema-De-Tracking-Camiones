package ar.edu.unju.fi.tracking.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import ar.edu.unju.fi.tracking.model.Vehiculo;

/**
 * Interface Vehiculo nos permite acceder a los vehiculos guardados en la BD
 * @author RODOLFO 
 *
 */
@Repository
public interface IVehiculo extends JpaRepository<Vehiculo, Long>{
	
	/**
	 * Metodo que permite obtener un listado de los vehiculos guardados
	 * @return listado de vehiculos
	 */
	//Permite ordenar la tabla por atributo 
	@Query("from Vehiculo e order by e.patente")
	public List<Vehiculo> obtenerVehiculos();
	/**
	 * Metodo que permite buscar a un vehiculo por su patente
	 * @param patente
	 * @return vehiculo con sus atributos
	 */
	//prueba
	public Vehiculo findByPatente(String patente);
	
	//Consulta
	//public Optional<Vehiculo> findByPatente(String patente);
	/**
	 * Metodo que permite buscar la patente de un vehiculo mediante su nombre
	 * @param nombre
	 * @return vehiculo encontrado
	 */
	Vehiculo findAllByPatente(String nombre);
}

