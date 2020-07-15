package ar.edu.unju.fi.tracking.util;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Consulta2 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long dni;

	public Consulta2() {
		super();
	}

	public Consulta2(Long dni) {
		super();
		this.dni = dni;
	}

	public final Long getDni() {
		return dni;
	}

	public final void setDni(Long dni) {
		this.dni = dni;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Consulta2 [dni=" + dni + "]";
	}

}
