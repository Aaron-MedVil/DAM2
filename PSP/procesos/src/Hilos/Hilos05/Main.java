package Hilos.Hilos05;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		Hilo h = new Hilo();
		h.start();
		
		Thread.sleep(2000);
		h.interrupt();
	}
}