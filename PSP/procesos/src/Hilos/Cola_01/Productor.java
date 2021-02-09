package Hilos.Cola_01;

public class Productor extends Thread {

	private Cola c;
	private int n;
	
	/**
	 * Constructor de la clase
	 * @param c
	 * @param n
	 */
	public Productor(Cola c, int n) {
		this.c = c;
		this.n = n;
	}
	
	/**
	 * Metodo para ejecutar la clase
	 */
	public void run() {
		
		for (int i = 0; i < 5; i++) {
			
			c.put(i);
			System.out.println(i + "=>Productor: " + n + " produce: " + i);
			
			try { sleep(100); }
			catch (InterruptedException e) {}
		}
	}
}
