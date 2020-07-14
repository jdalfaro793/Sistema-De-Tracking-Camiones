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
@Table(name ="tripulante")
public class Tripulante implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy=GenerationType.AUTO,generator="native")
	@GenericGenerator(name="native",strategy="native")
	@Column(name = "IDTRIPULANTE")
	private long idTripulante;
	
	@Column(name = "DOCUMENTO")
	private String documento;
	
	@Column(name = "APELLIDO")
	private String apellido;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "NACIONALIDAD")
	private String nacionalidad;

	public Tripulante() {
		super();
	}

	public Tripulante(long idTripulante, String documento, String apellido, String nombre, String nacionalidad) {
		super();
		this.idTripulante = idTripulante;
		this.documento = documento;
		this.apellido = apellido;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
	}

	public long getIdTripulante() {
		return idTripulante;
	}

	public void setIdTripulante(long idTripulante) {
		this.idTripulante = idTripulante;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	
	
	
}
