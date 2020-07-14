package ar.edu.unju.fi.tracking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tracking.model.Vehiculo;
import ar.edu.unju.fi.tracking.repository.IVehiculo;

@Service
public class VehiculoServiceImp implements IVehiculoService{

	@Autowired
	IVehiculo vehiculoImp;
	
	private List<Vehiculo> listadoAuxiliar = new ArrayList<>();
	
	
	// guardar
	@Override
	public void guardarVehiculo(Vehiculo vehiculo) {
		vehiculoImp.save(vehiculo);
		
	}
	
	//listar
	@Override
	public List<Vehiculo> obtenerVehiculos() {
		
		return vehiculoImp.obtenerVehiculos();
	}
	//editar
	@Override
	public Optional<Vehiculo> obtenerUnVehiculo(Long id) {
		Optional<Vehiculo> vehiculo = vehiculoImp.findById(id);
		return vehiculo;
	}
	
	//eliminar
	@Override
	public void eliminarVehiculo(Long id) {
		vehiculoImp.deleteById(id);
		
	}
	
	//prueba
	/*
	 * @Override public Optional<Vehiculo> obtenerUnVehiculo(String patente) { //
	 * TODO Auto-generated method stub Optional<Vehiculo> vehiculos =
	 * vehiculoImp.findByPatente(patente); return vehiculos; }
	 */

	@Override
	public Vehiculo buscarVehiculo(String patente) throws Exception {
		// TODO Auto-generated method stub
		return vehiculoImp.findByPatente(patente);
	}

	@Override
	public Optional<Vehiculo> obtenerUnVehiculo(String patente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardarVehiculoEncontrado(Vehiculo vehiculo) {
		listadoAuxiliar.add(vehiculo);
		
	}
	
	
	
	

}
