package ar.edu.unju.fi.tracking.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

/**
 * Clase Usuario, representa los atributos id, nombreUsuario, password, nombre, apellido, tipoUsuario
 * permite crear un usuario con su respectivo rol
 *
 */
@Component
@Entity
@Table(name ="usuario")

public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/*
	 * --------------------------------- 
	 * -------- Atributos --------------
	 * ---------------------------------
	 */
	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="native")
	@GenericGenerator(name="native",strategy="native")
	/**
	 * Id, representa el id del usuario creado
	 */
	@Column(name = "ID")
	private long id;
	/**
	 * nombreUsuario, representa el nombre que elegira el usuario para loguearse
	 */
	@NotBlank(message="Ingrese su nombre ID")
	@Column(name = "NOMBREUSUARIO" , length = 100 , nullable = true)
	private String nombreUsuario;
	
	/**
	 * password, representa la contraseña elegida por el usuario
	 */
	@NotBlank(message="Ingrese su contraseña")
	@Column(name = "PASSWORD" , length = 150 , nullable = true)
	private String password;
	
	/**
	 * nombreReal, representa el nombre del usuario
	 */
	@NotBlank(message="Ingrese su nombre")
	@Column(name = "NOMBREREAL" , length = 100 , nullable = true)
	private String nombreReal;
	
	/**
	 * apellidoReal, representa el apellido del usuario
	 */
	@NotBlank(message="Ingrese su apellido")
	@Column(name = "APELLIDOREAL" , length = 100 , nullable = true)
	private String apellidoReal;
	
	/**
	 * tipoUsuario, representa el rol y permisos que tiene el usuario
	 */
	@Column(name = "TIPOUSUARIO" , length = 20 , nullable = true)
	private String tipoUsuario;

	/*
	 * --------------------------------- 
	 * -------- Constructores-----------
	 * ---------------------------------
	 */
	/**
	 * Constructor Por Defecto
	 */
	public Usuario() {
		super();
	}
	/**
	 * Constructor Parametrizado
	 * @param nombreUsuario
	 * @param password
	 * @param nombreReal
	 * @param apellidoReal
	 * @param tipoUsuario
	 */
	public Usuario(String nombreUsuario, String password, String nombreReal, String apellidoReal, String tipoUsuario) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.nombreReal = nombreReal;
		this.apellidoReal = apellidoReal;
		this.tipoUsuario = tipoUsuario;
	}

	/*
	 * --------------------------------- 
	 * -------- Metodos Accesores-------
	 * ---------------------------------
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombreReal() {
		return nombreReal;
	}

	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}

	public String getApellidoReal() {
		return apellidoReal;
	}

	public void setApellidoReal(String apellidoReal) {
		this.apellidoReal = apellidoReal;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/*
	 * --------------------------------- 
	 * -------- ToString --------------
	 * ---------------------------------
	 */
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreUsuario=" + nombreUsuario + ", password=" + password + ", nombreReal="
				+ nombreReal + ", apellidoReal=" + apellidoReal + ", tipoUsuario=" + tipoUsuario + "]";
	}
	
	
	
}
