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

@Service
public class LoginUsuarioServiceImp implements UserDetailsService {

	@Autowired
	IUsuarioRepository iUsuario;

	@Override
	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {

		Usuario usuarioEncontrado = iUsuario.findByNombreUsuario(nombreUsuario)
				.orElseThrow(() -> new UsernameNotFoundException("Login invalido"));

		List<GrantedAuthority> tipos = new ArrayList<>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuarioEncontrado.getTipoUsuario());
		tipos.add(grantedAuthority);

		UserDetails user = (UserDetails) new User(nombreUsuario, usuarioEncontrado.getPassword(), tipos);
		return user;
	}
}
