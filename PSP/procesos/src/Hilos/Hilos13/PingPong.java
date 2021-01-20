package Hilos.Hilos13;

public class PingPong {
	
	private boolean disponible = false;
	
	/**
	 * Metodo para imprimir PING
	 */
	public synchronized void ping() {
		
		while(disponible == false) {
			
			try { wait(); }
			catch (InterruptedException e) {}
		}
		
		System.out.println("Ping");
		
		disponible = false;
		notifyAll();
	}
	
	/**
	 * Metodo para imprimir PONG
	 */
	public synchronized void pong() {
		
		while(disponible == true) {
			
			try { wait(); }
			catch (InterruptedException e) {}
		}
		
		System.out.println("Pong");
		disponible = true;
		notifyAll();
	}
}