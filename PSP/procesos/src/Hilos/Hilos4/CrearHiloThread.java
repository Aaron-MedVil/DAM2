package Hilos.Hilos4;

public class CrearHiloThread extends Thread {

	public void run() {
		
		for (int i = 0; i < 3; i++) { System.out.println("Hilo_Thread[" + i + "]"); }
	}
}
