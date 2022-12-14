package clasesDAO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import clases.Cliente;
import factory.DbMySQL;
import interfaces.DAO;
/**
 * 
 * @author Johana Infesta, Rocio giannaccini, Juan Mauro, Juan Manuel Campo
 *
 */
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
//			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @return Lista de clientes en orden Desc de quien facturo mas
	 */
	public List<Cliente>getClientes(){
		List<Cliente>c = new ArrayList<>();
		try {
			conn = getConnection();
			String select = "SELECT c.*, COUNT(f.id) AS total FROM clientes c JOIN facturas f ON c.id = f.id_cliente GROUP BY c.id ORDER BY `total` DESC LIMIT 20";
			PreparedStatement ps = conn.prepareStatement(select);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Cliente cliente = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3));
				System.out.println(cliente);
				c.add(cliente);
			}
			ps.close();
			conn.commit();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return c;
		
	}

	@Override
	public void insertarListadoCSV() throws FileNotFoundException, IOException {
		@SuppressWarnings("deprecation")
		CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new
				FileReader("./src/main/clientes.csv"));
		for(CSVRecord row: parser) {
			Cliente c = new Cliente (Integer.parseInt(row.get("idCliente")), row.get("nombre"), row.get("email"));
			this.Insert(c);
		}
		
	}

}
