package Hilos.Hilos13;

public class Pong extends Thread{

	private PingPong pp;
	private int n;
	
	public Pong(PingPong pp, int n) {
		this.pp = pp;
		this.n = n;
	}
	
	public void run() {
		
		for (int i = 0; i < 5; i++) {
			pp.pong(i);
			System.out.println("Pong");
			
			try { sleep(100); }
			catch(InterruptedException e) {}
		}
	}
}
