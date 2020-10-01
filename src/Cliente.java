import java.util.ArrayList;

public class Cliente extends Persona{
	
	private ArrayList<String> lista_facturas = new ArrayList<String>();
	private Cliente[] listaCliente; 	/*listado de clientes tipo clientes*/
	public static int compras;			/*compras realizadas anteriormente*/
	static int Nclientes;		/*numero de clientes*/
	
	/*constructor*/
	public Cliente() { Nclientes++;}
	
	
	/*metodos*/
	public int selec_producto(String p) {
		/*tomar producto???*/
	}
	public String consultar_producto(String producto) {
		String no="no esta";
		String si="si esta";
		
		if (lista_facturas.contains(producto)==true) {
			
			return si;
		}else
			return no;
		
	}
	
	
}
