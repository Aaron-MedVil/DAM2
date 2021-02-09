package Hilos.Cola_01;

public class Cola {
	
	private int numero;
	private boolean disponible = false;
	
	/**
	 * Metodo para coger valores de la cola
	 * @return
	 */
	public int get() {
		
		// Si disponible es true hay un numero en la cola para coger
		if (disponible) {
			
			disponible = false;
			return numero;
		}
		
		// Devuelve -1 si no hay numero disponible
		return -1;
	}
	
	/**
	 * Metodo para agregar valores a la cola
	 * @param valor
	 */
	public void put(int valor) {
		
		// Coloca el valor en la cola
		numero = valor;
		
		// Disponible para consumir, cola llena
		disponible = true;
	}
}
