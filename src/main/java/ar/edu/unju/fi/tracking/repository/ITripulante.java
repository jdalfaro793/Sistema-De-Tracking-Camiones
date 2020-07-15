package ar.edu.unju.fi.tracking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tracking.model.Tripulante;
/**
 * Interface Tripulante, permite acceder a los tripulantes almacenados en la BD
 * @author RODOLFO
 *
 */
@Repository
public interface ITripulante extends JpaRepository<Tripulante, Long> {
	
	/**
	 * Metodo que permite obtener todos los tripulantes
	 * @return una lista de tripulantes
	 */
	// Permite ordenar la tabla por atributo nombre Real
	@Query("from Tripulante e order by e.nombre")
	public List<Tripulante> obtenerTripulantes();
	
	/**
	 * Metodo que permite  buscar a un tripulante por su documento
	 * @param documento
	 * @return un listado del tripulante con el DNI buscado
	 */
	// prueba
	public Optional<Tripulante> findByDocumento(String documento);
	
	/**
	 * Metodo que permite buscar un tripulante por su documento
	 * @param documento
	 * @return un tripulante 
	 */
	Tripulante findAllByDocumento(String documento);
}
