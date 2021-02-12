package HSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	private static String strConn = "jdbc:hsqldb:file:D:\\Programs\\hsqldb\\data\\Ejemplo";
	
	public static void main(String[] args) {
		
		try {

			// Establecemos la conexi�n con la BD
			Connection conexi�n = DriverManager.getConnection(strConn);

			// Preparamos la consulta
			Statement sentencia = conexi�n.createStatement();
			
			// Cadena de la consulta
			String sql = "SELECT * FROM departamentos";
			
			// Ejecutamos la sentencia
			ResultSet result = sentencia.executeQuery(sql);

			// Mostramos los registros de la base de datos
			while (result.next()) {
				System.out.println("DATOS DEL DEPARTAMENTO ID " + result.getInt(1));
				System.out.println("\tNombre: " + result.getString(2));
				System.out.println("\tUbicaci�n: " + result.getString(3));
				System.out.println("============================================================");
			}
			
			// Cerramos el ResultSet
			result.close();
			
			// Cerramos la sentencia
			sentencia.close();
			
			// Cerramos la conexion
			conexi�n.close();
		}
		catch (SQLException e) { e.printStackTrace(); }
	}
}