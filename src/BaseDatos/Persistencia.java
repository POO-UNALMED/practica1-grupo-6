package BaseDatos;

import java.io.*;
import java.util.ArrayList;

import gestorAplicacion.cliente.Administrador;
import gestorAplicacion.cliente.Cliente;
import gestorAplicacion.factura.DetallePedido;
import gestorAplicacion.factura.Pedido;
import gestorAplicacion.factura.Producto;

public class Persistencia {
	public static void guardarArchivos (){
		ObjectOutputStream escribir;
		File Adminis = new File("src\\BaseDatos\\temp\\Administradores.txt");
		File cl = new File("src\\BaseDatos\\temp\\Clientes.txt");
		File dtpedido = new File("src\\BaseDatos\\temp\\DetallePedido.txt");
		File factura1 = new File("src\\BaseDatos\\temp\\Factura.txt");
		File Pedido1 = new File("src\\BaseDatos\\temp\\Pedido.txt");
		File producto1 = new File("src\\BaseDatos\\temp\\Producto.txt");
		
		if(!Adminis.exists() ) {
			try {
				Adminis.createNewFile();
				
				
			}
			catch(IOException e){
				System.out.println("No se pudo crear archivo administrador");
			}
		}
		
		try {
			escribir =new ObjectOutputStream(new FileOutputStream(Adminis));
			ArrayList<Administrador> mostrarAdmin = Administrador.getAdministradores();
			escribir.writeObject(mostrarAdmin);
			escribir.close();
			
		}
		catch(IOException p){
			System.out.println("Se ha generado un error en escritura administrador");
			
		}
		
		if(!cl.exists() ) {
			try {
				cl.createNewFile();
			}
			catch(IOException e){
				System.out.println("No se pudo crear archivo cliente");
			}
		}
		try {
			escribir =new ObjectOutputStream(new FileOutputStream(cl));
			ArrayList<Cliente> mostrarClient = Cliente.getClientes();
			escribir.writeObject(mostrarClient);
			escribir.close();
			
		}
		catch(IOException p){
			System.out.println("Se ha generado un error en escritura cliente");
		}
		
		
		if(!dtpedido.exists() ) {
			try {
				dtpedido.createNewFile();
			}
			catch(IOException e){
				System.out.println("No se pudo crear archivo pedido");
			}
		}
		try {
			escribir =new ObjectOutputStream(new FileOutputStream(dtpedido));
			ArrayList<DetallePedido> mostrardtpedido = DetallePedido.getDetallePedido();
			escribir.writeObject(mostrardtpedido);
			escribir.close();
			
		}
		catch(IOException p){
			System.out.println("Se ha generado un error en escritura pedido");
		}
		
		
		if(!factura1.exists() ) {
			try {
				factura1.createNewFile();
			}
			catch(IOException e){
				System.out.println("No se pudo crear archivo factura");
			}
		}
		try {
			escribir =new ObjectOutputStream(new FileOutputStream(factura1));
			ArrayList<DetallePedido> mostrarfactura1 = DetallePedido.getDetallePedido();
			escribir.writeObject(mostrarfactura1);
			escribir.close();
			
		}
		catch(IOException p){
			System.out.println("Se ha generado un error en escritura factura");
		}
		
		
		if(!Pedido1.exists() ) {
			try {
				Pedido1.createNewFile();
			}
			catch(IOException e){
				System.out.println("No se pudo crear archivo Pedido");
			}
		}
		try {
			escribir =new ObjectOutputStream(new FileOutputStream(Pedido1));
			ArrayList<Pedido> mostrarPedido1 = Pedido.getLpedidos();
			escribir.writeObject(mostrarPedido1);
			escribir.close();
			
		}
		catch(IOException p){
			System.out.println("Se ha generado un error en escritura Pedido");
		}
		
		//
		if(!producto1.exists() ) {
			try {
				producto1.createNewFile();
			}
			catch(IOException e){
				System.out.println("No se pudo crear archivo producto1");
			}
		}
		try {
			escribir =new ObjectOutputStream(new FileOutputStream(producto1));
			ArrayList<Producto> mostrarproducto1 = Producto.getProductos();
			escribir.writeObject(mostrarproducto1);
			escribir.close();
			
		}
		catch(IOException p){
			System.out.println("Se ha generado un error en escritura producto1");
		}
	}
	
	public static void leerArchivos() {
		ObjectInputStream leer;
		File Admin = new File("src\\BaseDatos\\temp\\Administradores.txt");
		if(!Admin.exists()) {
			try {
				Admin.createNewFile();
				
			}catch(Exception e) {
				System.out.println("No se pudo crear el archivo");
			}
		}
		
		try {
			
			leer = new ObjectInputStream(new FileInputStream(Admin));
			@SuppressWarnings("unchecked")
			ArrayList<Administrador> Admins = (ArrayList<Administrador>) leer.readObject();
			Administrador.setAdministradores(Admins);
			
		}catch(Exception e) {
			System.out.println("No se pudo leer el archivo");
		}
	}
}


