package clases;
/**
 * 
 * @author Johana Infesta, Rocio giannaccini, Juan Mauro, Juan Manuel Campo
 *
 */
public class Facturas {
	
	private int idFactura;
	
	private int IdCliente;

	public Facturas(int idFactura, int idCliente) {
		super();
		this.idFactura = idFactura;
		IdCliente = idCliente;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public int getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(int idCliente) {
		IdCliente = idCliente;
	}

	@Override
	public String toString() {
		return "Facturas [idFactuta=" + idFactura + ", IdCliente=" + IdCliente + "]";
	}

	
}
