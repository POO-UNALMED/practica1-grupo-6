package gestorAplicacion.factura;
import java.util.ArrayList;
import java.util.Iterator;

import gestorAplicacion.cliente.Cliente;

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
	
	
	public String Agregar_producto(long codigo,int cantidad) {
		Producto p=Producto.consultarProducto(codigo);
		if(p!=null) {
			if(cantidad<=p.getCantidad()) {
				DetallePedido d= new DetallePedido(cantidad,this,p);
				DetalleProductos.add(d);
				return "producto agregado";
			}else {
				return"Supero la cantidad en el inventario";
			}
		}else {
			return"Producto no encontrado";
		}
		
	}
	public void quitar_producto(int id) {
		for (int i = 0; i < DetalleProductos.size(); i++) {
			if(DetalleProductos.get(i).getId()==id) {
				DetalleProductos.get(i).eliminarDetalle(DetalleProductos.get(i), DetalleProductos.get(i).getCantidad());
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
	
	public DetallePedido consultarProducto(int codigo) {
		DetallePedido p=null;
		for (int i = 0; i < DetalleProductos.size(); i++) {
			if(DetalleProductos.get(i).getId()==codigo) {
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
		StringBuffer lista=new StringBuffer ("Nombre   Codigo  CodidoDetalle  Cantidad \n");
		while(iterator.hasNext()) {
			DetallePedido producto =(DetallePedido) iterator.next();
			lista.append(producto.toString());

		}
		return lista.toString();
	}


	public ArrayList<DetallePedido> getDetalleProductos() {
		return DetalleProductos;
	}


	public Factura getFactura() {
		return factura;
	}
	public double gettotalPago() {
		return totalPago;
	}
	public void setSumaVentas() {
		for(int i =0;i<DetalleProductos.size();i++) {
			DetalleProductos.get(i).getProducto().setVentas(DetalleProductos.get(i).getCantidad());
		}
	}


	
	
}
