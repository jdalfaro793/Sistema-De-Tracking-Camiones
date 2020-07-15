package ar.edu.unju.fi.tracking.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tracking.model.Usuario;
/**
 * Interface UsuarioRepository permite acceder a los roles de usuario
 */
public interface IUsuarioRepository extends CrudRepository<Usuario, Long> {
	
	/**
	 * Metodo que permite buscar al usuario por su nombre de usuario 
	 * para poder loguearse
	 * @param nombreUsuario
	 * @return nombre de usuario
	 */
	public Optional<Usuario> findByNombreUsuario(String nombreUsuario);
}
