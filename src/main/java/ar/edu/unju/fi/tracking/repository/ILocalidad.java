package ar.edu.unju.fi.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unju.fi.tracking.model.Localidad;




public interface ILocalidad extends JpaRepository<Localidad, Long>{

	//Permite ordenar la tabla por atributo nombre Real
		@Query("from Localidad e order by e.nombre")
		public List<Localidad> obtenerLocalidades();
}
