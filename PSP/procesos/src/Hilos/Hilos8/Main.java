// Tenemos el programa principal que hace uso del hilo,
// el cual creará tres objetos de Hilo pasando como parámetros el nombre del hilo y el límite del contador.
// Se inicializarán y posteriormente se utilizará el método join aplicado a cada hilo creado.
// Después de esto imprimirá por pantalla el mensaje "Final del programa"

package Hilos.Hilos8;

public class Main {

	public static void main(String[] args) {
		
		// Creamos los hilos
		Hilo h1 = new Hilo(5, "Hilo 1");
		Hilo h2 = new Hilo(7, "Hilo 2");
		Hilo h3 = new Hilo(3, "Hilo 3");
		
		// Ejecutamos los hilos
		h1.start(); h2.start(); h3.start();
		
		try {
			
			// Ejecutamos el metodo join de los hilos
			h1.join(); h2.join(); h3.join();
		}
		catch (InterruptedException e) { e.printStackTrace(); }
		
		System.out.println("Fin del programa");
	}
}