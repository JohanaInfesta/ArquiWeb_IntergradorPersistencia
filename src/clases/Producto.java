package clases;
/**
 * 
 * @author Johana Infesta, Rocio giannaccini, Juan Mauro, Juan Manuel Campo
 *
 */
public class Producto {

	private int idProducto;
	private String nombre;
	private int valor;
	
	public Producto(int idProducto, String nombre, int valor) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.valor = valor;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", valor=" + valor + "]";
	}
	
	
}
