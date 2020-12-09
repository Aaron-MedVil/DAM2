package Hilos.HIlos7;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		Hilo h = new Hilo();
		
		// Ejecutamos el hilo
		h.start();
		
		Thread.sleep(2000);
		
		// Suspendemos el hilo
		h.suspender();
		
		Thread.sleep(2000);
		
		// Reanudamos el hilo
		h.reanudar();
		
		Thread.sleep(2000);
		
		// Interrumpimos el hilo
		h.interrupt();
	}
}