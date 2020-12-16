package Hilos.Hilos05;

public class Hilo extends Thread {

	public void run() {
		
		while (!interrupted()) { System.out.println("Hola, soy un hilo activo"); }
		
		System.out.println("El hilo ha muerto");
	}
}