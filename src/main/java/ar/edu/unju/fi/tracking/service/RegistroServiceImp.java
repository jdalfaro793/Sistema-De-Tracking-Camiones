package ar.edu.unju.fi.tracking.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tracking.model.Registro;
import ar.edu.unju.fi.tracking.repository.IRegistro;

@Service
public class RegistroServiceImp implements IRegistroService{

	@Autowired
	IRegistro registroImp;
	
	@Override
	public void guardarRegistro(Registro registro) {
		// TODO Auto-generated method stub
		registro.setFechaHora(LocalDateTime.now());
		registroImp.save(registro);
	}

	@Override
	public List<Registro> obtenerRegistros() {
		// TODO Auto-generated method stub
		return registroImp.obtenerRegistros();
	}

	@Override
	public Optional<Registro> obtenerUnRegistro(Long id) {
		// TODO Auto-generated method stub
		Optional<Registro> registro = registroImp.findById(id);
		return registro;
	}

	@Override
	public void eliminarRegistro(Long id) {
		// TODO Auto-generated method stub
		registroImp.deleteById(id);
		
	}

	
	
	
	

}
