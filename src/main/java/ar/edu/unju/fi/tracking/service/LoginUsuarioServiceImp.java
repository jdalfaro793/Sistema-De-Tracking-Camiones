package ar.edu.unju.fi.tracking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tracking.model.Usuario;
import ar.edu.unju.fi.tracking.repository.IUsuarioRepository;

/**
 * Clase que va a implementar la interface especial UserDetailsService
 *
 */
@Service
public class LoginUsuarioServiceImp implements UserDetailsService {

	/*
	 * Inyeccion de la interfaz del repositorio IUsuarioRepository
	 */
	@Autowired
	IUsuarioRepository iUsuario;

	/**
	 * Metodo de tipo UserDetail, que recibe un parametro de tipo nombreUsuario y
	 * hace la verificacion, de campos, si se encuentra, retorna el nombre, password
	 * y tipo de usuario, de lo contrario una leyenda de login invalido
	 */
	@Override
	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
		// declaracion de variable auxiliar que buscara el usuario pasado por parametro
		Usuario usuarioEncontrado = iUsuario.findByNombreUsuario(nombreUsuario)
				.orElseThrow(() -> new UsernameNotFoundException("Login invalido"));
		// declaracion de variable de tipo GrantedAuthority que guardara el campo de
		// tipo
		List<GrantedAuthority> tipos = new ArrayList<>();
		// verificacion del usuario encontrado, y del tipo de usuario que es para
		// enviarlo al loggin
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuarioEncontrado.getTipoUsuario());
		// se le asigna a la variable tipos el resultado de la verificacion.
		tipos.add(grantedAuthority);
		// declaracion de variable user, de tipo UserDetails. que contendra los campos
		// requeridos para hacer el loggeo final.
		UserDetails user = (UserDetails) new User(nombreUsuario, usuarioEncontrado.getPassword(), tipos);
		return user;
	}
}
