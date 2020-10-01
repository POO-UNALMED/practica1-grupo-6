
public class Persona {
	private String nombre;
	private String identificacion;
	private String correo;
	private String Direccion;
	private String Telefono;
	
	
	public Persona(String nombre, String identificacion, String correo, String direccion, String telefono,
			String genero) {
		super();
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.correo = correo;
		Direccion = direccion;
		Telefono = telefono;
		this.genero = genero;
	}
	
	
	private String genero;
	
	
	public String getNombre() {
		return nombre;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public String getCorreo() {
		return correo;
	}
	public String getDireccion() {
		return Direccion;
	}
	public String getTelefono() {
		return Telefono;
	}
	public String getGenero() {
		return genero;
	}
	
	
}