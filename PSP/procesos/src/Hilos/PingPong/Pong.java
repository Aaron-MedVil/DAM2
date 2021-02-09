package Hilos.PingPong;

public class Pong extends Thread{

	private PingPong pp;
	
	/**
	 * Constructor de la clase
	 * @param pp
	 */
	public Pong(PingPong pp) { this.pp = pp; }
	
	/**
	 * Metodo que ejecuta la clase
	 */
	public void run() {
		
		for (int i = 0; i < 5; i++) {
			
			pp.pong();
			
			try { sleep(100); }
			catch(InterruptedException e) {}
		}
	}
}
