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
	
	public Producto(String nombre, String marca, String tipo, double precio_venta, String codigo_de_barras,
			int cantidad, double precio_referencia) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.tipo = tipo;
		this.precio_venta = precio_venta;
		this.codigo_de_barras = codigo_de_barras;
		this.cantidad = cantidad;
		this.precio_referencia = precio_referencia;
		productos.add(this);
	}
	
	
	
}
