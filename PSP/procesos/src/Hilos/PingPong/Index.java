package Hilos.PingPong;

public class Index {

	/**
	 * Metodo que ejecuta la aplicacion
	 * @param args
	 */
	public static void main(String[] args) {

		PingPong pp = new PingPong();
		
		Ping pi = new Ping(pp);
		Pong po = new Pong(pp);
		
		pi.start();
		po.start();

	}
}