package org.iesalandalus.programacion.reservasaulas.modelo.dominio;

import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.PermanenciaPorHora;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.PermanenciaPorTramo;

public class Reserva {
	
	private Profesor profesor;
	private Aula aula;
	private Permanencia permanencia;
	
	public Reserva(Profesor profesor, Aula aula, Permanencia permanencia) {
		setProfesor(profesor);
		setAula(aula);
		setPermanencia(permanencia);
	}
	
	public Reserva(Reserva r) {
		if(r == null) {
			throw new IllegalArgumentException("No se puede copiar una reserva nula.");
		}
		this.profesor = new Profesor(r.profesor);
		this.aula = new Aula(r.aula);
		if(r.permanencia instanceof PermanenciaPorHora) {
			this.permanencia = new PermanenciaPorHora((PermanenciaPorHora)r.permanencia);
		}else {
			this.permanencia = new PermanenciaPorTramo((PermanenciaPorTramo)r.permanencia);
		}
		
	}

	public Profesor getProfesor() {
		return profesor;
	}

	private void setProfesor(Profesor profesor) {
		if(profesor == null) {
			throw new IllegalArgumentException("La reserva debe estar a nombre de un profesor.");
		}
		this.profesor = profesor;
	}

	public Aula getAula() {
		return aula;
	}

	private void setAula(Aula aula) {
		if(aula == null) {
			throw new IllegalArgumentException("La reserva debe ser para un aula concreta.");
		}
		this.aula = aula;
	}

	public Permanencia getPermanencia() {
		return permanencia;
	}

	private void setPermanencia(Permanencia permanencia) {
		if(permanencia == null) {
			throw new IllegalArgumentException("La reserva se debe hacer para una permanencia concreta.");
		}
		this.permanencia = permanencia;
	}
	
	public float getPuntos() {
		return permanencia.getPuntos() + aula.getPuntos();
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aula == null) ? 0 : aula.hashCode());
		result = prime * result + ((permanencia == null) ? 0 : permanencia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		if (aula == null) {
			if (other.aula != null)
				return false;
		} else if (!aula.equals(other.aula))
			return false;
		if (permanencia == null) {
			if (other.permanencia != null)
				return false;
		} else if (!permanencia.equals(other.permanencia))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[profesor=" + profesor + ", aula=" + aula + ", permanencia=" + permanencia + ", puntos="+getPuntos()+"]";
	}
	
	
}
