package ar.edu.unju.fi.tracking.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tracking.model.Usuario;

public interface IUsuarioService {

	public void guardarUsuario(Usuario usuario);
	
	public List<Usuario> obtenerUsuarios();
	// metodo para editar un usuario
	public Optional<Usuario> obtenerUnUsuario(Long id);
	// metodo para eliminar un usuario
	public void eliminarUsuario(Long id);
}
