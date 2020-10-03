import java.util.ArrayList;
import java.util.Iterator;

public class Cliente extends Persona{
	

	static private ArrayList<Cliente>clientes=new ArrayList();			/*listado de clientes tipo clientes*/
	 	
	private int compras;											/*compras realizadas anteriormente*/
	static int Nclientes;												/*numero de clientes*/
	
	/*constructor*/
	
	public Cliente(String nombre, String identificacion, String correo, String direccion, String telefono,
			String genero) {
		super(nombre, identificacion, correo, direccion, telefono, genero);
		Nclientes++;
		clientes.add(this);
	}


	/*metodos*/
	public int cantidadClientes() {
		return (Nclientes);													/*total clientes numero*/
	}
	
	public int getCompras() {
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
	
	
}
