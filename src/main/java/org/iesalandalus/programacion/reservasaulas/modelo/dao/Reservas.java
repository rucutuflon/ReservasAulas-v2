package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia;

public class Reservas {

	private static final int MAX_RESERVAS = 10;
	private int numReservas;
	private Reserva[] coleccionReservas;
	
	public Reservas() {
		this.numReservas = 0;
		this.coleccionReservas = new Reserva[MAX_RESERVAS];
	}
	
	public Reservas(Reservas r) {
		if(r == null) {
			throw new IllegalArgumentException("No se pueden copiar reservas nulas.");
		}
		this.numReservas = r.numReservas;
		setReservas(r);
	}
	
	private void setReservas(Reservas reservas) {
		this.coleccionReservas = copiaProfundaReservas(reservas.coleccionReservas);
	}
	
	private Reserva[] copiaProfundaReservas(Reserva[] c) {
		Reserva[] aux = new Reserva[MAX_RESERVAS];
		for (int i = 0; i < aux.length; i++) {
			if(c[i] == null) {
				aux[i] = null;
			}else {
				aux[i] = new Reserva(c[i]);
			}
		}
		return aux;
	}
	
	public int getNumReservas() {
		return numReservas;
	}

	public Reserva[] getReservas() {
		return copiaProfundaReservas(coleccionReservas);
	}
	
	public void insertar(Reserva reserva) throws OperationNotSupportedException{
		if(reserva == null) {
			throw new IllegalArgumentException("No se puede realizar una reserva nula.");
		}
		if(buscarIndiceReserva(reserva) != -1) {
			throw new OperationNotSupportedException("La reserva ya existe.");
		}
		if (!indiceNoSuperaTamano(numReservas)) {
			throw new OperationNotSupportedException("Tamaño de reservas superada.");
		}
		this.coleccionReservas[numReservas] = reserva;
		numReservas++;
	}
	
	private int buscarIndiceReserva(Reserva reserva) {
		for (int i = 0; i < coleccionReservas.length; i++) {
			if(coleccionReservas[i] != null && coleccionReservas[i].equals(reserva)) {
				return i;
			}
		}
		return -1;
		
	}
	
	private boolean indiceNoSuperaTamano(int reservas) {
		return reservas >= 0 && reservas < numReservas;
		
	}
	
	private boolean indiceNoSuperaCapacidad(int reservas) {
		return reservas >= 0 && reservas < coleccionReservas.length;
		
	}
	
	public Reserva buscar(Reserva reserva) {
		int index = buscarIndiceReserva(reserva);
		if(index == -1) {
			return null;
		}
		return coleccionReservas[index];
		
	}
	
	public void borrar(Reserva reserva) throws OperationNotSupportedException{
		if(reserva == null) {
			throw new IllegalArgumentException("No se puede anular una reserva nula.");
		}
		int index = buscarIndiceReserva(reserva);
		if(index == -1) {
			throw new OperationNotSupportedException("La reserva a anular no existe.");
		}
		desplazarUnaPosicionHaciaIzquierda(index);
		numReservas--;
	}
	
	private void desplazarUnaPosicionHaciaIzquierda(int reservas) {
		for (int i = reservas; i < coleccionReservas.length-1; i++) {
			coleccionReservas[i] = coleccionReservas[i+1];
		}
		coleccionReservas[MAX_RESERVAS-1] = null;
	}
	
	public String[] representar() {
		String[] aux = new String[numReservas];
		for (int i = 0; i < numReservas; i++) {
			aux[i] = coleccionReservas[i].toString();
		}
		return aux;
	}
	
	public Reserva[] getReservasProfesor(Profesor profesor) {
		Reserva[] aux = new Reserva[MAX_RESERVAS];
		int j = 0;
		for (int i = 0; i < coleccionReservas.length; i++) {
			if(coleccionReservas[i] != null && coleccionReservas[i].getProfesor().equals(profesor)) {
				aux[j] = coleccionReservas[i];
				j++;
			}
		}
		return aux;
	}
	
	public Reserva[] getReservasAula(Aula aula) {
		Reserva[] aux = new Reserva[MAX_RESERVAS];
		int j = 0;
		for (int i = 0; i < coleccionReservas.length; i++) {
			if(coleccionReservas[i] != null && coleccionReservas[i].getAula().equals(aula)) {
				aux[j] = coleccionReservas[i];
				j++;
			}
		}
		return aux;
	}
	
	public Reserva[] getReservasPermanencia(Permanencia permanencia) {
		Reserva[] aux = new Reserva[MAX_RESERVAS];
		int j = 0;
		for (int i = 0; i < coleccionReservas.length; i++) {
			if(coleccionReservas[i] != null && coleccionReservas[i].getPermanencia().equals(permanencia)) {
				aux[j] = coleccionReservas[i];
				j++;
			}
		}
		return aux;
	}
	
	public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia) {
		if(aula == null) {
			throw new IllegalArgumentException("No se puede consultar la disponibilidad de un aula nula.");
		}
		if(permanencia == null) {
			throw new IllegalArgumentException("No se puede consultar la disponibilidad de una permanencia nula.");
		}
		for (int i = 0; i < coleccionReservas.length; i++) {
			if(coleccionReservas[i] != null && coleccionReservas[i].getAula().equals(aula) && coleccionReservas[i].getPermanencia().equals(permanencia)) {
				return false;
			}
		}
		return true;
		
	}
}
