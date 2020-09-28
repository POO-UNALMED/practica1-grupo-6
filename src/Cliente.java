import java.util.ArrayList;

public class Cliente {
	private int compras;
	private ArrayList<String> lista_facturas = new ArrayList<String>();
	
	
	
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
