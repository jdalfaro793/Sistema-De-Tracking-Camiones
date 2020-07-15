package ar.edu.unju.fi.tracking.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

/**
 * Clase Localidad, que representa los atributos idLocalidad, nombre y un list
 * de registros nos permitira crear objetos de tipo localidad para poder
 * almacenar el recorrido que hay en cada registro
 * 
 * @author RODOLFO
 *
 */
@Component
@Entity
@Table(name = "localidad")
public class Localidad implements Serializable {

	/**
	 * Es un número de versión que posee cada clase Serializable, el cual es usado
	 * en la deserialización para verificar que el emisor y el receptor de un objeto
	 * serializado mantienen una compatibilidad en lo que a serialización se refiere
	 * con respecto a la clases que tienen cargadas
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * --------------------------------- 
	 * -------- Atributos --------------
	 * ---------------------------------
	 */
	/**
	 * El GenerationType.AUTO es el tipo de generación por defecto y permite que el
	 * proveedor de persistencia elegir la estrategia de generación.
	 * 
	 * GenericGenerator se usa para asignar un generador de 
	 * secuencia definido por el usuario
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")

	/**
	 * ID Localidad, me permite identificar con un numero unico cada localidad que
	 * este cargada en la BD
	 */
	@Column(name = "IDLOCALIDAD")
	private long idLocalidad;

	/**
	 * Nombre, representa el nombre de la localidad almacenada
	 */
	@Column(name = "NOMBRE_LOC")
	private String nombre;

	/**
	 * List Registro, representa un listado de registros por vehiculos
	 */
	@OneToMany(mappedBy = "localidad")
	private List<Registro> registros;

	/*
	 * --------------------------------- 
	 * -------- Constructores-----------
	 * ---------------------------------
	 */
	/**
	 * Constructor por defecto
	 */
	public Localidad() {
		super();
	}

	/**
	 * Constructor Parametrizado
	 * 
	 * @param idLocalidad ID de localidad
	 * @param nombre      nombre de la localidad
	 */
	public Localidad(long idLocalidad, String nombre) {
		super();
		this.idLocalidad = idLocalidad;
		this.nombre = nombre;
	}

	/*
	 * --------------------------------- 
	 * -------- Metodos Accesores-------
	 * ---------------------------------
	 */
	public long getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(long idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*
	 * --------------------------------- 
	 * -------- ToString----------------
	 * ---------------------------------
	 */
	@Override
	public String toString() {
		return "Localidad [idLocalidad=" + idLocalidad + ", nombre=" + nombre + ", registros=" + registros + "]";
	}

}
