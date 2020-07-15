package ar.edu.unju.fi.tracking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tracking.model.Vehiculo;

@Service
public interface IVehiculoService {

	public void guardarVehiculo(Vehiculo vehiculo);

	public List<Vehiculo> obtenerVehiculos();

	// metodo para editar
	public Optional<Vehiculo> obtenerUnVehiculo(Long id);

	// metodo para eliminar
	public void eliminarVehiculo(Long id);

	// prueba
	public Optional<Vehiculo> obtenerUnVehiculo(String patente);

	public Vehiculo buscarVehiculo(String patente) throws Exception;

	
	public void guardarVehiculoEncontrado(Vehiculo vehiculo);
	
	//consulta
	public Vehiculo buscarPatentePorNombre(String patente);
}
