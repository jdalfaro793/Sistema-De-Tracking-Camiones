package ar.edu.unju.fi.tracking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tracking.model.Tripulante;
import ar.edu.unju.fi.tracking.repository.ITripulante;

/**
 * Clase que va a implementar la interface ITripulanteService
 *
 */
@Service
public class TripulanteServiceImp implements ITripulanteService {

	/*
	 * Inyeccion de la interfaz del repositorio ITripulante
	 */
	@Autowired
	ITripulante tripulanteImp;
	/**
	 * Atributo auxiliar de la clase que crea una lista de tipo tripulante sobre la
	 * cual guardar una copia de los datos
	 */
	private List<Tripulante> listadoAuxiliar = new ArrayList<>();

	/**
	 * Metodo que permite guardar un tripulante en el gestor MYSQL, recibe por
	 * parametro un objeto de tipo Tripulante a guardar
	 */
	@Override
	public void guardarTripulante(Tripulante tripulante) {
		tripulanteImp.save(tripulante);
		// Agregamos una copia de los datos que llegan al metodo para guardarlos en el
		// atributo auxiliar
		listadoAuxiliar.add(tripulante);
	}

	/**
	 * Metodo que permite listar los Tripulantes encontrados
	 */
	@Override
	public List<Tripulante> obtenerTripulantes() {
		return tripulanteImp.obtenerTripulantes();
	}

	/**
	 * Metodo que permite obtener un tripulante, para su modificacion. Recibe un
	 * atributo de tipo id
	 */
	@Override
	public Optional<Tripulante> obtenerUnTripulante(Long id) {
		Optional<Tripulante> tripulante = tripulanteImp.findById(id);
		return tripulante;
	}

	/**
	 * Metodo para eliminar un tripulante, recibe un parametro de tipo id para su
	 * localizacion
	 */
	@Override
	public void eliminarTripulante(Long id) {
		tripulanteImp.deleteById(id);

	}

	/**
	 * Metodo para guardar un objeto de tipo Tripulante en el atributo auxiliar de
	 * la clase
	 */
	@Override
	public void guardarTripulanteEncontrado(Tripulante tripulante) {
		// TODO Auto-generated method stub
		listadoAuxiliar.add(tripulante);
	}

	/**
	 * Metodo que permite buscar un Tripulante, recibe por parametro su documento en
	 * caso de excepcion devuelve una leyenda, "El tripulante no existe"
	 */
	@Override
	public Tripulante buscarTripulante(String documento) throws Exception {
		// TODO Auto-generated method stub
		return tripulanteImp.findByDocumento(documento).orElseThrow(() -> new Exception("El tripulante no existe"));
	}

	/**
	 * Metodo que devuelve el listado auxiliar acumulado, que tiene por valor los
	 * tripulantes encontrados
	 */
	@Override
	public List<Tripulante> buscarTodosTripulantes() {
		// TODO Auto-generated method stub
		return listadoAuxiliar;
	}

	/**
	 * Metodo para limpiar la clase auxiliar, y borrar los Tripulantes guardados
	 */
	@Override
	public void borrarTodosTripulantes() {
		// TODO Auto-generated method stub
		listadoAuxiliar = new ArrayList<>();

	}

	/**
	 * Metodo para hacer una consulta de tripulante por DNI. Recibe un documento por
	 * parametro a buscar
	 */
	public Tripulante buscarTripulanteDNI(String documento) {
		// TODO Auto-generated method stub
		return tripulanteImp.findAllByDocumento(documento);
	}

}
