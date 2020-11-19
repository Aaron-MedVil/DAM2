package Hilos.Hilos4;

public class CrearHiloRunnable implements Runnable {
	
	public void run() {
		
		for (int i = 0; i < 3; i++) { System.out.println("Hilo_Runnable[" + i + "]"); }
	}
}