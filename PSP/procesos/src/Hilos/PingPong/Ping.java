package Hilos.PingPong;

public class Ping extends Thread {

	private PingPong pp;
	
	/**
	 * Constructor de la clase
	 * @param pp
	 */
	public Ping(PingPong pp) { this.pp = pp; }
	
	/**
	 * Metodo que ejecuta la clase
	 */
	public void run() {
		for (int i = 0; i < 5; i++) { pp.ping(); }
	}
}
