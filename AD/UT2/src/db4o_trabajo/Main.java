package db4o_trabajo;

import java.util.Scanner;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Main {
	
	// Nombre de la base de datos
	private static String dbName = "data/empleded.yap";

	/**
	 * Metodo inicial de la clase
	 * @param args
	 */
	public static void main(String[] args) { menu(); }
	
	/**
	 * Metodo que inserta los datos de los departamentos
	 * @param args
	 */
	
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
		finally { menu(); }
	}
	
	/**
	 * Metodo que lee los datos de los departamentos
	 */
	private static void leerDepartamentos() {
		
		try {
			
			ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), dbName);
			
			Departamentos dep = new Departamentos(null, null, 0);
			ObjectSet<Departamentos> rDep = db.queryByExample(dep);
			
			if (rDep.size() > 0) {
				
				System.out.printf("%nNúmero de registros: %d %n", rDep.size());			
				while (rDep.hasNext()) {
					Departamentos d = rDep.next();
					System.out.printf("%n- Número departamento: %d, Nombre departamento: %s, Localidad: %s", d.getDept_no(), d.getDnombre(), d.getLoc());
				}
			}
			else { System.err.println("No existen registros departamentos"); }
			
			db.close();
		}
		catch (Exception err) { err.printStackTrace(); }
		finally { menu(); }
	}
	
	/**
	 * Metodo que inserta los datos de los empleados
	 */
	private static void insertarEmpleados() {
		
		// String apellido, String oficio, String fecha_alt, int emp_no, int dir, int salario, int comision, int dept_no
		Empleados e1 = new Empleados("SÁNCHEZ", "EMPLEADO", "17/12/2017", 7369, 7902, 1040, 0, 20);
		Empleados e2 = new Empleados("ARROYO", "VENDEDOR", "20/02/2017", 7499, 7698, 1500, 390, 30);
		Empleados e3 = new Empleados("SALA", "VENDEDOR", "22/02/2018", 7521, 7698, 1625, 650, 30);
		Empleados e4 = new Empleados("JIMÉNEZ", "DIRECTOR", "02/04/2018", 7566, 7839, 2900, 0, 20);
		
		try {
			
			ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), dbName);
			
			db.store(e1); db.store(e2); db.store(e3); db.store(e4);
			db.close();
		}
		catch (Exception err) { err.printStackTrace(); }
		finally { menu(); }
	}
	
	private static void leerEmpleados() {
		
		try {
			
			ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), dbName);
			
			Empleados emp = new Empleados();
			ObjectSet<Empleados> rEmp = db.queryByExample(emp);
			
			if (rEmp.size() > 0) {
				
				System.out.printf("%nNúmero de registros: %d %n", rEmp.size());			
				while (rEmp.hasNext()) {
					Empleados e = rEmp.next();
					System.out.printf("%n- Apellido: %s", e.getApellido());
				}
			}
			else { System.err.println("No existen registros empleados"); }
			
			db.close();
		}
		catch (Exception err) { err.printStackTrace(); }
		finally { menu(); }
	}
	
	/**
	 * Metodo que contiene el menu de la aplicacion
	 */
	private static void menu() {
		
		Scanner reader = new Scanner(System.in);
		int numero = 0;
		
		System.out.println("\n\n=================================================="
				+ "\nSeleccione una opción:"
				+ "\n\t 1 - Insertar departamentos."
				+ "\n\t 2 - Insertar empleados."
				+ "\n\t 3 - Consultar departamentos."
				+ "\n\t 4 - Consultar empleados."
				+ "\n\t 0 - Salir del programa.");
		
		while(!reader.hasNextInt()) {
			
			System.err.println("Inserte un número válido");
			System.out.println("\n\n=================================================="
					+ "\nSeleccione una opción:"
					+ "\n\t 1 - Insertar departamentos."
					+ "\n\t 2 - Insertar empleados."
					+ "\n\t 3 - Consultar departamentos."
					+ "\n\t 4 - Consultar empleados."
					+ "\n\t 0 - Salir del programa.");
			reader.next();
		}
		
		numero = reader.nextInt();
		
		switch (numero) {
		case 0:
			System.err.println("Fin del programa");
			System.exit(0);
			break;
		case 1:
			insertarDepartamentos();
			break;
		case 2:
			insertarEmpleados();
			break;
		case 3:
			leerDepartamentos();
			break;
		case 4:
			leerEmpleados();
			break;
		default:
			System.err.println("Inserte un número válido");
			menu();
		}
	}
}