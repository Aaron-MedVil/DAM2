package Ejemplos;

public class Ejemplo_03 {

	public static void main(String[] args) {
		
		Ejemplo_03_Vehiculo minivan = new Ejemplo_03_Vehiculo(9, 50, 18);
		
		System.out.println("La minivan puede llevar " + minivan.getPasajeros() + " "
				+ "pasajeros con un rango de " + minivan.rango() + " "
				+ "Kilómetros con el depósito lleno");
	}
}