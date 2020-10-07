package uiMain;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);

	    int numero;
		
		
		
		do {
			
			System.out.println("Elija una opcion:");
			System.out.println("1.Registrar cliente");
			System.out.println("2.Registrar Producto");
			System.out.println("3.Crear Pedido");
			System.out.println("4.Agregar inventario");
			System.out.println("5.Realizar devolucion");
			System.out.println("6.Salir");
			numero = entrada.nextInt();
			
			  String marco;
		         
		        switch (numero) 
		        {
		            case 1:  marco = "marco ";
		                     break;
		            case 2:  marco = "marco 2";
		                     break;
		            case 3:  marco = "marco 3";
		                     break;
		            case 4:  marco = "marco 4";
		                     break;
		            case 5:  marco = "marco 5";
		                     break;
		            case 6:  marco = "marco 6";
		                     break;
		            case 7:  marco = "marco 7";
		                     break;
		            default: marco = "Dia inválido";
		                     break;
		        }
		        System.out.println(marco);
			
		}while(numero!=6);
      

	}

}
