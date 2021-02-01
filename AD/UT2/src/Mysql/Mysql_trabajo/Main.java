package Mysql.Mysql_trabajo;

import java.sql.*;

public class Main {

	public static void main(String[] args) {

		try {
			
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// Establecemos la conexi�n con la BD - getConnection(String URL, String user, String pass)
			Connection conexi�n = DriverManager.getConnection("jdbc:mysql://localhost:3306/neptuno", "neptuno", "neptuno");
			
			// Preparamos la consulta
			Statement sentencia = conexi�n.createStatement();
			String sql = "SELECT `Id_Cliente`, `Nombre_Compania`, `Nombre_Contacto`, `Ciudad` FROM `clientes` WHERE 1";
			ResultSet resul = sentencia.executeQuery(sql);
			
			// Recorremos el resultado para visualizar cada fila,se hace un bucle mientras
			// haya registros y se van mostrando
			while (resul.next()) {
				System.out.printf("%d %n", resul.getInt(1));
			}
			resul.close(); // Cerrar
			sentencia.close(); // Cerrar Statement
			conexi�n.close(); // Cerrar conexi�n
		}
		catch (ClassNotFoundException cn) { cn.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
	}
}