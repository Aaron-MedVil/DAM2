// Tres variables, una pasajeros, una litros y otra consumo
// Que devuelva el nombre, los pasajeros y los litros que podria hacer con el deposito lleno

package Ejemplos;

public class Ejemplo_02 {

	public static void main(String[] args) {
		
		Ejemplo_02_Vehiculo minivan = new Ejemplo_02_Vehiculo();
		
		int rango;
		minivan.pasajeros = 9;
		minivan.capacidad = 50;
		minivan.lpkm = 18;
		
		rango = minivan.capacidad * minivan.lpkm;
		
		System.out.println("La minivan puede llevar " + minivan.pasajeros + " "
				+ "pasajeros con un rango de " + rango + " "
				+ "Kilómetros con el depósito lleno");
	}
}