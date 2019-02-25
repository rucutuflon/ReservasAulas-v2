package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;

public class Aulas {

	private static final int MAX_AULAS = 10;
	private int numAulas;
	private Aula[] coleccionAulas;
	
	public Aulas() {
		this.numAulas = 0;
		this.coleccionAulas = new Aula[MAX_AULAS];
	}
	
	public Aulas(Aulas a) {
		if(a == null) {
			throw new IllegalArgumentException("No se pueden copiar aulas nulas.");
		}
		this.numAulas = a.numAulas;
		setAulas(a);
	}
	
	private void setAulas(Aulas aulas) {
		this.coleccionAulas = copiaProfundaAulas(aulas.coleccionAulas);
	}
	
	private Aula[] copiaProfundaAulas(Aula[] c) {
		Aula[] aux = new Aula[MAX_AULAS];
		for (int i = 0; i < aux.length; i++) {
			if(c[i] == null) {
				aux[i] = null;
			}else {
				aux[i] = new Aula(coleccionAulas[i]);
			}
		}
		return aux;
	}

	public Aula[] getAulas() {
		return copiaProfundaAulas(coleccionAulas);
	}

	public int getNumAulas() {
		return numAulas;
	}
	
	public void insertar(Aula aula) throws OperationNotSupportedException{
		if(aula == null) {
			throw new IllegalArgumentException("No se puede insertar un aula nula.");
		}
		if(buscarIndiceAula(aula) != -1) {
			throw new OperationNotSupportedException("El aula ya existe.");
		}
		if (!indiceNoSuperaTamano(numAulas)) {
			throw new OperationNotSupportedException("Tamaño de aulas superada.");
		}
		this.coleccionAulas[numAulas] = new Aula(aula);
		numAulas++;
	}
	
	private int buscarIndiceAula(Aula aula) {
		for (int i = 0; i < coleccionAulas.length; i++) {
			if(coleccionAulas[i] != null && coleccionAulas[i].equals(aula)) {
				return i;
			}
		}
		return -1;
		
	}
	
	private boolean indiceNoSuperaTamano(int aulas) {
		return aulas >= 0 && aulas < numAulas;
		
	}
	
	private boolean indiceNoSuperaCapacidad(int aulas) {
		return aulas >= 0 && aulas < coleccionAulas.length;
		
	}
	
	public Aula buscar(Aula aula) {
		int index = buscarIndiceAula(aula);
		if(index == -1) {
			return null;
		}
		return new Aula(coleccionAulas[index]);
		
	}
	
	public void borrar(Aula aula) throws OperationNotSupportedException{
		if(aula == null) {
			throw new IllegalArgumentException("No se puede borrar un aula nula.");
		}
		int index = buscarIndiceAula(aula);
		if(index == -1) {
			throw new OperationNotSupportedException("El aula a borrar no existe.");
		}
		desplazarUnaPosicionHaciaIzquierda(index);
		numAulas--;
		
	}
	
	private void desplazarUnaPosicionHaciaIzquierda(int aulas) {
		for (int i = aulas; i < coleccionAulas.length-1; i++) {
			coleccionAulas[i] = coleccionAulas[i+1];
		}
		coleccionAulas[MAX_AULAS-1] = null;
	}
	
	public String[] representar() {
		String[] aux = new String[numAulas];
		for (int i = 0; i < numAulas; i++) {
			aux[i] = coleccionAulas[i].toString();
		}
		return aux;
	}
}
