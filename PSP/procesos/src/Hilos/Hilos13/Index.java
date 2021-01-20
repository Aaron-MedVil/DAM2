package Hilos.Hilos13;

public class Index {

	public static void main(String[] args) {

		PingPong pp = new PingPong();
		
		Ping pi = new Ping(pp, 1);
		Pong po = new Pong(pp, 1);
		
		pi.start();
		po.start();

	}

}
