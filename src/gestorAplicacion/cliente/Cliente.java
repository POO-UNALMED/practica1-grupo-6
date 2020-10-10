package gestorAplicacion.cliente;
import java.util.ArrayList;
import java.util.Iterator;

import gestorAplicacion.factura.Factura;

public class Cliente extends Persona{
	

	static private ArrayList<Cliente>clientes=new ArrayList();			/*listado de clientes tipo clientes*/
	static private ArrayList<Factura>listaFacturas=new ArrayList();	
	private long compras;											/*compras realizadas anteriormente*/
	static int Nclientes;												/*numero de clientes*/
	
	/*constructor*/
	
	public Cliente(String nombre, int identificacion, String correo, String direccion, String telefono,
			String genero) {
		super(nombre, identificacion, correo, direccion, telefono, genero);
		Nclientes++;
		clientes.add(this);
	}


	/*metodos*/
	public void totalCompras() {
		long control=0;
		for (int i = 0;i <=listaFacturas.size();i++) {
			control+=listaFacturas.get(i).getPedido().gettotalPago();
		}
		compras=control;
	}
	
	public int cantidadClientes() {
		return (Nclientes);													/*total clientes numero*/
	}
	
	public long getCompras() {
		return compras;
	}
	public void setCompras(){													/*suma compra al historial*/
		this.compras++;
	}

	
	public String listaClientes() {
		Iterator<Cliente> iterator= clientes.iterator();
		StringBuffer lista=new StringBuffer ("lista clientes \n");
		while(iterator.hasNext()) {
			Cliente cliente1 =(Cliente) iterator.next();
			lista.append(cliente1.toString());

		}
		return lista.toString();
	}
	public static Cliente consultarCliente(int id) {
		Cliente p=null;
		for (int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i).getIdentificacion()==id) {
					p=clientes.get(i);
					break;
			}else {
				p=null;
				}
		}
		return p;
	}
	
	public void agregarFactura(Factura f) {
		listaFacturas.add(f);
	}
	
	
	
	
}
