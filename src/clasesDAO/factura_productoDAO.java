package clasesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import clases.Factura_Producto;
import factory.DbMySQL;
import interfaces.DAO;

public class factura_productoDAO implements DAO<Factura_Producto>{

	private Connection conn = null;

	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = DbMySQL.getInstance().getConnection();
		return conn;
	}
	
	public factura_productoDAO() {
		super();
	}

	@Override
	public void CreateTable() {
		try {
			conn = getConnection();
			String dropTableInMysql= "DROP TABLE IF EXISTS factura_producto";
			conn.prepareStatement(dropTableInMysql).execute();
			conn.commit();
			String tablaPersonaMYSQL = "CREATE TABLE factura_producto(" +
					"id_factura INT," +
					"id_producto INT,"+ 
					"cantidad INT,"+
					"FOREIGN KEY(id_factura)REFERENCES facturas (id)," +
					"FOREIGN KEY(id_producto) REFERENCES producto (id))";
			conn.prepareStatement(tablaPersonaMYSQL).execute();
			conn.commit();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void Insert(Factura_Producto t) {
		try {
			conn = getConnection();
			String insert = "INSERT INTO factura_producto (id_factura, id_producto, cantidad) VALUES(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(insert);
			ps.setInt(1, t.getIdFactura());
			ps.setInt(2, t.getIdProducto());
			ps.setInt(2, t.getCantidad());
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
