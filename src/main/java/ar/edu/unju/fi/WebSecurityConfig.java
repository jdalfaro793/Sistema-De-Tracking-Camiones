package ar.edu.unju.fi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ar.edu.unju.fi.tracking.service.LoginUsuarioServiceImp;

/**
 * Configuracion de las opciones por defecto del proyeto al extender WebSecurityConfigurerAdapter
 * Se determinara que acciones permitidas y seguras. 
 * 
 */

/**
 * @Configuration indica que es un archivo de configuracion.
 * 
 * @EnableWebSecurityhabilita la opcion de websecurity
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * Se inyecta la clase AutenticacionSuccessHandler que determinara la
	 * redireccion que cada usuario tendra segun su rol
	 */
	@Autowired
	private AutenticacionSuccesHandler autenticacion;

	/**
	 * Se definen las rutas de aquellos elementos que se podran utilizar, sin eso no
	 * podran usarse y seran ignorados en el proyecto
	 */
	String[] resources = new String[] { "/include/**", "/css/**", "/icons/**", "/img/**", "/js/**", "/layer/**",
			"/webjars/**" };

	/**
	 * SE SOBRE ESCRIBE LA CONFIGURACION DE HTTP QUE VIENE POR DEFECTO, capturando
	 * errores en la exception de ser necesario
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(resources).permitAll().antMatchers("/", "/login").permitAll()
				// SE DEFINEN LAS PAGINAS AUTORIZADAS SEGUN EL ROL DEL USUARIO

				.antMatchers("/nuevoUsuario").hasAuthority("ADMIN")
				.antMatchers("/nuevoLocalidad").hasAuthority("ADMIN")
				.antMatchers("/usuarios").hasAuthority("ADMIN")
				.antMatchers("/localidades").hasAuthority("ADMIN")
				.antMatchers("/admin").hasAuthority("ADMIN")
				.antMatchers("/tripulantes").hasAuthority("ADMIN")
				.antMatchers("/vehiculos").hasAuthority("ADMIN")
				.antMatchers("/nuevoTripulante").hasAuthority("ADMIN")
				.antMatchers("/nuevoVehiculo").hasAuthority("ADMIN")

				

				.antMatchers("/nuevoRegistro").hasAuthority("REGISTRADOR")
				.antMatchers("/registros").hasAuthority("REGISTRADOR")
				.antMatchers("/registrador").hasAuthority("REGISTRADOR")

				.antMatchers("/ingresarLocalidadYFecha").hasAuthority("CONSULTOR")
				.antMatchers("/buscarPorLocalidadYRangoFechaHora").hasAuthority("CONSULTOR")
				.antMatchers("/mostrarTripulante/{id}").hasAuthority("CONSULTOR")
				.antMatchers("/ingresarTripulante").hasAuthority("CONSULTOR")
				.antMatchers("/ingresarPatente").hasAuthority("CONSULTOR")
				.antMatchers("/consultor").hasAuthority("CONSULTOR")

				.anyRequest().authenticated().and()

				.formLogin().loginPage("/login").permitAll().successHandler(autenticacion)

				.failureUrl("/login?error=true").usernameParameter("nombreusuario").passwordParameter("password").and()
				.logout().permitAll().and().exceptionHandling().accessDeniedPage("/sinPermisos");

		// http.csrf().disable();

	}

	// INSTANCIAMOS UNA VARIABLE DE TIPO BCryptPasswordEncoder PARA ENCRIPTAR LA
	// CLAVE POR METODO MATEMATICO
	BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * DEFINIMOS EL NIVEL DE ENCRIPTACION QUE QUEREMOS ASIGNAR A LA VARIABLE
	 * 
	 * @return el nivel de encriptacion asignado a la variable, en este caso nivel
	 *         10
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
		return bCryptPasswordEncoder;
	}

	/**
	 * Se hace una inyeccion del servicioLoginUsuarioServiceImp que autentica a el
	 * usuario
	 */
	@Autowired
	LoginUsuarioServiceImp userDetailsService;

	
	
	//metodo que recibe el managerbuild que recupera la informacion del usuario que desea logearse
	//La configuracion global es posbile utilizando el servicio especial loginUsuarioServiceImp y el bean BCryptPasswordEncoder
	
	/**
	 * Metodo que usara el AuthenticationManagerBuilder que recupera la informacion del usuario guardado
	 * userDetailsService recuperara la informacion del usuario que quiere entrar y crea un usuario UserDetail
	 * Finalmente los datos recuperados con usados para la configuracion global
	 * @param AuthenticationManager
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

}