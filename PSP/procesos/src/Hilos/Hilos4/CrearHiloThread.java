package Hilos.Hilos4;

public class CrearHiloThread extends Thread {

	private int id;

	public CrearHiloThread(int id) { this.id = id; }

	public void run() {
		for (int i = 0; i < 100; i++) { System.out.println("[T]Ejecutándose el hilo " + id + " Contador: " + i); }
	}
}
