package ar.edu.unju.fi.tracking.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name ="usuario")

public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy=GenerationType.AUTO,generator="native")
	@GenericGenerator(name="native",strategy="native")
	@Column(name = "ID")
	private long id;
	
	@Column(name = "NOMBREUSUARIO" , length = 100 , nullable = true)
	private String nombreUsuario;
	
	@Column(name = "PASSWORD" , length = 150 , nullable = true)
	private String password;
	
	@Column(name = "NOMBREREAL" , length = 100 , nullable = true)
	private String nombreReal;
	
	@Column(name = "APELLIDOREAL" , length = 100 , nullable = true)
	private String apellidoReal;
	
	@Column(name = "TIPOUSUARIO" , length = 20 , nullable = true)
	private String tipoUsuario;

	// -------------------------
	// ----- CONSTRUCTORES -----
	// -------------------------
	public Usuario() {
		super();
	}

	public Usuario(String nombreUsuario, String password, String nombreReal, String apellidoReal, String tipoUsuario) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.nombreReal = nombreReal;
		this.apellidoReal = apellidoReal;
		this.tipoUsuario = tipoUsuario;
	}

	// -------------------------
	// ----- METODOS ACCESORES -----
	// -------------------------
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
	
}
