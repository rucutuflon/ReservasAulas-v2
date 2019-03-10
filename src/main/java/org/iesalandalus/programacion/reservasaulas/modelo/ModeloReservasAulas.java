package org.iesalandalus.programacion.reservasaulas.modelo;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.modelo.dao.Aulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dao.Profesores;
import org.iesalandalus.programacion.reservasaulas.modelo.dao.Reservas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia;

public class ModeloReservasAulas implements IModeloReservasAulas{

	private Profesores profesores;
	private Aulas aulas;
	private Reservas reservas;
	
	public ModeloReservasAulas() {
		this.profesores = new Profesores();
		this.aulas = new Aulas();
		this.reservas = new Reservas();
		
	}
	
	public List<Aula> getAulas() {
		return this.aulas.getAulas();
	}
	
	public int getNumAulas() {
		return this.aulas.getNumAulas();
	}
	
	
	public List<String> representarAulas() {
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

	public List<Profesor> getProfesores() {
		return this.profesores.getProfesores();
	}
	
	public List<String> representarProfesores() {
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

	public List<Reserva> getReservas() {
		return this.reservas.getReservas();
	}
	
	public List<String> representarReservas() {
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
	
	public List<Reserva> getReservasAula(Aula aula) {
		return this.reservas.getReservasAula(aula);
	}
	
	public List<Reserva> getReservasProfesor(Profesor profesor) {
		return this.reservas.getReservasProfesor(profesor);
	}
	
	public List<Reserva> getReservasPermanencia(Permanencia permanencia) {
		return this.reservas.getReservasPermanencia(permanencia);
	}
	
	public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia) {
		return this.reservas.consultarDisponibilidad(aula, permanencia);
	}
}
