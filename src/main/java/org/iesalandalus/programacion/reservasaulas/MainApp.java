package org.iesalandalus.programacion.reservasaulas;

import org.iesalandalus.programacion.reservasaulas.vista.Consola;
import org.iesalandalus.programacion.reservasaulas.vista.Opcion;

public class MainApp {

	public static void main(String[] args) {
		System.out.println("Programa para la gestión de reservas de espacios del IES Al-Andalus");
		int opcion = 0;
		
		do {
			Consola.mostrarCabecera("==========IES Al-Andalus==========");
			Consola.mostrarMenu();
			opcion = Consola.elegirOpcion();
			Opcion.getOpcionSegunOrdinal(opcion).ejecutar();
		} while (opcion != 0);
	
	}

}
