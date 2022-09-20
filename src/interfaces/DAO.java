package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface DAO<T> {

	public void CreateTable();
	
	public void Insert(T t);
	
	public void insertarListadoCSV() throws FileNotFoundException, IOException;
}
