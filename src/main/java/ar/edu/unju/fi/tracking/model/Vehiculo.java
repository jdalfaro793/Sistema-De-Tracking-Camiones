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
 * Clase Vehiculo, representa los atributos idvehiculo, patente, color, titular, marca, modelo, tipo, 
 * numero chasis, numero motor
 * Nos va a permitir captar los datos de un vehiculo para poder agregarlo a un registro
 *
 */
@Component
@Entity
@Table(name ="vehiculo")

public class Vehiculo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * --------------------------------- 
	 * -------- Atributos --------------
	 * ---------------------------------
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="native")
	@GenericGenerator(name="native",strategy="native")
	/**
	 * idVehiculo, representa el id del vehiculo
	 */
	@Column(name = "IDVEHICULO")
	private long idVehiculo;
	
	/**
	 * patente, representa el Nº de patente del vehiculo
	 */
	@NotBlank(message="Ingrese patente")
	@Column(name = "PATENTE" , length = 100 , nullable = true)
	private String patente;
	
	/**
	 * color, color del vehiculo
	 */
	@NotBlank(message="Ingrese color del vehiculo")
	@Column(name = "COLOR" , length = 100 , nullable = true)
	private String color;
	
	/**
	 * titular, representa el titular a cargo del vehiculo
	 */
	@NotBlank(message="Ingrese su nombre")
	@Column(name = "TITULAR" , length = 100 , nullable = true)
	private String titular;
	
	/**
	 * marca, marca del vehiculo
	 */
	@NotBlank(message="Ingrese la marca")
	@Column(name = "MARCA" , length = 100 , nullable = true)
	private String marca;
	
	/**
	 * modelo, modelo del vehiculo
	 */
	@NotBlank(message="Ingrese modelo del vehiculo")
	@Column(name = "MODELO" , length = 100 , nullable = true)
	private String modelo;
	
	/**
	 * tipo, tipo de vehiculo
	 */
	@NotBlank(message="Ingrese el tipo de vehiculo")
	@Column(name = "TIPO" , length = 100 , nullable = true)
	private String tipo;
	
	/**
	 * numeroChasis, nº de chasis del vehiculo
	 */
	@NotBlank(message="Ingrese Nº de Chasis")
	@Column(name = "NUMEROCHASIS" , length = 100 , nullable = true)
	private String numeroChasis;
	
	/**
	 * numeroMotor, Nº de motor del vehiculo
	 */
	@NotBlank(message="Ingrese Nº del motor")
	@Column(name = "NUMEROMOTOR" , length = 100 , nullable = true)
	private String numeroMotor;

	/*
	 * --------------------------------- 
	 * -------- Constructores-----------
	 * ---------------------------------
	 */
	/**
	 * Constructor Por Defecto
	 */
	public Vehiculo() {
		super();
	}
	
	/**
	 * Constructor Parametrizado
	 * @param idVehiculo
	 * @param patente
	 * @param color
	 * @param titular
	 * @param marca
	 * @param modelo
	 * @param tipo
	 * @param numeroChasis
	 * @param numeroMotor
	 */
	public Vehiculo(long idVehiculo, String patente, String color, String titular, String marca, String modelo,
			String tipo, String numeroChasis, String numeroMotor) {
		super();
		this.idVehiculo = idVehiculo;
		this.patente = patente;
		this.color = color;
		this.titular = titular;
		this.marca = marca;
		this.modelo = modelo;
		this.tipo = tipo;
		this.numeroChasis = numeroChasis;
		this.numeroMotor = numeroMotor;
	}


	/*
	 * --------------------------------- 
	 * -------- Metodos Accesores-------
	 * ---------------------------------
	 */
	public long getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumeroChasis() {
		return numeroChasis;
	}

	public void setNumeroChasis(String numeroChasis) {
		this.numeroChasis = numeroChasis;
	}

	public String getNumeroMotor() {
		return numeroMotor;
	}

	public void setNumeroMotor(String numeroMotor) {
		this.numeroMotor = numeroMotor;
	}
	
	/*
	 * --------------------------------- 
	 * -------- ToString --------------
	 * ---------------------------------
	 */

	@Override
	public String toString() {
		return "Vehiculo [idVehiculo=" + idVehiculo + ", patente=" + patente + ", color=" + color + ", titular="
				+ titular + ", marca=" + marca + ", modelo=" + modelo + ", tipo=" + tipo + ", numeroChasis="
				+ numeroChasis + ", numeroMotor=" + numeroMotor + "]";
	}

	
	

	
	
	
	
}
