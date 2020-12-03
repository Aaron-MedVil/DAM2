package Hilos.Hilos5;

public class Hilo extends Thread {

	public void Run() {
		
		while (true) { System.out.println("Hola, soy un hilo activo"); }
	}
}