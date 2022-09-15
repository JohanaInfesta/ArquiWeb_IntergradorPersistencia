package clasesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import clases.Producto;
import factory.DbMySQL;
import interfaces.DAO;

public class productoDAO implements DAO<Producto>{

	private Connection conn = null;

	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = DbMySQL.getInstance().getConnection();
		return conn;
	}
	
	public productoDAO() {
		super();
	}

	@Override
	public void CreateTable() {
		try {
			conn = getConnection();
			String dropTableInMysql= "DROP TABLE IF EXISTS producto";
			conn.prepareStatement(dropTableInMysql).execute();
			conn.commit();
			String tablaPersonaMYSQL = "CREATE TABLE producto(" +
					"id INT," +
					"nombre VARCHAR(500),"+ 
					"valor INT," +
					"PRIMARY KEY(id))";
			conn.prepareStatement(tablaPersonaMYSQL).execute();
			conn.commit();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void Insert(Producto t) {
		try {
			conn = getConnection();
			String insert = "INSERT INTO clientes (id, nombre, valor) VALUES(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(insert);
			ps.setInt(1, t.getIdProducto());
			ps.setString(2, t.getNombre());
			ps.setInt(3, t.getValor());
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
