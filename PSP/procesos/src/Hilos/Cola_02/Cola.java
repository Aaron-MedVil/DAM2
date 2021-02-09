package Hilos.Cola_02;

public class Cola {
	
	private int numero;
	private boolean disponible = false;
	
	/**
	 * Metodo para coger valores de la cola
	 * @return
	 */
	public synchronized int get() {
		
		while(disponible == false) {
			try { wait(); }
			catch (InterruptedException e) {}
		}
		
		disponible = false;
		notifyAll();
		return numero;
	}
	
	/**
	 * Metodo para agregar valores a la cola
	 * @param valor
	 */
	public synchronized void put(int valor) {
		
		while(disponible == true) {
			
			try { wait(); }
			catch (InterruptedException e) {}
		}
		
		numero = valor;
		disponible = true;
		notifyAll();
	}
}