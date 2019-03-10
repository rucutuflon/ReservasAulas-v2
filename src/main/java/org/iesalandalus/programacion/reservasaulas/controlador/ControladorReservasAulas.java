package org.iesalandalus.programacion.reservasaulas.controlador;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.ModeloReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia;
import org.iesalandalus.programacion.reservasaulas.vista.IVistaReservasAulas;
import org.iesalandalus.programacion.reservasaulas.vista.VistaReservasAulas;

public class ControladorReservasAulas implements IControladorReservasAulas {
	
	private ModeloReservasAulas modelo;
	private VistaReservasAulas vista;
	
	public ControladorReservasAulas(IModeloReservasAulas modelo, IVistaReservasAulas vista) {
		this.modelo = (ModeloReservasAulas)modelo;
		this.vista = (VistaReservasAulas)vista;
	}

	@Override
	public void comenzar() {
		vista.setControlador(this);
		
	}

	@Override
	public void salir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertarAula(Aula a) throws OperationNotSupportedException {
		modelo.insertarAula(a);
		
	}

	@Override
	public void borrarAula(Aula a) throws OperationNotSupportedException {
		// TODO Auto-generated method stub
		modelo.borrarAula(a);
	}

	@Override
	public Aula buscarAula(Aula a) {
		// TODO Auto-generated method stub
		return modelo.buscarAula(a);
	}

	@Override
	public List<String> representarAulas() {
		// TODO Auto-generated method stub
		return modelo.representarAulas();
	}

	@Override
	public void insertarProfesor(Profesor p) throws OperationNotSupportedException {
		// TODO Auto-generated method stub
		modelo.insertarProfesor(p);
	}

	@Override
	public void borrarProfesor(Profesor p) throws OperationNotSupportedException {
		// TODO Auto-generated method stub
		modelo.borrarProfesor(p);
	}

	@Override
	public Profesor buscarProfesor(Profesor p) {
		// TODO Auto-generated method stub
		return modelo.buscarProfesor(p);
	}

	@Override
	public List<String> representarProfesores() {
		// TODO Auto-generated method stub
		return modelo.representarProfesores();
	}

	@Override
	public void realizarReserva(Reserva r) throws OperationNotSupportedException {
		// TODO Auto-generated method stub
		modelo.realizarReserva(r);
	}

	@Override
	public void anularReserva(Reserva r) throws OperationNotSupportedException {
		// TODO Auto-generated method stub
		modelo.anularReserva(r);
	}

	@Override
	public List<String> representarReservas() {
		// TODO Auto-generated method stub
		return modelo.representarReservas();
	}

	@Override
	public List<Reserva> getReservasAula(Aula a) {
		// TODO Auto-generated method stub
		return modelo.getReservasAula(a);
	}

	@Override
	public List<Reserva> getReservasProfesor(Profesor p) {
		// TODO Auto-generated method stub
		return modelo.getReservasProfesor(p);
	}

	@Override
	public List<Reserva> getReservasPermanencia(Permanencia p) {
		// TODO Auto-generated method stub
		return modelo.getReservasPermanencia(p);
	}

	@Override
	public boolean consultarDisponibilidad(Aula a, Permanencia p) {
		// TODO Auto-generated method stub
		return modelo.consultarDisponibilidad(a, p);
	}


}
