package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * @author Johana Infesta, Rocio giannaccini, Juan Mauro, Juan Manuel Campo
 *
 */
public class CreacionDbMySQL {

	String mysqlUrl = "jdbc:mysql://localhost/";

	public CreacionDbMySQL() throws SQLException {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
	}

	/**
	 * Creacion de una nueva base de datos
	 * @return conexion con la base de datos
	 * @throws SQLException
	 */
	public Connection conecionBase() throws SQLException {
		Connection con = DriverManager.getConnection(mysqlUrl, "root", "");
		System.out.println("Connection established......");
		//Creating the Statement
		Statement stmt = con.createStatement();
		//Query to create a database
		String query = "CREATE database entregable_persistencia";
		//Executing the query
		stmt.execute(query);
		System.out.println("Database created");
		return con;
	}

}
