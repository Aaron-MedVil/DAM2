package Ejemplos;

public class Ejemplo_03 {

	public static void main(String[] args) {
		
		Ejemplo_03_Vehiculo minivan = new Ejemplo_03_Vehiculo(9, 50, 18);
		Ejemplo_03_Vehiculo sportCar = new Ejemplo_03_Vehiculo(10, 25, 30);
		
		System.out.println("La minivan puede llevar " + minivan.getPasajeros() + " "
				+ "pasajeros con un rango de " + minivan.rango() + " "
				+ "Kil�metros con el dep�sito lleno");
		
		System.out.println("El coche deportivo puede llevar " + sportCar.getPasajeros() + " "
				+ "pasajeros con un rango de " + sportCar.rango() + " "
				+ "Kil�metros con el dep�sito lleno");
	}
}