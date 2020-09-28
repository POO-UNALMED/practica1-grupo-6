import java.util.ArrayList;

public class Pedido {
	private int cantidad_comprar;
	private ArrayList<String> productos = new ArrayList<String>();
	private int num_pedido;
	private boolean estado;
	private int totalPago;
	
	
	public int calcular_precio(String p) {
		/*tomar producto*/
	}
	public void Agregar_producto(String a) {
		/*buscar producto*/
		productos.add(a);
	}
	public void quitar_producto(String q) {
		/*buscar producto*/
		productos.remove(q);
	}
	public int totalPago(int productos, int cantidad) {
		/*buscar producto*/
		this.totalPago=productos*cantidad;
		return totalPago;
	}
}
