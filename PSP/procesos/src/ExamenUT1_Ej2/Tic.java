package ExamenUT1_Ej2;

public class Tic extends Thread {

	private int nh;
	
	// Constructor de la clase
	public Tic(int nh) { this.nh = nh; }
	
	// Funcion que se ejecutara cuando se cree el proceso del hilo
	public void run() {
		
		// Creamos un bucle que se ejecute 30 veces mostrando el nombre de la clase y el numero de hilo que es
		for (int i = 0; i < 30; i++) { System.out.println("TIC-hilo: " + this.nh); }
	}
}
