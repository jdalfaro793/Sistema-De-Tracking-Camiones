package ar.edu.unju.fi;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * Clase que permite controlar el exito del login de un usuario de forma que se
 * rediriga de forma exitosa
 * 
 * @author Josue Dario Alfaro
 *
 */
@Component
public class AutenticacionSuccesHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	/**
	 * Sobrescritura del metodo onAuthenticationSuccess que recibe una peticion, una
	 * respuesta y una autenticacion que son los roles del usuario
	 * 
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// se definen 3 variables boolean que se usan para definir que tipo de usuario
		// se ha logeado
		boolean userBD = false;
		boolean userConsultor = false;
		boolean userRegistrador = false;

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		
		// se modifican los boolean segun el rol del usuario recuperado
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("ADMIN")) {
				userBD = true;
				break;
			} else {
				if (grantedAuthority.getAuthority().equals("CONSULTOR")) {
					userConsultor = true;
					break;
				} else {
					userRegistrador = true;
					break;
				}
			}
		}

		//Se redirige a una pagina relacionada al rol del usuario
		if (userBD) {
			redirectStrategy.sendRedirect(request, response, "/admin");
		} else {
			if (userConsultor) {
				redirectStrategy.sendRedirect(request, response, "/consultor");
			} else {
				if (userRegistrador) {
					redirectStrategy.sendRedirect(request, response, "/registrador");
				} else {
					throw new IllegalStateException();
				}
			}
		}

	}

}
