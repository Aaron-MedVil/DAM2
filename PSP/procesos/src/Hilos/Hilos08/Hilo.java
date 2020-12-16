// Crearemos un hilo que extienda de Thread donde se le pasar� como par�metros el nombre y un n�mero (l�mite del contador).
// El hilo sacar� por pantalla tantas veces como el l�mite del contador, un mensaje con su nombre y el contador.

package Hilos.Hilos08;

public class Hilo extends Thread {

	private int num;
	private String nom;
	
	/**
	 * Constructor de la clase
	 * @param num
	 * @param nom
	 */
	public Hilo(int num, String nom) {
		this.num = num;
		this.nom = nom;
	}
	
	public void run() {
		
		for (int i = 1; i < num; i++) {
			System.out.printf("%s: %d %n", nom, i);
		}
		
		System.out.printf("Fin Bucle %s %n", nom);
	}
}
