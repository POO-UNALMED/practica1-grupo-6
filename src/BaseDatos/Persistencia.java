package BaseDatos;

import java.io.*;
import java.util.ArrayList;

import gestorAplicacion.cliente.Administrador;

public class Persistencia {
	public static void guardarArchivos (){
		File Adminis = new File("src\\BaseDatos\\temp\\Administradores.txt");
		if(!Adminis.exists()) {
			try {
				Adminis.createNewFile();
			}
			catch(IOException e){
				System.out.println("No se pudo crear archivo");
			}
		}
		
		try {
			ObjectOutputStream escribir = 
					new ObjectOutputStream(new FileOutputStream(Adminis));
			ArrayList<Administrador> mostrarAdmin = Administrador.getAdministradores();
			escribir.writeObject(mostrarAdmin);
			escribir.close();
			
		}
		catch(IOException p){
			System.out.println("Se ha generado un error");
		}
		
		
	}
}
