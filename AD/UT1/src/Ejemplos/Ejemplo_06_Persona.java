package Ejemplos;

import java.io.Serializable;

public class Ejemplo_06_Persona implements Serializable {
	
	private String nombre;
	private int edad;
	
	public Ejemplo_06_Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
}
