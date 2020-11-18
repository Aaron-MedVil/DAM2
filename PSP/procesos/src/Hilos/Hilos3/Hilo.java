package Hilos.Hilos3;

public class Hilo {

	public static void main(String[] args) {
		
		CrearHilo hilo = null;
		
		for (int i = 1; i <= 3; i++) {
			
			hilo = new CrearHilo();
			hilo.setName("hilo"+i);
			hilo.setPriority(1);
			hilo.start();
			
			System.err.println("Info del hilo " + hilo.getName() + ":\n" + hilo.toString());
		}
		
		System.out.println("Tres hilos creados.");
	}
}