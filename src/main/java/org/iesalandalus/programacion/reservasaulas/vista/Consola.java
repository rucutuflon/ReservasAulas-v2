package org.iesalandalus.programacion.reservasaulas.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Tramo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

	private static final DateTimeFormatter FORMATO_DIA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private Consola() {
	}
		
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
			System.out.println("Opcion no valida");
			valido = Opcion.esOrdinalValido(opcion);
			if(!valido) {
				System.out.println("Opci�n no valida");
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
		case "Mañana":return Tramo.MANANA;
		default: return Tramo.TARDE;
		}
		
	}
	
	public static LocalDate leerDia() {
		String aux = "";
		LocalDate dia = null;
		do {
			System.out.println("Introduzca el dia:");
			aux = Entrada.cadena();
			try {
				dia = LocalDate.parse(aux, FORMATO_DIA);
			}catch (DateTimeParseException e) {
				System.out.println("Formato de fecha incorrecto (dd/MM/yyyy)");
			}
		} while (dia == null);
		return dia;
	}
}
