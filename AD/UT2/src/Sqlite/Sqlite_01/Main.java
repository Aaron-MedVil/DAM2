package Sqlite.Sqlite_01;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	
	private static Path currentRelativePath = Paths.get("");
	private static String s = currentRelativePath.toAbsolutePath().toString();
	private static String strConn = "jdbc:sqlite:" + s + "/data/Ejemplo.db";
	
	public static void main(String[] args) {
		
		try {

			// Establecemos la conexión con la BD
			Connection conexión = DriverManager.getConnection(strConn);

			// Preparamos la consulta
			Statement sentencia = conexión.createStatement();
			
			// Cadena de la consulta
			String sql = "SELECT * FROM departamentos";
			
			// Ejecutamos la sentencia
			ResultSet result = sentencia.executeQuery(sql);

			// Mostramos los registros de la base de datos
			while (result.next()) {
				System.out.println("DATOS DEL DEPARTAMENTO ID " + result.getInt(1));
				System.out.println("\tNombre: " + result.getString(2));
				System.out.println("\tUbicación: " + result.getString(3));
				System.out.println("============================================================");
			}
			
			// Cerramos el ResultSet
			result.close();
			
			// Cerramos la sentencia
			sentencia.close();
			
			// Cerramos la conexion
			conexión.close();
		}
		catch (SQLException e) { e.printStackTrace(); }
	}
}