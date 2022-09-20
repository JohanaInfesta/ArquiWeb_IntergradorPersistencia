package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * 
 * @author Johana Infesta, Rocio giannaccini, Juan Mauro, Juan Manuel Campo
 *
 * @param <T>
 */
public interface DAO<T> {

	/**
	 * Creacion de la tabla en la base de datos
	 */
	public void CreateTable();
	/**
	 * insercion de datos en la base de datos
	 * @param t donde T puede ser la clase correspondiente
	 */
	public void Insert(T t);
	/**
	 * lector de acrchivos CSV y llamado a metodo Insert 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void insertarListadoCSV() throws FileNotFoundException, IOException;
}
