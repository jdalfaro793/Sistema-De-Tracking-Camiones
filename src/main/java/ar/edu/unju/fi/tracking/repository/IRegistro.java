package ar.edu.unju.fi.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tracking.model.Registro;

@Repository
public interface IRegistro extends JpaRepository<Registro, Long>{
	
	@Query("from Registro e order by e.detalleLugarRegistro")
	public List<Registro> obtenerRegistros();
}
