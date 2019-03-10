package org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public abstract class Permanencia {

	protected LocalDate dia;
	protected static final DateTimeFormatter FORMATO_DIA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	protected Permanencia() {
		this.dia = LocalDate.now();
	}
	
	protected Permanencia(String s) {
		setDia(s);
	}
	
	protected Permanencia(LocalDate dia) {
		setDia(dia);
	}
	

	public LocalDate getDia() {
		return dia;
	}

	protected void setDia(LocalDate dia) {
		if(dia == null) {
			throw new IllegalArgumentException("El día de una permanencia no puede ser nulo.");
		}
		this.dia = dia;
	}
	
	protected void setDia(String s) {
		if(s == null) {
			throw new IllegalArgumentException("El día de una permanencia no puede ser nulo.");
		}
		try {
			this.dia = LocalDate.parse(s, FORMATO_DIA);
		} catch (DateTimeParseException e) {
			throw new IllegalArgumentException("El formato del día de la permanencia no es correcto.");
		}
		
	}
	
	public abstract int getPuntos();

	@Override
	public abstract int hashCode();

	@Override
	public abstract boolean equals(Object obj);

	@Override
	public abstract String toString();
	
	
}
