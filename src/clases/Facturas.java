package clases;

public class Facturas {
	
	private int idFactuta;
	
	private int IdCliente;

	public Facturas(int idFactuta, int idCliente) {
		super();
		this.idFactuta = idFactuta;
		IdCliente = idCliente;
	}

	public int getIdFactuta() {
		return idFactuta;
	}

	public void setIdFactuta(int idFactuta) {
		this.idFactuta = idFactuta;
	}

	public int getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(int idCliente) {
		IdCliente = idCliente;
	}

	@Override
	public String toString() {
		return "Facturas [idFactuta=" + idFactuta + ", IdCliente=" + IdCliente + "]";
	}

	
}
