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
 * Clase Tripulante, representa los atributos id, documento, apellido, nombre, nacionalidad
 * nos permite crear un objeto de tipo tripulante que representara las personas que pasan por el registro
 * @author RODOLFO 
 *
 */
@Component
@Entity
@Table(name ="tripulante")
public class Tripulante implements Serializable{
	
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
	 * idTripulante, representa el id de cada tripulante
	 */
	@Column(name = "IDTRIPULANTE")
	private long idTripulante;
	
	/**
	 * documento, representa el DNI de cada tripulante
	 */
	@NotBlank(message = "Ingrese el numero de documento")
	@Column(name = "DOCUMENTO")
	private String documento;
	
	/**
	 * Apellido, representa el apellido del tripulante
	 */
	@NotBlank(message = "Ingrese el apellido")
	@Column(name = "APELLIDO")
	private String apellido;
	
	/**
	 * Nombre, representa el nombre del tripulante
	 */
	@NotBlank(message = "Ingrese el nombre")
	@Column(name = "NOMBRE")
	private String nombre;
	
	/**
	 * Nacionalidad, representa la nacionalidad del tripulante
	 */
	@NotBlank(message = "Ingrese la nacionalidad")
	@Column(name = "NACIONALIDAD")
	private String nacionalidad;

	/*
	 * --------------------------------- 
	 * -------- Constructures ----------
	 * ---------------------------------
	 */
	/**
	 * Constructor Sin Parametros
	 */
	public Tripulante() {
		super();
	}
	/**
	 * Constructor con parametros
	 * @param idTripulante
	 * @param documento
	 * @param apellido
	 * @param nombre
	 * @param nacionalidad
	 */
	public Tripulante(long idTripulante, String documento, String apellido, String nombre, String nacionalidad) {
		super();
		this.idTripulante = idTripulante;
		this.documento = documento;
		this.apellido = apellido;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
	}
	
	/*
	 * --------------------------------- 
	 * -------- Metodos Accesores-------
	 * ---------------------------------
	 */
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
	/*
	 * --------------------------------- 
	 * -------- To String --------------
	 * ---------------------------------
	 */
	@Override
	public String toString() {
		return "Tripulante [idTripulante=" + idTripulante + ", documento=" + documento + ", apellido=" + apellido
				+ ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + "]";
	}
	
	
	
	
	
	
	
	
	
}
