package gestorAplicacion.cliente;

import java.io.Serializable;

public abstract class Persona implements Serializable{
	
	private static final long serialVersionUID = -1L;
	protected String nombre;
	protected final int identificacion;
	protected String correo;
	protected String Direccion;
	protected String Telefono;
	
	
	public Persona(String nombre, int identificacion, String correo, String direccion, String telefono,
			String genero) {
		super();
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.correo = correo;
		Direccion = direccion;
		Telefono = telefono;
		this.genero = genero;
	}
	
	
	@Override
	public String toString() {
		return "nombre=" + nombre + ", identificacion=" + identificacion;
	}


	private String genero;
	
	
	public String getNombre() {
		return nombre;
	}
	public int getIdentificacion() {
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
	
	public abstract String listaObjetos();
	
}
