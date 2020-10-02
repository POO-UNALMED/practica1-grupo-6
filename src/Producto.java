import java.util.ArrayList;

public class Producto {
	
	private String nombre;
	private String marca;
	private String tipo;
	private double precio_venta;
	private String codigo_de_barras;
	private int cantidad;
	private double precio_referencia;
	private ArrayList<DetallePedido> Detalles = new ArrayList<DetallePedido>();
	private static ArrayList<Producto> productos = new ArrayList<Producto>();
	
	public Producto(String nombre, String marca, String tipo, String codigo_de_barras,
			int cantidad, double precio_referencia) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.tipo = tipo;
		this.codigo_de_barras = codigo_de_barras;
		this.cantidad = cantidad;
		this.precio_referencia = precio_referencia;
		productos.add(this);
		asignarPrecioVenta(precio_referencia);
	}

	public int getCantidad() {
		return cantidad;
	}

	public void modificarStock(int cantidad) {
		this.cantidad +=cantidad;
	}
	
	private void asignarPrecioVenta(double precio_referencia) {
		this.precio_venta= precio_referencia + precio_referencia*0.1;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}
	
	public Producto buscarProducto(String codigo,int cantidad) {
		
		for (int i = 0; i < productos.size(); i++) {
			if(productos.get(i).codigo_de_barras==codigo&&this.cantidad>=cantidad) {
				return productos.get(i);
			}else {
				return productos.get(0);
				}
		}
	}
	
	
}
