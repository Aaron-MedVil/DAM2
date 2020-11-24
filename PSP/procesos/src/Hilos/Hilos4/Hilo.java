package Hilos.Hilos4;

public class Hilo {

	public static void main(String[] args) {
		
		CrearHiloThread hilo1 = new CrearHiloThread(1);
        hilo1.start();
        
        Thread hilo2 = new Thread(new CrearHiloRunnable(2));
        hilo2.start();
        
        for(int i = 0; i<100;i++) { System.out.println("Ejecutándose hilo MAIN "+i); }
	}
}