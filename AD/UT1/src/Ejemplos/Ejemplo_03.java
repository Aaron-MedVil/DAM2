package Ejemplos;

import java.util.ArrayList;

public class Ejemplo_03 {

	public static void main(String[] args) {
		
		ArrayList<Ejemplo_03_Vehiculo> vehiculos = new ArrayList<Ejemplo_03_Vehiculo>();
		vehiculos.add(new Ejemplo_03_Vehiculo("Minivan", 9, 50, 18));
		vehiculos.add(new Ejemplo_03_Vehiculo("Coche deportivo", 10, 25, 30));
		
		for (Ejemplo_03_Vehiculo vehiculo : vehiculos) {
			
			System.out.println("El veh�culo" + vehiculo.getNombre() + " "
					+ "puede llevar " + vehiculo.getPasajeros() + " "
					+ "pasajeros con un rango de " + vehiculo.rango() + " "
					+ "Kil�metros con el dep�sito lleno");
		}
	}
}