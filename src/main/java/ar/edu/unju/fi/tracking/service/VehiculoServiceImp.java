package ar.edu.unju.fi.tracking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tracking.model.Vehiculo;
import ar.edu.unju.fi.tracking.repository.IVehiculo;

/**
 * Clase que va a implementar la interface IVehiculoService
 *
 */
@Service
public class VehiculoServiceImp implements IVehiculoService {

	/*
	 * Inyeccion de la interfaz del repositorio IVehiculo
	 */
	@Autowired
	IVehiculo vehiculoImp;

	/**
	 * Atributo auxiliar de la clase que crea una lista de tipo vehiculo sobre la
	 * cual guardar una copia de los datos
	 */
	private List<Vehiculo> listadoAuxiliar = new ArrayList<>();

	/**
	 * Metodo que permite guardar el vehiculo en la base de datos, recibe un objeto
	 * de tipo vehiculo
	 */
	@Override
	public void guardarVehiculo(Vehiculo vehiculo) {
		vehiculoImp.save(vehiculo);

	}

	/**
	 * Metodo que permite listar todos los vehiculos encontrados en la base de datos
	 */
	@Override
	public List<Vehiculo> obtenerVehiculos() {

		return vehiculoImp.obtenerVehiculos();
	}

	/**
	 * Metodo que permite obtener un vehiculo para su modificacion, recibe un
	 * parametro de tipo id
	 */
	@Override
	public Optional<Vehiculo> obtenerUnVehiculo(Long id) {
		Optional<Vehiculo> vehiculo = vehiculoImp.findById(id);
		return vehiculo;
	}

	/**
	 * Metodo para eliminar un Vehiculo, recibe un parametro de tipo id para su
	 * localizacion
	 */
	@Override
	public void eliminarVehiculo(Long id) {
		vehiculoImp.deleteById(id);

	}

	/**
	 * Metodo que permite buscar un Vehiculo, recibe por parametro su patente.
	 */
	@Override
	public Vehiculo buscarVehiculo(String patente) throws Exception {
		// TODO Auto-generated method stub return vehiculoImp.findByPatente(patente);
		return vehiculoImp.findByPatente(patente);
	}

	/**
	 * Metodo para guardar un objeto de tipo Vehiculo en el atributo auxiliar de la
	 * clase
	 */
	@Override
	public void guardarVehiculoEncontrado(Vehiculo vehiculo) {
		listadoAuxiliar.add(vehiculo);

	}

	/**
	 * Metodo declarado sin uso actualmente, retorna null.
	 */
	@Override
	public Optional<Vehiculo> obtenerUnVehiculo(String patente) {
		// TODO Auto-generated method stub
		return null;
	}

	// Consulta

	/**
	 * Metodo que permite consultar un Vehiculo por su patente. Recibe un parametro
	 * de tipo patente
	 */
	@Override
	public Vehiculo buscarPatentePorNombre(String patente) {
		// TODO Auto-generated method stub
		return vehiculoImp.findAllByPatente(patente);
	}

}
