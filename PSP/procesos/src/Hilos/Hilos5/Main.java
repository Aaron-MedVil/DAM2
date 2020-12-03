package Hilos.Hilos5;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		Hilo h = new Hilo();
		h.start();
		
		Thread.sleep(2000);
		h.interrupt();
		
		// if (h.isInterrupted() == true) { System.out.println("El hilo ha muerto"); }
		// else { System.out.println("Hilo en ejecucion"); }
	}
}