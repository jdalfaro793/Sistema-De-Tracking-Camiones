package ar.edu.unju.fi.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import ar.edu.unju.fi.tracking.model.Vehiculo;


@Repository
public interface IVehiculo extends JpaRepository<Vehiculo, Long>{
	//Permite ordenar la tabla por atributo 
	@Query("from Vehiculo e order by e.patente")
	public List<Vehiculo> obtenerVehiculos();
	
	//prueba
	public Vehiculo findByPatente(String patente);
	
}

