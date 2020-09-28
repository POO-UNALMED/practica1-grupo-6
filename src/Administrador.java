import java.util.ArrayList;

public class Administrador extends Persona {
	private double salario;
	private String profesion;
	static private ArrayList<Administrador>administradores;
	
	public double getSalario() {
		return salario;
	}
	public String getProfesion() {
		return profesion;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
}
