package Hilos.Hilos5;

public class Hilo extends Thread {

	public void run() {
		
		while (true) { System.out.println("Hola, soy un hilo activo"); }
	}
}