import java.util.ArrayList;

public class Pedido {
	private int cantidad_comprar;
	private ArrayList<String> productos = new ArrayList<String>();
	private ArrayList<DetallePedido> DetalleProductos = new ArrayList<DetallePedido>();
	private int num_pedido;
	private boolean estado;
	private int totalPago;
	
	

	public void Agregar_producto(String codigo,int cantidad) {
		Producto p=Producto.consultarProducto(codigo);
		if(p!=null) {
			if(cantidad<=p.getCantidad()) {
				DetallePedido d= new DetallePedido(cantidad,this,p);
				DetalleProductos.add(d);				
			}else {
				System.out.println("Supero la cantidad en el inventario");
			}
		}else {
			System.out.println("Producto no encontrado");
		}
		
	}
	public void quitar_producto(int id) {
		for (int i = 0; i < DetalleProductos.size(); i++) {
			if(DetalleProductos.get(i).getId()==id) {
				DetalleProductos.remove(DetalleProductos.get(i));
				break;
			}
		}
	}
	public int totalPago(int productos, int cantidad) {
		/*buscar producto*/
		this.totalPago=productos*cantidad;
		return totalPago;
	}
}
