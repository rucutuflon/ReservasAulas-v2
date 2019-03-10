package org.iesalandalus.programacion.reservasaulas.modelo.dominio;

public class Profesor {
	
	private static final String ER_TELEFONO="([69]{1}[0-9]{8})";
	private static final String ER_CORREO="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
	
	private String nombre;
	private String correo;
	private String telefono;
	
	public Profesor(String nombre, String correo) {
		setNombre(nombre);
		setCorreo(correo);
	}
	
	public Profesor(String nombre, String correo, String telefono) {
		this(nombre, correo);
		setTelefono(telefono);
	}
	
	public Profesor(Profesor p) {
		if(p == null) {
			throw new IllegalArgumentException("No se puede copiar un profesor nulo.");
		}
		this.nombre = p.nombre;
		this.correo = p.correo;
		this.telefono = p.telefono;
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		if(nombre == null) {
			throw new IllegalArgumentException("El nombre del profesor no puede ser nulo.");
		}
		if(nombre.isEmpty()) {
			throw new IllegalArgumentException("El nombre del profesor no puede estar vacío.");
		}
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		if(correo == null) {
			throw new IllegalArgumentException("El correo del profesor no puede ser nulo.");
		}
		if(correo.isEmpty()) {
			throw new IllegalArgumentException("El correo del profesor no es válido.");
		}
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		if(telefono != null && telefono.isEmpty()) {
			throw new IllegalArgumentException("El teléfono del profesor no es válido.");
		}
		this.telefono = telefono;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[nombre=" + nombre + ", correo=" + correo + (telefono == null ? "":", telefono=" + telefono) + "]";
	}
	
}
