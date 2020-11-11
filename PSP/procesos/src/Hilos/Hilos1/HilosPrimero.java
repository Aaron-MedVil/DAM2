package Hilos.Hilos1;

public class HilosPrimero extends Thread {
	
	public void run() {
		
		for (int i = 0; i < 5; i++) {
			
			System.out.println("Dentro del hilo " + i);
		}
	}
}