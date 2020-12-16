package Hilos.Hilos02;

public class UsaHilo {

	public static void main(String[] args) {
		
		for (int i = 1; i <= 3; i++) {
			
			Hilo h = new Hilo(i);
			h.run();
		}
		
		System.err.println("\n 3 hilos creados");
	}
}