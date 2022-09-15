package clasesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import clases.Cliente;
import factory.DbMySQL;
import interfaces.DAO;

public class clienteDAO implements DAO<Cliente>{

	private Connection conn = null;

	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = DbMySQL.getInstance().getConnection();
		return conn;
	}

	public clienteDAO() {
		super();
	}


	@Override
	public void CreateTable() {
		try {
			conn = getConnection();
			String dropTableInMysql= "DROP TABLE IF EXISTS clientes";
			conn.prepareStatement(dropTableInMysql).execute();
			conn.commit();
			String tablaPersonaMYSQL = "CREATE TABLE clientes(" +
					"id INT," +
					"nombre VARCHAR(500),"+ 
					"email VARCHAR(500)," + 
					"PRIMARY KEY(id))";
			conn.prepareStatement(tablaPersonaMYSQL).execute();
			conn.commit();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

	}

	@Override
	public void Insert(Cliente cliente) {
		try {
			conn = getConnection();
			String insert = "INSERT INTO clientes (id, nombre, email) VALUES(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(insert);
			ps.setInt(1, cliente.getIdCliente());
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getEmail());
			ps.executeUpdate();
			System.out.println("Datos agregados con éxito");
			ps.close();
			conn.commit();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
