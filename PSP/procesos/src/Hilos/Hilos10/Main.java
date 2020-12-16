package Hilos.Hilos10;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		final int t = 200;
		
		// Instancias de los hilos
		Hilo h1 = new Hilo(), h2 = new Hilo(), h3 = new Hilo();
		
		// Propiedades de los hilos
		h1.setPriority(3); h2.setPriority(1); h3.setPriority(2);
		
		// Inicio de los hilos
		h1.start(); h2.start(); h3.start();
		
		// Tiempo que estara activo el hilo
		Thread.sleep(t);
		
		// Detiene los hilos
		h1.pararHilo(); h2.pararHilo(); h3.pararHilo();
	}
}