package ar.edu.unju.fi.tracking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unju.fi.tracking.model.Tripulante;

public interface ITripulante extends JpaRepository<Tripulante, Long> {

	// Permite ordenar la tabla por atributo nombre Real
	@Query("from Tripulante e order by e.nombre")
	public List<Tripulante> obtenerTripulantes();

	// prueba
	public Optional<Tripulante> findByDocumento(String documento);

	Tripulante findAllByDocumento(String documento);
}
