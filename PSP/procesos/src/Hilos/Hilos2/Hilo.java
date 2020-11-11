package Hilos.Hilos2;

public class Hilo extends Thread {

	public int ih;
	
	public Hilo(int i) { this.ih = i; }

	public void run() {
		
		System.out.println("Creando hilo " + ih);
		for (int i = 1; i <= 3; i++) { System.out.println("Hilo: h" + i); }
	}
}
