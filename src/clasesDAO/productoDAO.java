package clasesDAO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import clases.Producto;
import factory.DbMySQL;
import interfaces.DAO;
/**
 * 
 * @author Johana Infesta, Rocio giannaccini, Juan Mauro, Juan Manuel Campo
 *
 */
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
/**
 * 
 * @return producto mas vendico (cantidad facturada multiplicado por su valor)
 */
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

	@Override
	public void insertarListadoCSV() throws FileNotFoundException, IOException {
		@SuppressWarnings("deprecation")
		CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new
				FileReader("./src/main/productos.csv"));
		for(CSVRecord row: parser) {
			Producto p = new Producto (Integer.parseInt(row.get("idProducto")), row.get("nombre"), Integer.parseInt(row.get("valor")));
			this.Insert(p);
		}
	}
}
