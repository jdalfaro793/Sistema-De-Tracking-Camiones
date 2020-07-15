package ar.edu.unju.fi.tracking.service;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tracking.model.Registro;
import ar.edu.unju.fi.tracking.model.Tripulante;
import ar.edu.unju.fi.tracking.model.Vehiculo;

@Service
public interface IRegistroService {

	public void guardarRegistro(Registro registro);

	public List<Registro> obtenerRegistros();

	// metodo para editar
	public Optional<Registro> obtenerUnRegistro(Long id);

	// metodo para eliminar
	public void eliminarRegistro(Long id);

	// ---- CONSULTAS

	// Consulta 3

	public List<Registro> buscarPorPatenteOrdenFechaHora(Vehiculo vehiculo);

	public List<Registro> buscarPorTripulanteOrdenFechaHora(Tripulante tripulante);
}
