
public class DetallePedido {
	
	private int id;
	private int Cantidad;
	private Pedido pedido;
	private Producto producto;
	private static int  id1=1001;
	
	public DetallePedido( int cantidad, Pedido pedido, Producto producto) {
		super();
		this.id = id1;
		Cantidad = cantidad;
		this.pedido = pedido;
		this.producto = producto;
		this.producto.modificarStock(-cantidad);
		id1++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public boolean modificarCantidad(int cantidad) {
		if(cantidad<=this.Cantidad) {
			this.Cantidad=this.Cantidad-cantidad;
			this.producto.modificarStock(cantidad);
			return true;
		}else {
			return false;
		}
	}
	
	
}
