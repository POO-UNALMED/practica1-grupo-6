import java.util.ArrayList;

public class Administrador extends Persona {
	private double salario;
	private String profesion;
	static private ArrayList<Administrador>administradores=new ArrayList();
	
	
	public Administrador(String nombre, String identificacion, String correo, String direccion, String telefono,
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
	
	public Administrador listaAdmin() {
		Administrador ad= null;
		for(int i=0; i< administradores.size();) {
			ad= administradores.get(i);
			return (ad);
		}
		return ad;									/*para verificar, este metodo*/
	}
	
	
}
