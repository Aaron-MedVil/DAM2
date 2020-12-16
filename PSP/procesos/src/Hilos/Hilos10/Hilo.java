package Hilos.Hilos10;

public class Hilo extends Thread {
	
	private boolean suspendido = false;
	private int cont = 0;

	/**
	 * Metodo que ejecuta el hilo
	 */
	public void run() {
		
		while (!suspendido) { System.out.printf("Hilo %s: cont %d %n", this.getName(), ++cont); }
	}
	
	/**
	 * Devuelve el contador del hilo
	 * @return
	 */
	public int getContadorHilo() { return cont;	}
	
	/**
	 * Metodo para detener la ejecucuon del hilo
	 */
	public synchronized void pararHilo() { suspendido = true; }
}