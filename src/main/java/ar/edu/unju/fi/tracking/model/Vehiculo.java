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
@Table(name ="vehiculo")

public class Vehiculo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="native")
	@GenericGenerator(name="native",strategy="native")
	@Column(name = "IDVEHICULO")
	private long idVehiculo;
	
	@Column(name = "PATENTE" , length = 100 , nullable = true)
	private String patente;
	
	@Column(name = "COLOR" , length = 100 , nullable = true)
	private String color;
	
	@Column(name = "TITULAR" , length = 100 , nullable = true)
	private String titular;
	
	@Column(name = "MARCA" , length = 100 , nullable = true)
	private String marca;
	
	@Column(name = "MODELO" , length = 100 , nullable = true)
	private String modelo;
	
	@Column(name = "TIPO" , length = 100 , nullable = true)
	private String tipo;
	
	@Column(name = "NUMEROCHASIS" , length = 100 , nullable = true)
	private String numeroChasis;
	
	@Column(name = "NUMEROMOTOR" , length = 100 , nullable = true)
	private String numeroMotor;

	// -------------------------
	// ----- CONSTRUCTORES -----
	// -------------------------
	public Vehiculo() {
		super();
	}
	

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


	// -------------------------
	// ----- METODOS ACCESORES -----
	// -------------------------
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


	

	
	
	
	
}
