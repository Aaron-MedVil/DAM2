package Hilos.Hilos4;

public class Hilo {

	public static void main(String[] args) {
		
		Thread chr = new Thread();
		CrearHiloThread cht = new CrearHiloThread();
		
		chr.run();
		cht.start();
		for (int i = 0; i < 3; i++) { System.out.println("Hilo_Main[" + i + "]"); }
	}
}