package db4o_trabajo;

import java.util.Scanner;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Main {
	
	// Nombre de la base de datos
	private static String dbName = "data/empleded.yap";

	/**
	 * Metodo que inserta los datos en la tabla departamentos
	 * @param args
	 */
	public static void main(String[] args) {
		
		menu();
	}
	
	public static void insertarDepartamentos() {
		
		Departamentos d1 = new Departamentos("CONTABILIDAD", "SEVILLA", 10);
		Departamentos d2 = new Departamentos("INVESTIGACIÓN", "MADRID", 20);
		Departamentos d3 = new Departamentos("VENTAS", "BARCELONA", 30);
		Departamentos d4 = new Departamentos("PRODUCCIÓN", "BILBAO", 40);
		
		try {
			
			ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), dbName);
			
			db.store(d1); db.store(d2); db.store(d3); db.store(d4);
			db.close();
		}
		catch (Exception err) { err.printStackTrace(); }
	}
	
	/**
	 * metodo que contiene el menu de la aplicacion
	 */
	private static void menu() {
		
		Scanner reader = new Scanner(System.in);
		int numero = 0;
		
		System.out.println("Seleccione una opción:" +
				"\n\t 1 - Insertar departamentos." +
				"\n\t 2 - Insertar empleados." +
				"\n\t 3 - Consultar departamentos." +
				"\n\t 4 - Consultar empleados." +
				"\n\t 0 - Salir del programa.");
		
		while(!reader.hasNextInt()) {
			
			System.err.println("Inserte un número válido");
			System.out.println("Seleccione una opción:" +
					"\n\t 1 - Insertar departamentos." +
					"\n\t 2 - Insertar empleados." +
					"\n\t 3 - Consultar departamentos." +
					"\n\t 4 - Consultar empleados." +
					"\n\t 0 - Salir del programa.");
			reader.next();
		}
		
		numero = reader.nextInt();
		
		switch (numero) {
		case 0:
			System.err.println("Fin del programa");
			System.exit(0);
			break;
		case 1:
			System.out.println("Insertar departamentos");
			break;
		case 2:
			System.out.println("Insertar empleados");
			break;
		case 3:
			System.out.println("Consultar departamentos");
			break;
		case 4:
			System.out.println("Consultar empleados");
			break;
		default:
			System.err.println("Inserte un número válido");
			menu();
		}
	}
}