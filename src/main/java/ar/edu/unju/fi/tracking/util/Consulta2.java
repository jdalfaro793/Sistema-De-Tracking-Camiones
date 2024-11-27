package ar.edu.unju.fi.tracking.util;

import java.io.Serializable;

import org.springframework.stereotype.Component;
/**
 * Clase auxiliar para poder realizar la consulta 2 del TP
 *
 */
@Component
public class Consulta2 implements Serializable {

	private static final long serialVersionUID = 1L;
	/*
	 * --------------------------------- 
	 * -------- Atributos --------------
	 * ---------------------------------
	 */
	/**
	 * DNI para buscar a un tripulante y su recorrido
	 */
	private Long dni;

	/*
	 * --------------------------------- 
	 * -------- Constructores-----------
	 * ---------------------------------
	 */
	/**
	 * Constructor Por Defecto
	 */
	public Consulta2() {
		super();
	}
	/**
	 * Constructor Parametrizado
	 * @param dni
	 */
	public Consulta2(Long dni) {
		super();
		this.dni = dni;
	}
	/*
	 * --------------------------------- 
	 * -------- Metodos Accesores-------
	 * ---------------------------------
	 */
	public final Long getDni() {
		return dni;
	}

	public final void setDni(Long dni) {
		this.dni = dni;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/*
	 * --------------------------------- 
	 * -------- ToString ---------------
	 * ---------------------------------
	 */
	@Override
	public String toString() {
		return "Consulta2 [dni=" + dni + "]";
	}

}
