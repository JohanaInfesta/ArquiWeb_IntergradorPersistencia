package factory;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 
 * @author Johana Infesta, Rocio giannaccini, Juan Mauro, Juan Manuel Campo
 *
 */
public class DbMySQL {

	
	String driver = "com.mysql.cj.jdbc.Driver";
	String uri = "jdbc:mysql://localhost:3306/entregable_persistencia";
	
	
	private static DbMySQL connectionDB = null;

	public DbMySQL() {
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException
				| ClassNotFoundException e1) {
			e1.printStackTrace();
			System.exit(1);
		}
	}
	/**
	 * 
	 * @return conexion con la DB
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException{
		Connection conn = DriverManager.getConnection(uri, "root", "");
		conn.setAutoCommit(false);
		return conn;
	}
	
	//metodo a abstraer para el factory
	public static DbMySQL getInstance() {
		if(connectionDB == null) {
			connectionDB = new DbMySQL();
		}
		return connectionDB;
	}
	
	
}
