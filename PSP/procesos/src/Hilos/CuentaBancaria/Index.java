package Hilos.CuentaBancaria;

public class Index {

	public static void main(String[] args) {
		
		CajeroAutomatico ca = new CajeroAutomatico();
		
		Thread pedro = new Thread(ca, "Pedro");
		Thread juan = new Thread(ca, "Juan");
		
		pedro.start();
		juan.start();
	}
}