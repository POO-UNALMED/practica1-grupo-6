package gestorAplicacion.factura;
import java.util.ArrayList;

import gestorAplicacion.cliente.Cliente;

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
	public int getNfacturas() {
		return Nfactura;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public static Factura consultarFactura(int id) {
		Factura p=null;
		for (int i = 0; i < Facturas.size(); i++) {
			if(Facturas.get(i).getNfacturas()==id) {
					p=Facturas.get(i);
					Facturas.remove(i);
					break;
			}else {
				p=null;
				}
		}
		return p;
	}
	
	public void agregarFactura(Factura F) {
		Facturas.add(F);
	}
	public String imprimirFactura() {
		return ("Numero de factura: "+ Nfactura + "\nFecha: "+ Fecha +"\n"+ pedido.listaProductos());
	}
	public String toString() {
		return Fecha +" "+ Nfactura;
	}
	
	public static ArrayList<Factura> rangoDeFacturas(String fecha1,String fecha2){
		String [] fecha_1= fecha1.split("/");
		String [] fecha_2= fecha2.split("/");
		ArrayList<Factura> rangoDeFacturas = new ArrayList<>();
		
		for (int i = 0; i < Facturas.size(); i++) {
			String [] fecha3=Facturas.get(i).Fecha.split("/");
			
			if((Integer.parseInt(fecha_1[2])==Integer.parseInt(fecha_2[2]))&&(Integer.parseInt(fecha_1[1])==Integer.parseInt(fecha_2[1]))) {
				
				if(Integer.parseInt(fecha3[0])>=Integer.parseInt(fecha_1[0])&&Integer.parseInt(fecha3[0])<=Integer.parseInt(fecha_2[0])) {
					rangoDeFacturas.add(Facturas.get(i));
				}
				
			}else if ((Integer.parseInt(fecha_1[2])==Integer.parseInt(fecha_2[2]))&&(Integer.parseInt(fecha_1[1])!=Integer.parseInt(fecha_2[1]))) {
				
				if(Integer.parseInt(fecha3[1])>=Integer.parseInt(fecha_1[1])&&Integer.parseInt(fecha3[1])<=Integer.parseInt(fecha_2[1])) {
					rangoDeFacturas.add(Facturas.get(i));
				}
				
			}
		}
		return rangoDeFacturas;
	}
	
	public Cliente getClientes() {
		
		return cliente;
	}
	
}
