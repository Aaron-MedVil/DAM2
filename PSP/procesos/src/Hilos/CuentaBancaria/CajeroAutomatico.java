package Hilos.CuentaBancaria;

public class CajeroAutomatico implements Runnable {
	
	CtaBancaria cuenta = new CtaBancaria();

	/* Metodo que ejecuta la clase */
	public void run() {
		
		for (int i = 0; i < 5; i++) {
			
			retirarDinero(20);
			
			if (cuenta.obtenerSaldoActual() < 0) { System.out.println("Cuenta con saldo negativo."); }
		}
	}
	
	/* Comprueba el saldo de una cuenta y si es posible retira el dinero indicado */
	private synchronized void retirarDinero(int cantidad) {
		
		if (cuenta.obtenerSaldoActual() >= cantidad) {
			
			System.out.println("Saldo actual en la cuenta: " + cuenta.obtenerSaldoActual() + ".");
			System.out.println("El usuario " + Thread.currentThread().getName() + " esta retirando dinero por un valor de " + cantidad + " Euros.");
			
			// Retiramos el dinero
			cuenta.retirarDinero(cantidad);
			System.out.println("Transacción realizada con éxito.");
			System.out.println("Saldo actual en la cuenta: " + cuenta.obtenerSaldoActual() + ".");
		}
		else { System.out.println("Señor/a " + Thread.currentThread().getName() + " no hay saldo suficiente en su cuenta."); }
	}
}
