package ar.edu.unju.fi.tracking.util;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Consulta3 implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String patente;

	
	
	public Consulta3() {
		super();
	}

	public Consulta3(String patente) {
		super();
		this.patente = patente;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Consulta3 [patente=" + patente + "]";
	}
	
	

}
