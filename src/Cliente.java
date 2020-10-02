import java.util.ArrayList;

public class Cliente extends Persona{
	

	static private ArrayList<Cliente>clientes=new ArrayList();			/*listado de clientes tipo clientes*/
	 	
	public static int compras;			/*compras realizadas anteriormente*/
	static int Nclientes;		/*numero de clientes*/
	
	/*constructor*/
	
	public Cliente(String nombre, String identificacion, String correo, String direccion, String telefono,
			String genero) {
		
		super(nombre, identificacion, correo, direccion, telefono, genero);
		Nclientes++;
	}


	/*metodos*/
	public int cantidadClientes() {
		return (Nclientes);						/*total clientes numero*/
	}
	public String listaClientes() {
		for(int i=0; clientes.size(); i++) {
			System.out.println(clientes.get(i));
		}
	}
	
	
	
}
