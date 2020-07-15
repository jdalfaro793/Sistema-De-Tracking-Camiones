package ar.edu.unju.fi.tracking.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tracking.model.Registro;

import ar.edu.unju.fi.tracking.model.Tripulante;
import ar.edu.unju.fi.tracking.model.Vehiculo;
import ar.edu.unju.fi.tracking.repository.IRegistro;

/**
 * Clase que va a implementar la interface IRegistroService
 *
 */
@Service
public class RegistroServiceImp implements IRegistroService {

	/*
	 * Inyeccion de la interfaz del repositorio IRegistro
	 */
	@Autowired
	IRegistro registroImp;

	/**
	 * Metodo que permite guardar un registro en el gestor MYSQL, recibe por
	 * parametro un objeto de tipo Registro a guardar
	 */
	@Override
	public void guardarRegistro(Registro registro) {
		// TODO Auto-generated method stub
		registro.setFechaHora(LocalDateTime.now());
		registroImp.save(registro);
	}

	/**
	 * Metodo que permite listar los registros encontrados
	 */
	@Override
	public List<Registro> obtenerRegistros() {
		// TODO Auto-generated method stub
		return registroImp.obtenerRegistros();
	}

	/**
	 * Metodo que permite obtener un registro para su modificacion, recibe por
	 * parametro su id
	 */
	@Override
	public Optional<Registro> obtenerUnRegistro(Long id) {
		// TODO Auto-generated method stub
		Optional<Registro> registro = registroImp.findById(id);
		return registro;
	}

	/**
	 * Metodo que permite eliminar un registro, recibe por parametro su id
	 */
	@Override
	public void eliminarRegistro(Long id) {
		// TODO Auto-generated method stub
		registroImp.deleteById(id);

	}

	// ---- CONSULTAS

	// Consulta 2

	/**
	 * Implementacion de metodo de consulta para hacer la busqueda de tripulante por
	 * orden de fecha y hora recibe un objeto de tipo Tripulante
	 */
	@Override
	public List<Registro> buscarPorTripulanteOrdenFechaHora(Tripulante tripulante) {
		// TODO Auto-generated method stub
		return registroImp.findAllByTripulanteOrderByFechaHora(tripulante);
	}

	// Consulta 3

	/**
	 * Implementacion de metodo de consulta para hacer la busqueda del atributo
	 * patente por orden de fecha y hora recibe un objeto de tipo Vehiculo
	 */
	@Override
	public List<Registro> buscarPorPatenteOrdenFechaHora(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		return registroImp.findAllByVehiculoOrderByFechaHora(vehiculo);
	}

}
