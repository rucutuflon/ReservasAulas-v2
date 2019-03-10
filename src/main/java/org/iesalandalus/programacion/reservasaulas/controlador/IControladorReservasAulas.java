package org.iesalandalus.programacion.reservasaulas.controlador;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia;

public interface IControladorReservasAulas {
	
	public void comenzar();
	
	public void salir();
	
	public void insertarAula(Aula a) throws OperationNotSupportedException;
	
	public void borrarAula(Aula a) throws OperationNotSupportedException;
	
	public Aula buscarAula(Aula a);
	
	public List<String> representarAulas();
	
	public void insertarProfesor(Profesor p) throws OperationNotSupportedException;
	
	public void borrarProfesor(Profesor p) throws OperationNotSupportedException;
	
	public Profesor buscarProfesor(Profesor p);
	
	public List<String> representarProfesores();
	
	public void realizarReserva(Reserva r) throws OperationNotSupportedException;
	
	public void anularReserva(Reserva r) throws OperationNotSupportedException;
	
	public List<String> representarReservas();
	
	public List<Reserva> getReservasAula(Aula a);
	
	public List<Reserva> getReservasProfesor(Profesor p);
	
	public List<Reserva> getReservasPermanencia(Permanencia p);
	
	public boolean consultarDisponibilidad(Aula a, Permanencia p);
	
}
