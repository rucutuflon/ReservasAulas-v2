package org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia;

import java.time.LocalDate;

public class PermanenciaPorTramo extends Permanencia{

	private final int PUNTOS = 0;
	
	public PermanenciaPorTramo(LocalDate dia, Tramo tramo) {
		super(dia, tramo);
		
	}
	
	public PermanenciaPorTramo(String tramo, Tramo tramo) {
		
	}
	
	public PermanenciaPorTramo(PermanenciaPorTramo p) {
		this.dia = p.dia;
        this.tramo = p.tramo;
	}
	
	public Tramo getTramo() {
		return tramo;
	}

	private void setTramo(Tramo tramo) {
		this.tramo = tramo;
	}

	public static int getPuntos() {
		return PUNTOS;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + PUNTOS;
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
		PermanenciaPorTramo other = (PermanenciaPorTramo) obj;
		if (PUNTOS != other.PUNTOS)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PermanenciaPorTramo [PUNTOS=" + PUNTOS + "]";
	}
	
}
