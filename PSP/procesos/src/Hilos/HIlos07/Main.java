package Hilos.HIlos07;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		final int t = 2000;
		
		Hilo h = new Hilo();
		
		// Ejecutamos el hilo
		h.start();
		
		Thread.sleep(t);
		
		// Suspendemos el hilo
		h.suspender();
		
		Thread.sleep(t);
		
		// Reanudamos el hilo
		h.reanudar();
		
		Thread.sleep(t);
		
		// Interrumpimos el hilo
		h.interrupt();
	}
}