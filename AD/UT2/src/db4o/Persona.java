package db4o;

public class Persona {
	
	private String nombre, ciudad;

	/**
	 * Constructor con parametros
	 * @param nombre
	 * @param ciudad
	 */
	public Persona(String nombre, String ciudad) {
		this.nombre = nombre;
		this.ciudad = ciudad;
	}
	
	/**
	 * Constructor con parametros vacios
	 */
	public Persona() {
		this.nombre = null;
		this.ciudad = null;
	}

	/**
	 * Getter/Setter nombre
	 * @return
	 */
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	/**
	 * Getter/Setter ciudad
	 * @return
	 */
	public String getCiudad() { return ciudad; }
	public void setCiudad(String ciudad) { this.ciudad = ciudad; }
}