package clasesDAO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import clases.Facturas;
import factory.DbMySQL;
import interfaces.DAO;
/**
 * 
 * @author Johana Infesta, Rocio giannaccini, Juan Mauro, Juan Manuel Campo
 *
 */
public class facturaDAO implements DAO<Facturas>{

	private Connection conn = null;

	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = DbMySQL.getInstance().getConnection();
		return conn;
	}
	
	public facturaDAO() {
		super();
	}

	@Override
	public void CreateTable() {
		try {
			conn = getConnection();
			String dropTableInMysql= "DROP TABLE IF EXISTS facturas";
			conn.prepareStatement(dropTableInMysql).execute();
			conn.commit();
			String tablaPersonaMYSQL = "CREATE TABLE facturas(" +
					"id INT," +
					"id_cliente INT,"+ 
					"PRIMARY KEY(id),"+
					"FOREIGN KEY (id_cliente) REFERENCES clientes(id))";
			conn.prepareStatement(tablaPersonaMYSQL).execute();
			conn.commit();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void Insert(Facturas t) {
		try {
			conn = getConnection();
			String insert = "INSERT INTO facturas (id, id_cliente) VALUES(?,?)";
			PreparedStatement ps = conn.prepareStatement(insert);
			ps.setInt(1, t.getIdFactura());
			ps.setInt(2, t.getIdCliente());
			ps.executeUpdate();
			System.out.println("Datos agregados con éxito");
			ps.close();
			conn.commit();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void insertarListadoCSV() throws FileNotFoundException, IOException {
		@SuppressWarnings("deprecation")
		CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new
				FileReader("./src/main/facturas.csv"));
		for(CSVRecord row: parser) {
			Facturas f = new Facturas (Integer.parseInt(row.get("idFactura")), Integer.parseInt(row.get("idCliente")));
			this.Insert(f);
		}
	}
	
}
