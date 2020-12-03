package Hilos.Hilos5;

public class Main {

	public static void main(String[] args) {
		
		Hilo h = new Hilo();
		h.start();
		h.interrupt();
	}
}