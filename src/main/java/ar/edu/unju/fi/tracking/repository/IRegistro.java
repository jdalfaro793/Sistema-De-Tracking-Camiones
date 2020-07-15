package ar.edu.unju.fi.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tracking.model.Registro;
import ar.edu.unju.fi.tracking.model.Tripulante;
import ar.edu.unju.fi.tracking.model.Vehiculo;

@Repository
public interface IRegistro extends JpaRepository<Registro, Long>{
	
	@Query("from Registro e order by e.detalleLugarRegistro")
	public List<Registro> obtenerRegistros();
	
	
	//Consulta1
	//public List<Registro>findAllByFechaBetweenAndLocalidadOrderByFecha(LocalDateTime fechaDesde, LocalDateTime fechaHasta, Localidad localidad);

	public List<Registro> findAllByVehiculoOrderByFechaHora(Vehiculo vehiculo);


	public List<Registro> findAllByTripulanteOrderByFechaHora(Tripulante tripulante);

}


