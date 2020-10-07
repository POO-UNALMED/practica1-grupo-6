package gestorAplicacion.cliente;
import gestorAplicacion.factura.*;
import java.util.ArrayList;
import java.util.Iterator;

import gestorAplicacion.factura.DetallePedido;
import gestorAplicacion.factura.Factura;
import gestorAplicacion.factura.Pedido;
import gestorAplicacion.factura.Producto;

public class Administrador extends Persona {
	private double salario;
	private String profesion;
	static private ArrayList<Administrador>administradores=new ArrayList();
	static private ArrayList<Producto>productosMasVendidos=new ArrayList();
	
	
	public Administrador(String nombre, int identificacion, String correo, String direccion, String telefono,
			String genero, double salario, String profesion) {
		super(nombre, identificacion, correo, direccion, telefono, genero);
		this.salario = salario;
		this.profesion = profesion;
		administradores.add(this);
	}
	
	public double getSalario() {
		return salario;
	}
	
	public String getProfesion() {
		return profesion;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public String listaAdmin() {
		Iterator<Administrador> iterator= administradores.iterator();
		StringBuffer lista=new StringBuffer ("lista administradores \n");
		while(iterator.hasNext()) {
			Administrador admin =(Administrador) iterator.next();
			lista.append(admin.toString());

		}
		return lista.toString();
	}
	
	private String registrarProducto(String nombre, String marca, String tipo, int cantidad, double precio_referencia) {
		Producto producto = new Producto(nombre,marca,tipo,cantidad,precio_referencia);
		return "Producto registrdo exitosamente";
	}
	private String registrarCliente(String nombre, int identificacion, String correo, String direccion, String telefono,
			String genero) {
		
		if(Cliente.consultarCliente(identificacion)==null) {
			Cliente clienteN = new Cliente(nombre,identificacion,correo,direccion,telefono,genero);
			return "cliente registrdo exitosamente";
			
		}else {
			return "Cliente ya registrado!!!";
			
		}
		
	}
	public String devolucion(int codFac, long codProd, int cantidad) {
		Factura d1 = Factura.consultarFactura(codFac);
		if(d1 != null) {
			Pedido p = d1.getPedido();
			
			DetallePedido dp = p.consultarProducto(codProd);
			if(dp != null) {
				
				if(dp.modificarCantidad(cantidad)){
					d1.agregarFactura(d1);
					return "Devolucion exitosa";
				}
				else {
					return "cantidad de devolucion no es correcta";
				}
			}else {
				return "Producto no encontrado";
			}
			
		}else {
			return "factura no registrada";
		}
		
	}
	
	
}
