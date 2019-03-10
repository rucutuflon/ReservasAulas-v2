package org.iesalandalus.programacion.reservasaulas.vista;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.PermanenciaPorHora;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.PermanenciaPorTramo;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Tramo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

	private static final DateTimeFormatter FORMATO_DIA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final DateTimeFormatter FORMATO_HORA = DateTimeFormatter.ofPattern("HH:mm");
	private Consola() {}
		
	public static void mostrarMenu () {
		Opcion[] opciones = Opcion.values();
		for (int i = 0; i < opciones.length; i++) {
			System.out.println(opciones[i].getMensaje());
		}
	}
	
	public static void mostrarCabecera(String mensaje) {
		System.out.println(mensaje);
	}
	
	public static int elegirOpcion() {
		int opcion = -1;
		boolean valido = true;
		do {
			System.out.println("Elija opcion:");
			opcion = Entrada.entero();
			valido = Opcion.esOrdinalValido(opcion);
			if(!valido) {
				System.out.println("Opción no valida");
			}
		} while (!valido);
		return opcion;
	}
	
	
	public static String leerNombreAula() {
		String nombre = "";
		do {
			System.out.println("Introduzca el nombre del aula:");
			nombre = Entrada.cadena();
		} while (nombre.isEmpty());
		return nombre;
	}
	
	public static Aula leerAula() {
		return new Aula(leerNombreAula());
	}
	
	public static Profesor leerProfesor() {
		String nombre = leerNombreProfesor();
		String correo = "";
		do {
			System.out.println("Introduzca el correo del profesor:");
			correo = Entrada.cadena();
		} while (correo.isEmpty());
		return new Profesor(nombre, correo);
	}
	
	public static String leerNombreProfesor() {
		String nombre = "";
		do {
			System.out.println("Introduzca el nombre del profesor:");
			nombre = Entrada.cadena();
		} while (nombre.isEmpty());
		return nombre;
	}
	
	public static Tramo leerTramo() {
		String aux = "";
		do {
			System.out.println("Introduzca el tramo:");
			aux = Entrada.cadena();
		} while (aux.isEmpty() && !aux.equals("Mañana") && !aux.equals("Tarde"));
		switch (aux) {
		case "MaÃ±ana":return Tramo.MANANA;
		default: return Tramo.TARDE;
		}
		
	}
	
	public static String leerDia() {
		String aux = "";
		LocalDate dia = null;
		do {
			System.out.println("Introduzca el dia:");
			aux = Entrada.cadena();
			try {
				dia = LocalDate.parse(aux, FORMATO_DIA);
			}catch (DateTimeParseException e) {
				System.out.println("Formato de fecha incorrecto ("+FORMATO_DIA+")");
			}
		} while (dia == null);
		return aux;
	}
	
	public static String leerHora() {
		String aux = "";
		LocalTime hora = null;
		do {
			System.out.println("Introduzca la hora:");
			aux = Entrada.cadena();
			try {
				hora = LocalTime.parse(aux, FORMATO_HORA);
			}catch (DateTimeParseException e) {
				System.out.println("Formato de hora incorrecto ("+FORMATO_HORA+")");
			}
		} while (hora == null);
		return aux;
	}
	
	public static Permanencia leerPermanencia() {
		String dia = leerDia();
		int tipo = elegirPermanencia();
		
		switch (tipo) {
		case 1: return new PermanenciaPorTramo(dia, leerTramo());
		default: 
			boolean bien=false;
			Permanencia p=null;
			do {
				try {
					p= new PermanenciaPorHora(dia, leerHora());
					bien = true;
				} 
				catch (IllegalArgumentException e) {
					System.out.println("Error: "+e.getMessage());
				}
			}while (bien == false);
			return p;
		}
	}
	
	public static int elegirPermanencia() {
		int aux = 0;
		do {
			System.out.println("Elija tipo de permanencia\n1.- Por Tramo\n2.- Por Hora:");
			aux = Entrada.entero();
		} while (aux != 1 && aux != 2);
		return aux;
	}
}
