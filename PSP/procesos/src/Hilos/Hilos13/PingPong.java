package Hilos.Hilos13;

public class PingPong {
	
	private int numero;
	private boolean disponible = false;
	
	public synchronized int ping() {
		
		while(disponible == false) {
			
			try { wait(); }
			catch (InterruptedException e) {}
		}
		
		disponible = false;
		notifyAll();
		return numero;
	}
	
	public synchronized void pong(int valor) {
		
		while(disponible == true) {
			
			try { wait(); }
			catch (InterruptedException e) {}
		}
		
		valor = numero;
		disponible = true;
		notifyAll();
	}
}