package Hilos.CuentaBancaria;

public class CtaBancaria {
	
	private int saldoActual = 100;

	/* Obtiene el saldo de la cuenta */
	public int obtenerSaldoActual() { return saldoActual; }

	/* Retira dinero de la cuenta */
	public void retirarDinero(int cantidad) { saldoActual -= cantidad; }
}