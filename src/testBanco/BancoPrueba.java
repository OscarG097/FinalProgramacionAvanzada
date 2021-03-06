package testBanco;

import banco.ATM;
import banco.Cuentas;

import java.util.Scanner;

public class BancoPrueba {
	
	public static void main(String[] args) {
	
		//Creacion de clientes para tener en la base de datos
		Cuentas c1 = new Cuentas(12345, 12345, 40000);
		Cuentas c2 = new Cuentas(45678, 45678, 45000);
		
		//Logeo del cliente, ingresa cuenta y nip
		Scanner input = new Scanner(System.in);
		
		int opcion=4;
		
		while(opcion == 4) { /// while para retomar el ingreso de cuenta cuando un usuario sale y entra uno nuevo
		System.out.println("�BIENVENIDO!" + "\nIngrese su n�mero de cuenta:");
		//Ingresa Cuenta y pone valor en el constructor
		int user = input.nextInt();
		System.out.println("Introduzca su NIP:");
		//Ingresa NIP y pone valor en el cosntructor
		int contr = input.nextInt();
		
		ATM cliente1 = new ATM(user, contr);
		cliente1.addAccount(c1);
		cliente1.addAccount(c2);
		System.out.println(cliente1.toString());
		
		//Ingresar opcion 
		System.out.println("Ingrese el numero de su seleccion:");
		opcion=input.nextInt();
		
		while(opcion != 4) {
			if(opcion != 2 & opcion !=3){
				System.out.println(cliente1.operaciones(opcion));
			}else if(opcion == 2) {
				System.out.println("Ingrese cuanto desea retirar de su cuenta");
				int retiro=input.nextInt();
				System.out.println(cliente1.retiroDinero(retiro));
			}else if(opcion == 3) {
				System.out.println("Cuanto desea depositar");
				int deposito=input.nextInt();
				System.out.println(cliente1.depositoDinero(deposito));
		}
		System.out.println("�Quiere realizar otra consulta?");	
		System.out.println("Si la respuesta es si, presione 0 para volver al menu o 4 para salir");
		opcion=input.nextInt();
		
		if(opcion == 0) {
			 System.out.println(cliente1.operaciones(opcion)); 
			 System.out.println("Ingrese el numero de su seleccion: ");
			 opcion=input.nextInt();
			 System.out.println(cliente1.operaciones(opcion));
		 }else {
			 opcion=4;
	 }	
		
   }
		}	
	
  }
}