package org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class PermanenciaPorHora extends Permanencia{

	private static final int PUNTOS = 0;
	private static final int HORA_INICIO = 0;
	private static final int HORA_FIN = 0;
	private static final DateTimeFormatter FORMATO_HORA = DateTimeFormatter.ofPattern("HH:mm:ss");
	private LocalTime hora;
	
	public PermanenciaPorHora(LocalDate dia, LocalTime hora) {
		this.dia = dia;
		this.hora = hora;
	}
	
	public PermanenciaPorHora(String dia, LocalTime hora) {
		this.dia = dia;
		this.hora = hora;
	}
	
	public PermanenciaPorHora(String dia, String hora) {
		this.dia = dia;
		this.hora = hora;
	}
	
	public PermanenciaPorHora(PermanenciaPorHora p) {
		this.dia = p.dia;
        this.hora = p.hora;
	}

	public LocalTime getHora() {
		return hora;
	}

	private void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	private void setHora(String Tramo) {
		this.tramo = tramo;
	}

	public static int getPuntos() {
		return PUNTOS;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PermanenciaPorHora other = (PermanenciaPorHora) obj;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PermanenciaPorHora [hora=" + hora + "]";
	}
	
	
}
