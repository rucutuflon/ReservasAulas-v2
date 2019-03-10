package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;

public class Aulas {

	private List<Aula> coleccionAulas;
	
	public Aulas() {
		this.coleccionAulas = new ArrayList<Aula>();
	}
	
	public Aulas(Aulas a) {
		if(a == null) {
			throw new IllegalArgumentException("No se pueden copiar aulas nulas.");
		}
		setAulas(a);
	}
	
	private void setAulas(Aulas aulas) {
		this.coleccionAulas = copiaProfundaAulas(aulas.coleccionAulas);
	}
	
	private List<Aula> copiaProfundaAulas(List<Aula> lista) {
		List<Aula> aux = new ArrayList<Aula>();
		for (Aula a : lista) {
			aux.add(new Aula(a));
		}
		return aux;
	}

	public List<Aula> getAulas() {
		return copiaProfundaAulas(coleccionAulas);
	}

	public int getNumAulas() {
		return this.coleccionAulas.size();
	}
	
	public void insertar(Aula aula) throws OperationNotSupportedException{
		if(aula == null) {
			throw new IllegalArgumentException("No se puede insertar un aula nula.");
		}
		if(buscar(aula) != null) {
			throw new OperationNotSupportedException("El aula ya existe.");
		}
		this.coleccionAulas.add(new Aula(aula));
	}
	
	
	public Aula buscar(Aula aula) {
		int index = this.coleccionAulas.indexOf(aula);
		if(index == -1) {
			return null;
		}
		return new Aula(coleccionAulas.get(index));
		
	}
	
	public void borrar(Aula aula) throws OperationNotSupportedException{
		if(aula == null) {
			throw new IllegalArgumentException("No se puede borrar un aula nula.");
		}
		if(this.coleccionAulas.remove(aula) == false) {
			throw new OperationNotSupportedException("El aula a borrar no existe.");
		}
	}
	
	public List<String> representar() {
		List<String> aux = new ArrayList<String>();
		for (int i = 0; i < coleccionAulas.size(); i++) {
			aux.add(coleccionAulas.get(i).toString());
		}
		return aux;
	}
}
