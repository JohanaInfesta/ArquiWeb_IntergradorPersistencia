package clases;
/**
 * 
 * @author Johana Infesta, Rocio giannaccini, Juan Mauro, Juan Manuel Campo
 *
 */
public class Cliente {

	private int id;
	private String nombre;
	private String email;
	
	public Cliente(int id, String nombre, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
	}

	public int getIdCliente() {
		return id;
	}

	public void setIdCliente(int idCliente) {
		this.id = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + id + ", nombre=" + nombre + ", email=" + email + "]";
	}
	
	
	
}
