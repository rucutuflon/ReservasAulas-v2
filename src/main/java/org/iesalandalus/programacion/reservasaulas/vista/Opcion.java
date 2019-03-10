package org.iesalandalus.programacion.reservasaulas.vista;

import org.iesalandalus.programacion.reservasaulas.controlador.ControladorReservasAulas;
import org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.ModeloReservasAulas;

public enum Opcion {

	SALIR ("0. Salir") {

		@Override
		public void ejecutar() {
			vista.salir();
		}
		
	}, 
	INSERTAR_AULA("1. Insertar un aula") {

		@Override
		public void ejecutar() {
			vista.insertarAula();
		}
		
	}, 
	BORRAR_AULA("2. Borrar aula") {

		@Override
		public void ejecutar() {
			vista.borrarAula();
		}
		
	}, 
	BUSCAR_AULA("3. Buscar aula") {

		@Override
		public void ejecutar() {
			vista.buscarAula();
		}
		
	},
	LISTAR_AULAS("4. Listar aulas") {

		@Override
		public void ejecutar() {
			vista.listarAulas();
		}
		
	},  
	INSERTAR_PROFESORES("5. Insertar profesor") {

		@Override
		public void ejecutar() {
			vista.insertarProfesor();
		}
		
	}, 
	BORRAR_PROFESOR("6. Borrar profesor") {

		@Override
		public void ejecutar() {
			vista.borrarProfesor();
		}
		
	},
	BUSCAR_PROFESOR("7. Buscar profesor") {

		@Override
		public void ejecutar() {
			vista.buscarProfesor();
		}
			
	},
	LISTAR_PROFESORES("8. Listar profesores") {

		@Override
		public void ejecutar() {
			vista.listarProfesores();
		}
		
	}, 
	INSERTAR_RESERVA("9. Hacer reserva") {

		@Override
		public void ejecutar() {
			vista.realizarReserva();
		}
		
	}, 
	BORRAR_RESERVA("10. Borrar reserva") {

		@Override
		public void ejecutar() {
			vista.anularReserva();
		}
		
	},
	LISTAR_RESERVAS("11. Listar reservas") {

		@Override
		public void ejecutar() {
			vista.listarReservas();
		}
		
	},
	LISTAR_RESERVAS_AULA("12. Listar reservas del aula") {

		@Override
		public void ejecutar() {
			vista.listarReservasAula();
		}
		
	},
	LISTAR_RESERVAS_PROFESOR("13. Listar reservas de profesores") {

		@Override
		public void ejecutar() {
			vista.listarReservasProfesor();
		}
		
	},
	LISTAR_RESERVAS_PERMANENCIA("14. Listar permanencia de reservas") {

		@Override
		public void ejecutar() {
			vista.listarReservasPermanencia();
		}
		
	},
	CONSULTAR_DISPONIBILIDAD("15. Consultar disponibilidad") {

		@Override
		public void ejecutar() {
			vista.consultarDisponibilidad();
		}
		
	};
	
	private String mensajeAMostrar;
	private static IVistaReservasAulas vista = new VistaReservasAulas();
	
	private Opcion (String mensajeAMostrar) {
		this.mensajeAMostrar = mensajeAMostrar;
	}
	public String getMensaje () {
		return mensajeAMostrar;
	}
	
	public abstract void ejecutar();
	
	protected static void setVista (VistaReservasAulas iu) {
		vista = iu;
	}
	
	public String toString () {
		return mensajeAMostrar;
	}
	
	public static Opcion getOpcionSegunOrdinal (int n) {
		return values()[n];
	}
	
	public static boolean esOrdinalValido (int n) {
		return n >= 0 && n < values().length;
	}
}
