package uiMain;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		System.out.println("INGRESE OPCION");

	    int numero = entrada.nextInt();  
		
		
		
		
        String marco;
         
        switch (numero) 
        {
            case 1:  marco = "marco 1";
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

	}

}
