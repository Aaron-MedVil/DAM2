package Hilos.Cola_02;

public class Consumidor extends Thread {
	
	private Cola c;
	private int n;
	
	/**
	 * Constructor de la clase
	 * @param c
	 * @param n
	 */
	public Consumidor(Cola c, int n) {
		this.c = c;
		this.n = n;
	}
	
	/**
	 * Metodo para ejecutar la clase
	 */
	public void run() {
		
		int valor = 0;
		
		for (int i = 0; i < 5; i++) {
			
			valor = c.get();
			System.out.println(i + "=>Consumidor: " + n + " consume: " + valor);
		}
	}
}