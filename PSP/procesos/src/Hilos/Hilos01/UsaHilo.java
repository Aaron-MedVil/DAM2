// Para ejecutar primero compilamos la aplicacion desde la carpeta src con el comando "javac Hilos/UsaHilo.java"
// Despues ejecutamos la aplicacion desde la carpeta src con el comando "java Hilos/UsaHilo"

package Hilos.Hilos01;

public class UsaHilo {

	public static void main(String[] args) {
		
		HilosPrimero hp = new HilosPrimero();
		hp.start();
		
		for (int i = 0; i < 5; i++) {
			
			System.out.println("Fuera del hilo " + i);
		}
	}
}
