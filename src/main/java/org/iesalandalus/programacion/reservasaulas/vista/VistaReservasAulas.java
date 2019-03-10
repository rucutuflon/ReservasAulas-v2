package org.iesalandalus.programacion.reservasaulas.vista;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.controlador.ControladorReservasAulas;
import org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas;
import org.iesalandalus.programacion.reservasaulas.vista.IVistaReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.ModeloReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia;

public class VistaReservasAulas implements IVistaReservasAulas{
	
	private final String ERROR = "Error";
	private final String NOMBRE_VALIDO = "Nombre valido";
	private final String CORREO_VALIDO = "Correo valido";
	private IControladorReservasAulas controlador;

	public VistaReservasAulas () {

		IModeloReservasAulas modelo = new ModeloReservasAulas ();
		controlador = new ControladorReservasAulas (modelo, this);
	}
	
	public void setControlador(IControladorReservasAulas controlador) {
		this.controlador = (ControladorReservasAulas) controlador;
	}
	
	public void comenzar () {
		System.out.println("COMENZANDO");
	}
	
	public void salir () {
		System.out.println("SALIENDO");
		System.exit(0);
	}

	public void insertarAula() {
		System.out.println("INSERTAR AULA");
		try {
			Aula a = Consola.leerAula();
			controlador.insertarAula(a);
		} catch (OperationNotSupportedException e) {
			System.out.println(ERROR+": "+e.getMessage());
		}
		
	}

	public void borrarAula() {
		System.out.println("BORRAR AULA");
		try {
			controlador.borrarAula(Consola.leerAula());
		} catch (OperationNotSupportedException e) {
			System.out.println(ERROR+": "+e.getMessage());
		}
	}

	public void buscarAula() {
		System.out.println("BUSCAR AULA");
		Aula a = controlador.buscarAula(Consola.leerAula());
		if(a == null) {
			System.out.println("No existe el aula buscada");
		}else {
			System.out.println(a.toString());
		}
	}

	public void listarAulas() {
		System.out.println("LISTADO DE AULAS");
		List<String> a = controlador.representarAulas();
		for (String aula : a) {
			System.out.println(aula);
		}
		System.out.println("TOTAL AULAS: "+a.size());
	}

	public void insertarProfesor() {
		System.out.println("INSERTAR PROFESOR");
		try {
			controlador.insertarProfesor(Consola.leerProfesor());
		} catch (OperationNotSupportedException e) {
			System.out.println(ERROR+": "+e.getMessage());
		}
	}

	public void borrarProfesor() {
		System.out.println("BORRAR PROFESOR");
		try {
			controlador.borrarProfesor(new Profesor(Consola.leerNombreProfesor(), "-"));
		} catch (OperationNotSupportedException e) {
			System.out.println(ERROR+": "+e.getMessage());
		}
	}

	public void buscarProfesor() {
		System.out.println("BUSCAR PROFESOR");
		Profesor p = controlador.buscarProfesor(new Profesor(Consola.leerNombreProfesor(), "-"));
		if(p == null) {
			System.out.println("No existe el aula buscada");
		}else {
			System.out.println(p.toString());
		}
	}

	public void listarProfesores() {
		System.out.println("LISTADO DE PROFESORES");
		List<String> p = controlador.representarProfesores();
		for (String profesor : p) {
			System.out.println(profesor);
		}
		System.out.println("TOTAL PROFESORES: "+p.size());
	}

	public void realizarReserva() {
		System.out.println("REALIZAR RESERVA");
		Profesor p = Consola.leerProfesor();
		Reserva r = leerReserva(p);
		if(controlador.buscarProfesor(p) == null) {
			System.out.println("No existe el profesor "+p.getNombre());
		}else if(controlador.buscarAula(r.getAula()) == null) {
			System.out.println("No existe el aula "+r.getAula().getNombre());
		}else {
			try {
				controlador.realizarReserva(r);
			} catch (OperationNotSupportedException e) {
				System.out.println(ERROR+": "+e.getMessage());
			}
		}
	}

	private Reserva leerReserva(Profesor profesor) {
		Aula a = Consola.leerAula();
		Permanencia per = Consola.leerPermanencia();
		return new Reserva(profesor, a, per);
	}

	public void anularReserva() {
		System.out.println("ANULAR RESERVA");
		Profesor p = Consola.leerProfesor();
		Reserva r = leerReserva(p);
		if(controlador.buscarProfesor(p) == null) {
			System.out.println("No existe el profesor "+p.getNombre());
		}else if(controlador.buscarAula(r.getAula()) == null) {
			System.out.println("No existe el aula "+r.getAula().getNombre());
		}else {
			try {
				controlador.anularReserva(r);
			} catch (OperationNotSupportedException e) {
				System.out.println(ERROR+": "+e.getMessage());
			}
		}
		
	}
	
	public void listarReservas() {
		System.out.println("LISTADO DE RESERVAS");
		List<String> r = controlador.representarReservas();
		for (String reserva : r) {
			System.out.println(reserva);
		}
		System.out.println("TOTAL RESERVAS: "+r.size());
		
	}
	
	public void listarReservasAula() {
		System.out.println("LISTADO DE RESERVAS DE AULA");
		Aula a = Consola.leerAula();
		if(controlador.buscarAula(a) == null) {
			System.out.println("No existe el aula "+a.getNombre());
		}else {
			List<Reserva> r = controlador.getReservasAula(a);
			for (Reserva reserva : r) {
				System.out.println(reserva.toString());
			}
		}
	}
	
	public void listarReservasProfesor() {
		System.out.println("LISTADO DE RESERVAS DE PROFESOR");
		Profesor p = Consola.leerProfesor();
		if(controlador.buscarProfesor(p) == null) {
			System.out.println("No existe el profesor "+p.getNombre());
		}else {
			List<Reserva> r = controlador.getReservasProfesor(p);
			for (Reserva reserva : r) {
				System.out.println(reserva.toString());
			}
		}
	}
	
	public void listarReservasPermanencia() {
		System.out.println("LISTADO DE RESERVAS POR PERMANENCIA");
		Permanencia p = Consola.leerPermanencia();
		List<Reserva> r = controlador.getReservasPermanencia(p);
		for (Reserva reserva : r) {
			System.out.println(reserva.toString());
		}
	}
	
	public void consultarDisponibilidad() {
		System.out.println("CONSULTAR DISPONIBILIDAD");
		Aula a = Consola.leerAula();
		Permanencia p = Consola.leerPermanencia();
		if(controlador.buscarAula(a) == null) {
			System.out.println("No existe el aula "+a.getNombre());
		}else if(controlador.consultarDisponibilidad(a, p)){
			System.out.println("El aula "+a.getNombre()+" esta disponible "+p.toString());
		}else {
			System.out.println("El aula "+a.getNombre()+" no esta disponible "+p.toString());
		}
	}
}
