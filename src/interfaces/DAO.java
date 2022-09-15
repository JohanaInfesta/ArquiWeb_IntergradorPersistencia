package interfaces;

public interface DAO<T> {

	public void CreateTable();
	
	public void Insert(T t);
}
