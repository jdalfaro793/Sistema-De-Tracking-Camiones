package ar.edu.unju.fi.tracking.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


/**
 * Clase Registro, representa los atributos ID, FechaHora, Vehiculo, Tripulante, Localidad, Detalle Registro
 * nos va a permitir poder registrar al vehiculo con cada uno de sus tripulantes, su recorrido, su fecha y hora
 * @author RODOLFO
 */
//Component marca a la clase como un bean de Spring
@Entity
@Table(name="REG_TRACKING")
@Component
public class Registro implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * --------------------------------- 
	 * -------- Atributos --------------
	 * ---------------------------------
	 */
	
	/**
	 * GeneratedValue IDENTITY, genera un valor automático durante la confirmación para cada nuevo objeto de entidad.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**
	 * ID del registro, para poder identificar cada registro creado
	 */
	@Column(name = "ID")
	private long id;
	
	/**
	 * FechaHora del registro, permite conocer el dia y el horario en que se creo dicho registro
	 */
	@Column(name="FECHAHORA")
	@DateTimeFormat(pattern = "dd/MM/YYYY")
	LocalDateTime fechaHora;
	
	
	/**
	 * Vehiculo, un objeto tipo Vehiculo, que nos permite buscar los vehiculos necesarios para el registro
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_VEH")
	Vehiculo vehiculo;
	
	
	//@Column(name="TRIPULANTE_LIST", nullable=false)
	/**
	 * List Tripulante, un listado de tipo Tripulante, para poder denotar la cantidad de personas que pasaron por ese punto de control
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "REG_TRIPULANTE" ,
	joinColumns = @JoinColumn(name = "REG_ID"), 
	 inverseJoinColumns = @JoinColumn(name = "TRIP_ID"))
	List<Tripulante> tripulante;
	
	
	/**
	 * Localidad, registrar la localidad donde se efectuo dicho registro
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_LOCALIDAD") 
	Localidad localidad;
	
	/**
	 * DetalleLugarRegistro, representa los detalles adicionales al alta de registro
	 */
	@Column(name = "DETALLE_LUGAR_REGISTRO", length = 250, nullable = true)
	String detalleLugarRegistro;
	
	/*
	 * --------------------------------- 
	 * -------- Constructores-------
	 * ---------------------------------
	 */
	public Registro() {
		super();
	}

	public Registro(long id, LocalDateTime fechaHora, Vehiculo vehiculo, List<Tripulante> tripulante,
			Localidad localidad, String detalleLugarRegistro) {
		super();
		this.id = id;
		this.fechaHora = fechaHora;
		this.vehiculo = vehiculo;
		this.tripulante = tripulante;
		this.localidad = localidad;
		this.detalleLugarRegistro = detalleLugarRegistro;
	}
	
	/*
	 * --------------------------------- 
	 * -------- Metodos Accesores-------
	 * ---------------------------------
	 */
	
	/**
	 * devuelve la variable id(para bd)
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * obtiene la variable id(para bd)
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Método que permite obtener el valor de fechaHora
	 * @return LocalDateTime fechaHora
	 */
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	
	/**
	 * Método que permite asignarle un valor a fechaHora
	 * @param fechaHora
	 */
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
	
	/**
	 * Método que permite obtener el valor de vehiculo
	 * @return Vehiculo vehiculo
	 */
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	
	/**
	 * Método que permite asignarle un valor a vehiculo
	 * @param vehiculo
	 */
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	/**
	 * Método que permite obtener los valores de tripulante
	 * @return List<Tripulante> tripulante
	 */
	public List<Tripulante> getTripulante() {
		return tripulante;
	}
	/**
	 * Método que permite asignarle un valor a tripulante
	 * @param tripulante
	 */
	public void setTripulante(List<Tripulante> tripulante) {
		this.tripulante = tripulante;
	}
	
	/**
	 * Método que permite obtener los atributos de localidad
	 * @return Localidad localidad
	 */
	public Localidad getLocalidad() {
		return localidad;
	}
	
	/**
	 * Método que permite asignarle un valor a localidad
	 * @param localidad
	 */
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	
	/**
	 *  Método que permite obtener el valor de detalleLugarRegistro
	 * @return String detalleLugarRegistro
	 */
	public String getDetalleLugarRegistro() {
		return detalleLugarRegistro;
	}
	
	/**
	 * Método que permite asignarle un valor a detalleLugarRegistro
	 * @param detalleLugarRegistro
	 */
	public void setDetalleLugarRegistro(String detalleLugarRegistro) {
		this.detalleLugarRegistro = detalleLugarRegistro;
	}
	
	

}
