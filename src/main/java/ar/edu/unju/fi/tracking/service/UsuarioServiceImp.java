package ar.edu.unju.fi.tracking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tracking.model.Usuario;
import ar.edu.unju.fi.tracking.repository.IUsuario;

/**
 * Clase que va a implementar la interface IUsuarioService
 *
 */

@Service
public class UsuarioServiceImp implements IUsuarioService {

	/*
	 * Inyeccion de la interfaz del repositorio IUsuario
	 */
	@Autowired
	IUsuario usuarioImp;

	/**
	 * Metodo para guardar un usuario en la base de datos, recibe un objeto de tipo
	 * Usuario
	 */
	@Override
	public void guardarUsuario(Usuario usuario) {
		// variable que almacena la contraseña del usuario
		String pw = usuario.getPassword();
		// declaracion de objeto encriptador de contraseña, de tipo
		// BCryptPasswordEncoder
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		// Asignacion de la contraseña asignada por el usuario. Pero con su respectivo
		// encriptado para ser guardada en la base de datos
		usuario.setPassword(bCryptPasswordEncoder.encode(pw));

		usuarioImp.save(usuario);
	}

	/**
	 * Metodo para listar los Usuarios encontrados en la base de datos
	 */
	@Override
	public List<Usuario> obtenerUsuarios() {

		return usuarioImp.obtenerUsuarios();
	}

	/**
	 * Metodo que permite obtener un usuario, para su modificacion, recibe un
	 * parametro de tipo id, lo busca y retorna el usuario
	 */
	@Override
	public Optional<Usuario> obtenerUnUsuario(Long id) {
		// va hasta la BD busca el usuario con el ID correspondiente y lo retorna
		Optional<Usuario> usuario = usuarioImp.findById(id);
		return usuario;
	}

	/**
	 * Metodo para eliminar el usuario, recibe un parametro de tipo id, lo busca y
	 * elimina el usuario de ser encontrado
	 */
	@Override
	public void eliminarUsuario(Long id) {
		usuarioImp.deleteById(id);

	}

}
