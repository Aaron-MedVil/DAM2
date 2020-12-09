package Hilos.Hilos9;

public class Hilo extends Thread implements Runnable {

	/**
	 * Funcion quese ejecuta el hilo
	 */
	@Override
	public void run() {
		
		int n = 0;
		
		while(n != 2) {
			
			System.out.printf("Hilo %s random %d %n", this.getName(), n);
			n = (int) (Math.random() * 10);
		}
		
		System.out.printf("Fin del hilo %s %n", this.getName());
	}
}