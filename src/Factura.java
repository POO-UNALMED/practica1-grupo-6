import java.util.ArrayList;

public class Factura {
	private String Fecha;
	private int Nfactura;
	private static int Numfactura=110;
	private Pedido pedido;
	private Cliente cliente;
	private static ArrayList<Factura> Facturas = new ArrayList<Factura>();
	
	public Factura( String Fecha, Pedido pedido, Cliente cliente) {
		super();
		Nfactura = Numfactura;
		this.Fecha=Fecha;
		this.pedido = pedido;
		this.cliente=cliente;
		this.cliente.agregarFactura(this);
		Numfactura++;
		Facturas.add(this);
	}
	public String getFecha() {
		return Fecha;
	}
	
	
	
}
