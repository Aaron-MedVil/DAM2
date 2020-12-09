// Tenemos el programa principal que hace uso del hilo,
// el cual crear� tres objetos de Hilo pasando como par�metros el nombre del hilo y el l�mite del contador.
// Se inicializar�n y posteriormente se utilizar� el m�todo join aplicado a cada hilo creado.
// Despu�s de esto imprimir� por pantalla el mensaje "Final del programa"

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