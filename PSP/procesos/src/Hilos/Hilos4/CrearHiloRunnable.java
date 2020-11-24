package Hilos.Hilos4;

public class CrearHiloRunnable implements Runnable {

	private int id;

	public CrearHiloRunnable(int id) { this.id = id; }

	public void run() {
		for (int i = 0; i < 100; i++) { System.out.println("[R]Ejecutándose hilo: " + id + " Contador: " + i); }
	}
}