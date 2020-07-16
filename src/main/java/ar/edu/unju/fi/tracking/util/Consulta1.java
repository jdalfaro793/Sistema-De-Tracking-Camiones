package ar.edu.unju.fi.tracking.util;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.tracking.model.Localidad;

@Component
public class Consulta1 implements Serializable {

	/**
	 * Valor por defecto de serializable
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo que representa una localidad a consultar
	 */
	@Autowired
	private Localidad localidad;
	
	/**
	 * Artibuto que representa la fecha-hora desde donde consultar
	 */
	//@DateTimeFormat( pattern = "dd/MM/yyyy" )
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime fechaDesde;
	
	/**
	 * Atributo que representa la fecha-hora hasta donde consultar
	 */
	//@DateTimeFormat( pattern = "dd/MM/yyyy" )
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime fechaHasta;

	
	public Consulta1() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the localidad
	 */
	public final Localidad getLocalidad() {
		return localidad;
	}


	/**
	 * @param localidad the localidad to set
	 */
	public final void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}


	/**
	 * @return the fechaDesde
	 */
	public final LocalDateTime getFechaDesde() {
		return fechaDesde;
	}


	/**
	 * @param fechaDesde the fechaDesde to set
	 */
	public final void setFechaDesde(LocalDateTime fechaDesde) {
		this.fechaDesde = fechaDesde;
	}


	/**
	 * @return the fechaHasta
	 */
	public final LocalDateTime getFechaHasta() {
		return fechaHasta;
	}


	/**
	 * @param fechaHasta the fechaHasta to set
	 */
	public final void setFechaHasta(LocalDateTime fechaHasta) {
		this.fechaHasta = fechaHasta;
	}


	/**
	 * @return the serialversionuid
	 */
	public static final long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Consulta1 [localidad=" + localidad + ", fechaDesde=" + fechaDesde + ", fechaHasta=" + fechaHasta + "]";
	}

	
	
}
