// Para ejecutarlo primero compilamos desde la carpeta src con el comando "javac Hilos/Hilos3/Hilo.java"
// Despues ejecutamos desde la carpeta src con el comando "java Hilos/Hilos3/Hilo"

package Hilos.Hilos3;

public class Hilo {

	public static void main(String[] args) {
		
		CrearHilo hilo = null;
		
		for (int i = 1; i <= 3; i++) {
			
			hilo = new CrearHilo();
			hilo.setName("hilo"+i);
			hilo.setPriority(1);
			hilo.start();
			
			System.out.println("Info del hilo " + hilo.getName() + ":\n" + hilo.toString() + "\n");
		}
		
		System.out.println(" --- Tres hilos creados. --- ");
	}
}