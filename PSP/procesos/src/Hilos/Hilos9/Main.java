package Hilos.Hilos9;

public class Main {

	public static void main(String[] args) {
		
		Hilo h = new Hilo();
		Hilo h1 = new Hilo();
		
		h.start(); h1.start();
	}
}