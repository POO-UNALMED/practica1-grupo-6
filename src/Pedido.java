import java.util.ArrayList;
import java.util.Iterator;

public class Pedido {
	private ArrayList<String> productos = new ArrayList<String>();
	private ArrayList<DetallePedido> DetalleProductos = new ArrayList<DetallePedido>();
	private static ArrayList<Pedido> pedido = new ArrayList<Pedido>();
	private int num_pedido;
	private static int Npedido=1001;
	private boolean estado;
	private Factura factura;
	private double totalPago;
	
	

	public Pedido() {
		this.num_pedido=Npedido;
		Npedido++;
	}
	
	
	public void Agregar_producto(long codigo,int cantidad) {
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
	public void totalPago() {
		double total=0;
		for (int i = 0; i < DetalleProductos.size(); i++) {
			DetallePedido p1=DetalleProductos.get(i);							/*Producto X de la lista*/
			double cant=p1.getCantidad();										/*cantidad de productos*/ 
			Producto product=p1.getProducto();									/*producto X */
			double valor=product.getPrecio_venta();								/*valor de venta de producto X*/
			total= (cant*valor)+total;
		}
		totalPago=total;
	}
	public boolean confirmacion(String x) {
		if (x=="si") {
			return true;
		}
		return false;
	}
	
	public String crearFactura(boolean confirmacion,String fecha,Cliente cliente) {
		
		if(confirmacion) {
			Factura factura = new Factura(fecha,this,cliente);
			this.factura=factura;
			this.estado=true;
			this.totalPago();
			return "Factura realizada";
			
		}else {
			pedido.remove(this);
			return "No se ha realizado el pedido";
			
		}
	}
	
	public DetallePedido consultarProducto(long codigo) {
		DetallePedido p=null;
		for (int i = 0; i < DetalleProductos.size(); i++) {
			if(DetalleProductos.get(i).getProducto().getCodigo_de_barras1()==codigo) {
				p=DetalleProductos.get(i);
				break;
			}else {
				p=null;
			}		
		}
		return p;
	}
	
	public String listaProductos() {
		Iterator<DetallePedido> iterator= DetalleProductos.iterator();
		StringBuffer lista=new StringBuffer ("Nombre   Codigo   Cantidad \n");
		while(iterator.hasNext()) {
			DetallePedido producto =(DetallePedido) iterator.next();
			lista.append(producto.toString());

		}
		return lista.toString();
	}
	
}
