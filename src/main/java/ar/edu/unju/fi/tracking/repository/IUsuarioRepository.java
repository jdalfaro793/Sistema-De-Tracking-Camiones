package ar.edu.unju.fi.tracking.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tracking.model.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario, Long> {
	public Optional<Usuario> findByNombreUsuario(String nombreUsuario);
}
