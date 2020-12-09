package Hilos.HIlos7;

public class Hilo extends Thread {

	private boolean suspendido;
	
	/**
	 * Suspende la ejecucion del hilo
	 */
	public synchronized void suspender() {
		System.out.println("Suspendiendo el hilo");
		suspendido = true;
	}
	
	/**
	 * Reanuda la ejecucion del hilo
	 */
	public synchronized void reanudar() {
		System.out.println("Reanudando el hilo");
		suspendido = false;
		notifyAll();
	}
	
	/**
	 * Metodo que ejecuta el hilo cuando esta en suspension
	 * @throws InterruptedException 
	 */
	public synchronized void enSuspension() throws InterruptedException {
		while(suspendido) {
			wait();
			System.out.println("Hilo en espera");
		}
	}
	
	/**
	 * Metodo que ejecuta el hilo
	 */
	public void run() {
		
		while(!isInterrupted()) {
			try { enSuspension(); }
			catch (InterruptedException e) { interrupt(); }
			System.out.println("Soy un hilo activo");
		}
		
		System.out.println("El hilo ha muerto");
	}
}