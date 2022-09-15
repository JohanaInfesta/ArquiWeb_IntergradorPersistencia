package clasesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			//			String dropTableInMysql= "DROP TABLE IF EXISTS producto";
			//			conn.prepareStatement(dropTableInMysql).execute();
			//			conn.commit();
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
			String insert = "INSERT INTO producto (id, nombre, valor) VALUES(?,?,?)";
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

	public Producto getProducto() {
		Producto p = null;
		try {
			conn = getConnection();
			String select = "SELECT p.*, SUM(p.valor * fp.cantidad) as total "
								+ "FROM producto p JOIN factura_producto fp ON (p.id = fp.id_producto)"
								+ " GROUP BY id_producto"
								+ " ORDER BY `total`"
								+ " DESC LIMIT 1";
			PreparedStatement ps = conn.prepareStatement(select);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				p = new Producto(rs.getInt(1), rs.getString(2), rs.getInt(3));
			}
			conn.commit();
			ps.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		System.out.println(p);
		return p;
	}
}
