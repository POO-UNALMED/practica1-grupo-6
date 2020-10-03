import java.util.ArrayList;
import java.util.Iterator;

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
	
}
