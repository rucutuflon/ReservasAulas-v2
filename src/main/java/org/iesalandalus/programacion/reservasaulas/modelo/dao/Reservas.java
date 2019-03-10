package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.PermanenciaPorTramo;

public class Reservas {

	private static final int MAX_PUNTOS_PROFESOR_MES = 200;
	private List<Reserva> coleccionReservas;
	
	public Reservas() {
		this.coleccionReservas = new ArrayList<Reserva>();
	}
	
	public Reservas(Reservas r) {
		if(r == null) {
			throw new IllegalArgumentException("No se pueden copiar reservas nulas.");
		}
		setReservas(r);
	}
	
	private void setReservas(Reservas reservas) {
		this.coleccionReservas = copiaProfundaReservas(reservas.coleccionReservas);
	}
	
	private List<Reserva> copiaProfundaReservas(List<Reserva> lista) {
		List<Reserva> aux = new ArrayList<Reserva>();
		for (Reserva r : lista) {
			aux.add(new Reserva(r));
		}
		return aux;
	}
	
	public List<Reserva> getReservas() {
		return copiaProfundaReservas(coleccionReservas);
	}
	
	public int getNumReservas() {
		return this.coleccionReservas.size();
	}

	public void insertar(Reserva reserva) throws OperationNotSupportedException{
		if(reserva == null) {
			throw new IllegalArgumentException("No se puede realizar una reserva nula.");
		}
		if(buscar(reserva) != null) {
			throw new OperationNotSupportedException("La reserva ya existe.");
		}
		if(!esMesSiguienteOPosterior(reserva)) {
			throw new OperationNotSupportedException("Sólo se pueden hacer reservas para el mes que viene o posteriores.");
		}
		Reserva aux = getReservaDia(reserva.getPermanencia().getDia());
		if(aux != null && aux.getAula().equals(reserva.getAula())) {
			if(aux.getPermanencia() instanceof PermanenciaPorTramo && reserva.getPermanencia() instanceof PermanenciaPorTramo) {
				if(((PermanenciaPorTramo)aux.getPermanencia()).getTramo().equals(((PermanenciaPorTramo)reserva.getPermanencia()).getTramo())) {
					throw new OperationNotSupportedException("Ya se ha realizado una reserva por tramo para este día y aula.");
				}
			}else if(aux.getPermanencia() instanceof PermanenciaPorTramo) {
				throw new OperationNotSupportedException("Ya se ha realizado una reserva por tramo para este día y aula.");
			}else {
				throw new OperationNotSupportedException("Ya se ha realizado una reserva por hora para este día y aula.");
			}
		}
		List<Reserva> aux2 = getReservasProfesorMes(reserva.getProfesor(), reserva.getPermanencia().getDia());
		float suma = 0;
		for (Reserva r : aux2) {
			suma += getPuntosGastadosReserva(r);
		}
		if(suma + reserva.getPuntos() > MAX_PUNTOS_PROFESOR_MES) {
			throw new OperationNotSupportedException("Esta reserva excede los puntos máximos por mes para dicho profesor.");
		}
		this.coleccionReservas.add(new Reserva(reserva));
	}
	
	private boolean esMesSiguienteOPosterior(Reserva reserva) {
		if(reserva.getPermanencia().getDia().getYear() < LocalDate.now().plusMonths(1).getYear()
				|| reserva.getPermanencia().getDia().getYear() == LocalDate.now().plusMonths(1).getYear()
				&& reserva.getPermanencia().getDia().getMonthValue() < LocalDate.now().plusMonths(1).getMonthValue()) {
			return false;
		}
		return true;
	}
	
	private float getPuntosGastadosReserva(Reserva r) {
		return r.getPuntos();
	}
	
	private List<Reserva> getReservasProfesorMes(Profesor p, LocalDate dia){
		List<Reserva> aux = new ArrayList<Reserva>();
		for (Reserva r : coleccionReservas) {
			if(r.getProfesor().equals(p) && r.getPermanencia().getDia().getYear()==dia.getYear() && r.getPermanencia().getDia().getMonthValue()==dia.getMonthValue()) {
				aux.add(r);
			}
		}
		return aux;
	}
	
	private Reserva getReservaDia(LocalDate dia) {
		for (Reserva r : coleccionReservas) {
			if(r.getPermanencia().getDia().equals(dia)) {
				return r;
			}
		}
		return null;
	}
	
	public Reserva buscar(Reserva reserva) {
		int index = this.coleccionReservas.indexOf(reserva);
		if(index == -1) {
			return null;
		}
		return new Reserva(coleccionReservas.get(index));
		
	}
	
	public void borrar(Reserva reserva) throws OperationNotSupportedException{
		if(reserva == null) {
			throw new IllegalArgumentException("No se puede anular una reserva nula.");
		}
		if(this.coleccionReservas.remove(reserva) == false) {
			throw new OperationNotSupportedException("La reserva a anular no existe.");
		}
	}
	
	public List<String> representar() {
		List<String> aux = new ArrayList<String>();
		for (int i = 0; i < coleccionReservas.size(); i++) {
			aux.add(coleccionReservas.get(i).toString());
		}
		return aux;
	}
	
	public List<Reserva> getReservasProfesor(Profesor profesor) {
		List<Reserva> aux = new ArrayList<Reserva>();
		for (Reserva r : coleccionReservas) {
			if(r.getProfesor().equals(profesor)) {
				aux.add(r);
			}
		}
		return aux;
	}
	
	public List<Reserva> getReservasAula(Aula aula) {
		List<Reserva> aux = new ArrayList<Reserva>();
		for (Reserva r : coleccionReservas) {
			if(r.getAula().equals(aula)) {
				aux.add(r);
			}
		}
		return aux;
	}
	
	public List<Reserva> getReservasPermanencia(Permanencia permanencia) {
		List<Reserva> aux = new ArrayList<Reserva>();
		for (Reserva r : coleccionReservas) {
			if(r.getPermanencia().equals(permanencia)) {
				aux.add(r);
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
		for (Reserva r : coleccionReservas) {
			if(r.getAula().equals(aula) && r.getPermanencia().equals(permanencia)) {
				return false;
			}
		}
		return true;
		
	}
}
