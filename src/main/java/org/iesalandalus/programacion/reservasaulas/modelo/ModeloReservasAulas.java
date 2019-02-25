package org.iesalandalus.programacion.reservasaulas.modelo;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.modelo.dao.Aulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dao.Profesores;
import org.iesalandalus.programacion.reservasaulas.modelo.dao.Reservas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia;

public class ModeloReservasAulas {

	private Profesores profesores;
	private Aulas aulas;
	private Reservas reservas;
	
	public ModeloReservasAulas() {
		this.profesores = new Profesores();
		this.aulas = new Aulas();
		this.reservas = new Reservas();
		
	}
	
	public Aula[] getAulas() {
		return this.aulas.getAulas();
	}
	
	public int getNumAulas() {
		return this.aulas.getNumAulas();
	}
	
	
	public String[] representarAulas() {
		return this.aulas.representar();
	}
	
	public Aula buscarAula(Aula aula) {
		return this.aulas.buscar(aula);
		
	}
	
	public void insertarAula(Aula aula) throws OperationNotSupportedException {
		this.aulas.insertar(aula);
	}
	
	public void borrarAula(Aula aula) throws OperationNotSupportedException {
		this.aulas.borrar(aula);
	}
	
	public int getNumProfesores() {
		return this.profesores.getNumProfesores();
	}

	public Profesor[] getProfesores() {
		return this.profesores.getProfesores();
	}
	
	public String[] representarProfesores() {
		return this.profesores.representar();
	}
	
	public Profesor buscarProfesor(Profesor profesor) {
		return this.profesores.buscar(profesor);
		
	}
	
	public void insertarProfesor(Profesor profesor) throws OperationNotSupportedException {
		this.profesores.insertar(profesor);
	}
	
	public void borrarProfesor(Profesor profesor) throws OperationNotSupportedException {
		this.profesores.borrar(profesor);
	}
	
	public int getNumReservas() {
		return this.reservas.getNumReservas();
	}

	public Reserva[] getReservas() {
		return this.reservas.getReservas();
	}
	
	public String[] representarReservas() {
		return this.reservas.representar();
	}
	
	public Reserva buscarReserva(Reserva reserva) {
		return this.reservas.buscar(reserva);
	}
	
	public void realizarReserva(Reserva reserva) throws OperationNotSupportedException {
		this.reservas.insertar(reserva);
	}
	
	public void anularReserva(Reserva reserva) throws OperationNotSupportedException {
		this.reservas.borrar(reserva);
	}
	
	public Reserva[] getReservasAula(Aula aula) {
		return this.reservas.getReservasAula(aula);
	}
	
	public Reserva[] getReservasProfesor(Profesor profesor) {
		return this.reservas.getReservasProfesor(profesor);
	}
	
	public Reserva[] getReservasPermanencia(Permanencia permanencia) {
		return this.reservas.getReservasPermanencia(permanencia);
	}
	
	public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia) {
		return this.reservas.consultarDisponibilidad(aula, permanencia);
	}
}
