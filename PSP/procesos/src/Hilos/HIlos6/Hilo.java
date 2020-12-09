package Hilos.HIlos6;

public class Hilo extends Thread {

	public void run() {
		
		while(!interrupted()) {
			
			try { Thread.sleep(5000); }
			catch (Exception e) { interrupt(); }
			
			System.out.println("Hola, soy un hilo activo");
		}
		
		System.out.println("El hilo ha muerto");
	}
}
