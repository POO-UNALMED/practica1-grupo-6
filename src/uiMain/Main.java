package uiMain;
import java.util.ArrayList;
import java.util.Scanner;
import gestorAplicacion.cliente.*;
import gestorAplicacion.factura.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);

	    int numero;
		
		Administrador admin = new Administrador("carlos", 11111, "car@ht.com", "carrera 3", "32234", "masculino", 10000.0, "tecnico" );
		
		do {
			
			System.out.println("Elija una opcion:");
			System.out.println("1.Registrar cliente");
			System.out.println("2.Registrar Producto");
			System.out.println("3.Crear Pedido");
			System.out.println("4.inventario");	/*un sub menu...1 editar inventario 2 salir*/
			System.out.println("5.Realizar devolucion");
			System.out.println("6.Clientes mayoritarios");
			System.out.println("7.Mercancia inactiva");
			System.out.println("8.Balances");
			System.out.println("9.Descuentos");
			System.out.println("0.Salir");
			
			numero = entrada.nextInt();
			
			  String marco;
		         
		        switch (numero) 
		        {
		            case 1:
		            	System.out.println("Ingrese nombre cliente: ");
		            	String nombre= entrada.next();
		            	
		            	System.out.println("Ingrese identificacion:");

		            	int  id= entrada.nextInt();
		            	
		            	System.out.println("Ingrese correo:");
		            	String correo= entrada.next();
		            	
		            	System.out.println("Ingrese direccion:");
		            	String direcion= entrada.next();
		            	
		            	System.out.println("Ingrese telefono:");
		            	String telefono= entrada.next();
		            	
		            	System.out.println("Ingrese genero:");
		            	String genero=entrada.next();
		            	
		            	System.out.println(admin.registrarCliente(nombre,id,correo,direcion,telefono,genero));
		            	
		                     break;
		            case 2:  
		            	//*String nombre, String marca, String tipo, int cantidad, double precio_referencia
		            	
		            	System.out.println("Ingrese nombre producto: ");
		            	String nombrep= entrada.next();
		            	
		            	System.out.println("Ingrese marca:");
		            	String  marcap= entrada.next();
		            	
		            	System.out.println("Ingrese tipo:");
		            	String tipop= entrada.next();
		            	
		            	System.out.println("Ingrese cantidad:");
		            	int cantidadp= entrada.nextInt();
		            	
		            	System.out.println("Ingrese precio_referencia:");
		            	double precio_referencia= entrada.nextDouble();
		            	
		            	
		            	System.out.println(admin.registrarProducto(nombrep,marcap,tipop,cantidadp,precio_referencia));
		            	
		            	
		
		                     break;
		            case 3:  
		            	System.out.println("Ingrese id del cliente: ");
		            	
		            	int identificacion= entrada.nextInt();
		            	
		            	Cliente c=Cliente.consultarCliente(identificacion);
		            	if(c!=null) {
		            		Pedido p=admin.crearPedido();
		            		int opcion;
		            		do {//se registran los productos
		            			System.out.println("Ingrese una opcion");
		            			System.out.println("1.Agregar Producto");
		            			System.out.println("2.Retirar Producto");
		            			System.out.println("3.Terminar Pedido");
		            			opcion=entrada.nextInt();
		            			
		            			switch (opcion) {
		            			case 1:
		            				if(!Producto.getProductos().isEmpty()) {
		            					System.out.println("Ingrese codigo del producto: ");
		            					long codigo = entrada.nextLong();
		            					
		            					System.out.println("Ingrese cantidad a llevar");
		            					int cantidad = entrada.nextInt();
		            					
		            					System.out.println(p.Agregar_producto(codigo, cantidad));
		            				}else {
		            					System.out.println("No hay productos en el inventario");
		            				}
		            				break;
		            			case 2:
		            				System.out.println(p.listaProductos());
		            				if(!p.getDetalleProductos().isEmpty()) {
		            					System.out.println("Ingrese codigo de detalle: ");
		            					int codigoDetalle = entrada.nextInt();	            					
		            					p.quitar_producto(codigoDetalle);
		            				}else {
		            					System.out.println("No se ha registrado ningun producto");
		            				}
		            				break;
		            			case 3:
		            				System.out.println("Pedido terminado");
		            				break;
		            			default:
		            				System.out.println("Opcion invalida");
		            				break;
		            			}
		            			
		            		}while(opcion!=3);
		            		
		            		int op;
		            		boolean conf=false;
		            		do {// se confirma el pedido
		            			System.out.println("Ingrese una opcion: ");
			            		System.out.println("1.confirmar pedido");
			            		System.out.println("2.cancelar pedido");
			            		
			            		 op = entrada.nextInt();
			            		
			            		switch(op) {
			            		
			            		case 1:
			            			conf=p.confirmacion("si");
			            			break;
			            		case 2:
			            			conf=p.confirmacion("no");
			            			break;
			            		default:
			            			System.out.println("opcion no valida");
			            		}
		            		}while(op!=1||op!=2);
		            		
		           
		            		if(conf) {//se crea la factura
		            			System.out.println("Ingrese la fecha");
			            		String fecha = entrada.next();
			            		p.crearFactura(conf, fecha, c);
		            			System.out.println(p.getFactura().imprimirFactura());
		            		}
		            		
		            	}else {
		            		System.out.println("cliente no registrado");
		            	}
		                     break;
		            case 4: 
		            	/*condicional*/
		            	if(Producto.getProductos().isEmpty()) {
		            		System.out.println("No hay productos en el inventario");
		            	}else {
		            		System.out.println(Producto.listaProductos());
			            	
			            	System.out.println("Ingrese el codigo del producto: ");
			            	long codigo = entrada.nextLong();
			            	
			            	System.out.println("Ingresa la cantidad: ");
			            	int cantidad = entrada.nextInt();
			            	
			            	System.out.println(admin.agregarInventario(codigo, cantidad));
		            	}
		            	
		                     break;
		            case 5:  
		            	System.out.println("Ingrese Identificacion: ");
		            	int identificacion_2= entrada.nextInt();
		            	Cliente devolucion = Cliente.consultarCliente(identificacion_2);
		            	if(devolucion!=null) {
		            		System.out.println(devolucion.listaFactura());
		            		System.out.println("Ingrese codigo de Factura ");
		            		int Nfactura  = entrada.nextInt();
		            		Factura consulta = Factura.consultarFactura(Nfactura);
		            		if(consulta!=null) {
		            			System.out.println(consulta.getPedido().listaProductos());
		            			System.out.println("Ingrese el codigo del producto: ");
		            			int codigoPro = entrada.nextInt();
		            			if(consulta.getPedido().consultarProducto(codigoPro)!=null) {
		            				System.out.println("Ingrese la cantidad de devolucion");
		            				int cantidad = entrada.nextInt();
		            				
		            				System.out.println(admin.devolucion(Nfactura, codigoPro, cantidad));
		            			}else {
		            				System.out.println("producto no encontrado");
		            			}
		            			
		            		}
		            		else {
		            			System.out.println("No se encontro factura");
		            			break;
		            		}
		           		}else {
		           			System.out.println("Cliente no encontrado");
		           		}
		                    
		            case 6:
		            		if(Cliente.getClientes().size()>=3) {
		            			ArrayList <Cliente> Mayores = admin.clientesMayoritarios();
		            			for(int i = 0;i < Mayores.size();i++) {
		            				
		            				System.out.println("Cliente "+ (i+1)+": " + Mayores.get(i));
		            				
		            			}
		            		}
		            		else {
		            			break;
		            		}
		                     
		            case 7:  
		            	System.out.println("Ingrese la fecha inicial: ");
		            	String fecha1 = entrada.next();
		            	
		            	System.out.println("Ingrese la fecha final: ");
		            	String fecha2 = entrada.next();
		            	
		            	String [] fecha_1 = fecha1.split("/"); 
		            	String [] fecha_2 = fecha2.split("/");
		            	
		            	if(Integer.parseInt(fecha_1[2])==Integer.parseInt(fecha_2[2])&&Integer.parseInt(fecha_1[1])==Integer.parseInt(fecha_2[1])&&Integer.parseInt(fecha_1[0])<Integer.parseInt(fecha_2[0])) {
		            		
		            		if(!Factura.rangoDeFacturas(fecha1, fecha2).isEmpty()) {
		            			ArrayList<Producto> Productos = admin.mercanciaMuerta(fecha1, fecha2);
			            		System.out.println("Nombre   Codido de barras   Cantidad");
			            		for (int i = 0; i < Productos.size(); i++) {
									System.out.println(Productos.get(i).toString());
									}
			            		}else {
			            			System.out.println("No hay facturas realizadas en el rango de tiempo pedido");
			            		}
		            		
		            		
		            		
		            	}else if(Integer.parseInt(fecha_1[2])==Integer.parseInt(fecha_2[2])&&Integer.parseInt(fecha_1[1])<Integer.parseInt(fecha_2[1])) {
		            		
		            		if(!Factura.rangoDeFacturas(fecha1, fecha2).isEmpty()) {
		            			ArrayList<Producto> Productos = admin.mercanciaMuerta(fecha1, fecha2);
			            		System.out.println("Nombre   Codido de barras   Cantidad");
			            		for (int i = 0; i < Productos.size(); i++) {
									System.out.println(Productos.get(i).toString());
									}
			            		}else {
			            			System.out.println("No hay facturas realizadas en el rango de tiempo pedido");
			            		}
		            		
		            	}else {
		            		System.out.println("El rango de las fechas no es correcto");
		            	}
		            	
		                     break;
		            case 8:  marco = "marco 8";
		            break;
		            case 9:  marco = "marco 9";
                    break;
		         
		            default: marco = "numero invalido";
		                     break;
		        }
		        
			
		}while(numero!=0);
      

	}

}
