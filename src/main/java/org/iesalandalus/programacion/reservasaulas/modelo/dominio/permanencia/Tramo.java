package org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia;

public enum Tramo {
	
    MANANA("Mañana"), TARDE("Tarde");
    private String cadenaAMostrar;
    
    private Tramo(String tramo) {
        this.cadenaAMostrar = tramo;
    }
    
    public String toString() {
        return cadenaAMostrar;
    }
}
