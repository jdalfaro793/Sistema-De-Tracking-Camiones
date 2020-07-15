package ar.edu.unju.fi.tracking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tracking.model.Tripulante;
import ar.edu.unju.fi.tracking.repository.ITripulante;

@Service
public class TripulanteServiceImp implements ITripulanteService{

	@Autowired
	ITripulante tripulanteImp;
	//probando
	private List<Tripulante> listadoAuxiliar = new ArrayList<>();
	
	
	@Override
	public void guardarTripulante(Tripulante tripulante) {
		tripulanteImp.save(tripulante);
		//probando
		listadoAuxiliar.add(tripulante);
				
	}

	@Override
	public List<Tripulante> obtenerTripulantes() {
		
		return tripulanteImp.obtenerTripulantes();
	}

	@Override
	public Optional<Tripulante> obtenerUnTripulante(Long id) {
		Optional<Tripulante> tripulante = tripulanteImp.findById(id);
		return tripulante;
	}

	@Override
	public void eliminarTripulante(Long id) {
		tripulanteImp.deleteById(id);
		
	}
	
    // probando
	@Override
	public void guardarTripulanteEncontrado(Tripulante tripulante) {
		// TODO Auto-generated method stub
		listadoAuxiliar.add(tripulante);		
	}

	@Override
	public Tripulante buscarTripulante(String documento) throws Exception {
		// TODO Auto-generated method stub
		return tripulanteImp.findByDocumento(documento).orElseThrow(()-> new Exception("El Autor no Existe"));
	}

	@Override
	public List<Tripulante> buscarTodosTripulantes() {
		// TODO Auto-generated method stub
		return listadoAuxiliar;
	}

	@Override
	public void borrarTodosTripulantes() {
		// TODO Auto-generated method stub
		listadoAuxiliar = new ArrayList<>();
		
	}

	public Tripulante buscarTripulanteDNI(String documento) {
		// TODO Auto-generated method stub
		return tripulanteImp.findAllByDocumento(documento);
	}
 
	
	
}
