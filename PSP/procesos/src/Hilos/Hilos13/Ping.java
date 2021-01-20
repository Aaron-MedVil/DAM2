package Hilos.Hilos13;

public class Ping extends Thread {

	private PingPong pp;
	private int n;
	
	public Ping(PingPong pp, int n) {
		this.pp = pp;
		this.n = n;
	}
	
	public void run() {
		
		int valor = 0;
		for (int i = 0; i < 5; i++) {
			valor = pp.ping();
			System.out.println("Ping");
		}
	}
}
