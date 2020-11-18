package Hilos.Hilos3;

public class CrearHilo extends Thread {
	
	public void run() {
		
		System.out.println("Ejecución del hilo " + this.getName());
		System.out.println("Prioridad del hilo " + this.getPriority());
		System.out.println("Identificador del hilo " + this.getId());
	}
}