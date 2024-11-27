package ar.edu.unju.fi.tracking.util;

import java.io.Serializable;

import org.springframework.stereotype.Component;
/**
 * Clase auxiliar creada para poder realizar la consulta 3
 *
 */
@Component
public class Consulta3 implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * --------------------------------- 
	 * -------- Atributos --------------
	 * ---------------------------------
	 */
	/**
	 * Patente, para buscar a un vehiculo y su recorrido
	 */
	private String patente;

	/*
	 * --------------------------------- 
	 * -------- Constructores-----------
	 * ---------------------------------
	 */
	/**
	 * Constructor Por Defecto
	 */
	public Consulta3() {
		super();
	}
	/**
	 * Constructor Parametrizado
	 * @param patente
	 */
	public Consulta3(String patente) {
		super();
		this.patente = patente;
	}
	
	/*
	 * --------------------------------- 
	 * -------- Metodos Accesores-------
	 * ---------------------------------
	 */

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
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
		return "Consulta3 [patente=" + patente + "]";
	}
	
	

}
