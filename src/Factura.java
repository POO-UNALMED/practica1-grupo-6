import java.util.ArrayList;

public class Factura {
	private String Fecha;
	private int Nfactura;
	private String nombreCliente;
	private static int Numfactura=110;
	private Pedido pedido;
	private static ArrayList<Factura> Facturas = new ArrayList<Factura>();
	
	public Factura( String Fecha,String nombreCliente, Pedido pedido) {
		super();
		Nfactura = Numfactura;
		this.Fecha=Fecha;
		this.nombreCliente = nombreCliente;
		this.pedido = pedido;
		Numfactura++;
		Facturas.add(this);
	}
	public String getFecha() {
		return Fecha;
	}
	
	
	
}
