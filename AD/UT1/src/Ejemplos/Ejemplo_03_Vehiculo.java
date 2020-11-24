package Ejemplos;

public class Ejemplo_03_Vehiculo {

	int pasajeros, capacidad, lpkm;
	
	public Ejemplo_03_Vehiculo(int pasajeros, int capacidad, int lpkm) {
		this.pasajeros = pasajeros;
		this.capacidad = capacidad;
		this.lpkm = lpkm;
	}

	public int getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(int pasajeros) {
		this.pasajeros = pasajeros;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getLpkm() {
		return lpkm;
	}

	public void setLpkm(int lpkm) {
		this.lpkm = lpkm;
	}

	public int rango() {
		return this.capacidad * this.lpkm;
	}
}