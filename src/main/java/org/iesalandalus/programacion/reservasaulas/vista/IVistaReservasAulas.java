package org.iesalandalus.programacion.reservasaulas.vista;

public interface IVistaReservasAulas {
	
	public void comenzar ();
	
	public void salir();

	public void insertarAula();

	public void borrarAula();

	public void buscarAula();

	public void listarAulas();

	public void insertarProfesor();

	public void borrarProfesor();

	public void buscarProfesor();

	public void listarProfesores();

	public void realizarReserva();

	public void anularReserva();
	
	public void listarReservas();
	
	public void listarReservasAula();
	
	public void listarReservasProfesor();
	
	public void listarReservasPermanencia();
	
	public void consultarDisponibilidad();

}
