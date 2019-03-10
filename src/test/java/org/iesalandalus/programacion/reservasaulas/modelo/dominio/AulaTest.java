package org.iesalandalus.programacion.reservasaulas.modelo.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class AulaTest {

	private static final String ERROR_EXCEPCION = "Deber铆a haber saltado la excepci贸n.";
	private static final String ERROR_NO_EXCEPCION = "No deber铆a haber saltado la excepci贸n.";
	
	private static final String NOMBRE = "Sal贸n de actos";
	private static final int PUESTOS = 30;

	@Test
	public void constructorValidoTest() {
		Aula aula = null;
		try {
			aula = new Aula(NOMBRE, PUESTOS);
			assertEquals(NOMBRE, aula.getNombre());
			assertEquals(PUESTOS, aula.getPuestos());
			assertTrue(15 == aula.getPuntos());
		} catch (IllegalArgumentException e) {
			fail(ERROR_NO_EXCEPCION);
		}
	}
	
	@Test
	public void constructorNoValidoTest() {
		Aula aula = null;
		try {
			String nombre = null;
			aula = new Aula(nombre, PUESTOS);
			fail(ERROR_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El nombre del aula no puede ser nulo.", e.getMessage());
			assertNull(aula);
		}
		try {
			aula = new Aula("", PUESTOS);
			fail(ERROR_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El nombre del aula no puede estar vac韔.", e.getMessage());
			assertNull(aula);
		}
		try {
			aula = new Aula(NOMBRE, 9);
			fail(ERROR_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El n鷐ero de puestos no es correcto.", e.getMessage());
			assertNull(aula);
		}
		try {
			aula = new Aula(NOMBRE, 101);
			fail(ERROR_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El n鷐ero de puestos no es correcto.", e.getMessage());
			assertNull(aula);
		}
	}
	
	@Test
	public void constructorCopiaValidoTest() {
		Aula aula = new Aula(NOMBRE, PUESTOS);
		Aula aula1;
		try {
			aula1 = new Aula(aula);
			assertEquals(NOMBRE, aula1.getNombre());
			assertEquals(PUESTOS, aula1.getPuestos());
			assertTrue(15 == aula.getPuntos());
		} catch (IllegalArgumentException e) {
			fail(ERROR_NO_EXCEPCION);
		}
	}
	
	@Test
	public void constructorCopiaNoValidoTest() {
		Aula aula = null;
		try {
			Aula aula1 = null;
			aula = new Aula(aula1);
			fail(ERROR_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("No se puede copiar un aula nula.", e.getMessage());
			assertNull(aula);
		}
	}
	
	@Test
	public void getTest() {
		Aula aula = new Aula(NOMBRE, PUESTOS);
		assertEquals(NOMBRE, aula.getNombre());
		assertEquals(PUESTOS, aula.getPuestos());
	}
	
	@Test
	public void hasCodeTest() {
		Aula aula = new Aula(NOMBRE, PUESTOS);
		Aula aula1 = new Aula(NOMBRE, 20);
		Aula aula2 = new Aula("Andr茅s", PUESTOS);
		assertEquals(aula.hashCode(), aula.hashCode());
		assertEquals(aula.hashCode(), aula1.hashCode());
		assertNotEquals(aula.hashCode(), aula2.hashCode());
	}
	
	@Test
	public void equalTest() {
		Aula aula = new Aula(NOMBRE, PUESTOS);
		Aula aula1 = new Aula(NOMBRE, 20);
		Aula aula2 = new Aula("Andr茅s", PUESTOS);
		assertNotEquals(aula, null);
		assertNotEquals(aula, "");
		assertEquals(aula, aula);
		assertEquals(aula, aula1);
		assertNotEquals(aula, aula2);
	}
	
	@Test
	public void toStringTest() {
		Aula aula = new Aula(NOMBRE, PUESTOS);
		assertEquals("[nombre=Sal贸n de actos, puestos=30]", aula.toString());
	}

}
