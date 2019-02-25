package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;

public class Profesores {

	private static final int MAX_PROFESORES = 10;
	private int numProfesores;
	private Profesor[] coleccionProfesores;
	
	public Profesores() {
		this.numProfesores = 0;
		this.coleccionProfesores = new Profesor[MAX_PROFESORES];
	}
	
	public Profesores(Profesores p) {
		if(p == null) {
			throw new IllegalArgumentException("No se pueden copiar profesores nulos.");
		}
		this.numProfesores = p.numProfesores;
		setProfesores(p);
	}

	private void setProfesores(Profesores profesores) {
		this.coleccionProfesores = copiaProfundaProfesores(profesores.coleccionProfesores);
	}
	
	private Profesor[] copiaProfundaProfesores(Profesor[] c) {
		Profesor[] aux = new Profesor[MAX_PROFESORES];
		for (int i = 0; i < aux.length; i++) {
			if(c[i] == null) {
				aux[i] = null;
			}else {
				aux[i] = new Profesor(c[i]);
			}
		}
		return aux;
	}

	public int getNumProfesores() {
		return numProfesores;
	}

	public Profesor[] getProfesores() {
		return copiaProfundaProfesores(coleccionProfesores);
	}
	
	public void insertar(Profesor profesor) throws OperationNotSupportedException{
		if(profesor == null) {
			throw new IllegalArgumentException("No se puede insertar un profesor nulo.");
		}
		if(buscarIndiceProfesor(profesor) != -1) {
			throw new OperationNotSupportedException("El profesor ya existe.");
		}
		if (!indiceNoSuperaTamano(numProfesores)) {
			throw new OperationNotSupportedException("Tamaño de profesores superado.");
		}
		this.coleccionProfesores[numProfesores] = profesor;
		numProfesores++;
		
	}
	
	private int buscarIndiceProfesor(Profesor profesor) {
		for (int i = 0; i < coleccionProfesores.length; i++) {
			if(coleccionProfesores[i] != null && coleccionProfesores[i].equals(profesor)) {
				return i;
			}
		}
		return -1;
		
	}
	
	private boolean indiceNoSuperaTamano(int profesores) {
		return profesores >= 0 && profesores < numProfesores;
		
	}
	
	private boolean indiceNoSuperaCapacidad(int profesores) {
		return profesores >= 0 && profesores < coleccionProfesores.length;
		
	}
	
	public Profesor buscar(Profesor profesor) {
		int index = buscarIndiceProfesor(profesor);
		if(index == -1) {
			return null;
		}
		return coleccionProfesores[index];
		
	}
	
	public void borrar(Profesor profesor) throws OperationNotSupportedException {
		if(profesor == null) {
			throw new IllegalArgumentException("No se puede borrar un profesor nulo.");
		}
		int index = buscarIndiceProfesor(profesor);
		if(index == -1) {
			throw new OperationNotSupportedException("El profesor a borrar no existe.");
		}
		desplazarUnaPosicionHaciaIzquierda(index);
		numProfesores--;
	}
	
	private void desplazarUnaPosicionHaciaIzquierda(int profesores) {
		for (int i = profesores; i < coleccionProfesores.length-1; i++) {
			coleccionProfesores[i] = coleccionProfesores[i+1];
		}
		coleccionProfesores[MAX_PROFESORES-1] = null;
	}
	
	public String[] representar() {
		String[] aux = new String[numProfesores];
		for (int i = 0; i < numProfesores; i++) {
			aux[i] = coleccionProfesores[i].toString();
		}
		return aux;
	}
}