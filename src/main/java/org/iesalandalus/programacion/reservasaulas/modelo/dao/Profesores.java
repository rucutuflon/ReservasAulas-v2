package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;

public class Profesores {

	private List<Profesor> coleccionProfesores;
	
	public Profesores() {
		this.coleccionProfesores = new ArrayList<Profesor>();
	}
	
	public Profesores(Profesores p) {
		if(p == null) {
			throw new IllegalArgumentException("No se pueden copiar profesores nulos.");
		}
		setProfesores(p);
	}

	private void setProfesores(Profesores profesores) {
		this.coleccionProfesores = copiaProfundaProfesores(profesores.coleccionProfesores);
	}
	
	private List<Profesor> copiaProfundaProfesores(List<Profesor> lista) {
		List<Profesor> aux = new ArrayList<Profesor>();
		for (Profesor p : lista) {
			aux.add(new Profesor(p));
		}
		return aux;
	}

	public int getNumProfesores() {
		return this.coleccionProfesores.size();
	}

	public List<Profesor> getProfesores() {
		return copiaProfundaProfesores(coleccionProfesores);
	}
	
	public void insertar(Profesor profesor) throws OperationNotSupportedException{
		if(profesor == null) {
			throw new IllegalArgumentException("No se puede insertar un profesor nulo.");
		}
		if(buscar(profesor) != null) {
			throw new OperationNotSupportedException("El profesor ya existe.");
		}
		
		this.coleccionProfesores.add(new Profesor(profesor));
		
	}
	
	public Profesor buscar(Profesor profesor) {
		int index = this.coleccionProfesores.indexOf(profesor);
		if(index == -1) {
			return null;
		}
		return new Profesor(coleccionProfesores.get(index));
		
	}
	
	public void borrar(Profesor profesor) throws OperationNotSupportedException {
		if(profesor == null) {
			throw new IllegalArgumentException("No se puede borrar un profesor nulo.");
		}
		if(this.coleccionProfesores.remove(profesor) == false) {
			throw new OperationNotSupportedException("El profesor a borrar no existe.");
		}
	}
	
	public List<String> representar() {
		List<String> aux = new ArrayList<String>();
		for (int i = 0; i < coleccionProfesores.size(); i++) {
			aux.add(coleccionProfesores.get(i).toString());
		}
		return aux;
	}
}
