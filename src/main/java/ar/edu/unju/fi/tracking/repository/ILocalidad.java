package ar.edu.unju.fi.tracking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tracking.model.Localidad;

/**
 * Interface que nos va a permitir interactuar con la BD
 * y acceder a todas las localidades almacenadas
 *
 */

@Repository
public interface ILocalidad extends JpaRepository<Localidad, Long>{

	/**
	 * Metodo que permite listar todas las localidades almacenadas
	 * @return listado de localidades
	 */
	//Permite ordenar la tabla por atributo nombre Real
		@Query("from Localidad e order by e.nombre")
		public List<Localidad> obtenerLocalidades();
		
		public Optional<Localidad> findByNombre (String nombre);
}
