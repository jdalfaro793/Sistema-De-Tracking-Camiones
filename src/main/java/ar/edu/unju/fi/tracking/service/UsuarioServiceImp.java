package ar.edu.unju.fi.tracking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tracking.model.Usuario;
import ar.edu.unju.fi.tracking.repository.IUsuario;


@Service
public class UsuarioServiceImp implements IUsuarioService{

	@Autowired
	IUsuario usuarioImp;
	@Override
	public void guardarUsuario(Usuario usuario) {
		
		String pw = usuario.getPassword();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		usuario.setPassword(bCryptPasswordEncoder.encode(pw));
	
		usuarioImp.save(usuario);
	}
	@Override
	public List<Usuario> obtenerUsuarios() {
		
		return usuarioImp.obtenerUsuarios();
	}
	//se implementa el metodo para poder editar un usuario
	@Override
	public Optional<Usuario> obtenerUnUsuario(Long id) {
		// va hasta la BD busca el usuario con el ID correspondiente y lo retorna
		Optional<Usuario> usuario = usuarioImp.findById(id);
		return usuario;
	}
	// se implementa el metodo para eliminar un usuario
	@Override
	public void eliminarUsuario(Long id) {
		usuarioImp.deleteById(id);
		
	}

	

}
