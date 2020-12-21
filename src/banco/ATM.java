package banco;

public class ATM {

	private Cuentas[] clientes;
	private int numClientes;
	private int usuario;
	private int pin; 
	private int operacion;
	private double deposito;
	private double sal;
	private double retiro;
	private double limite = 10000.00;
	 
	public ATM(int u, int p){
	       usuario = u;
	       pin = p;
	       clientes = new Cuentas[2]; 
	       numClientes = 0;
	    }
	 
	  public void addAccount(Cuentas acct) {  
	        int i = numClientes++;
	        clientes[i] = acct;  				
	    }
	
	  private int verificacion() {
			for(int i = 0; i < clientes.length; i++) {
				if (clientes[i].getUsuario() == usuario) {
					if(clientes[i].getContrasena() == pin) {
						sal=clientes[i].getSaldo();
						return 1;
					}else{
						return 0;
						}
					}else{
						return 0;
					}
				}
			return 0;
			}	
	  	  
	  public String toString() {
	        if (verificacion() == 0){
	            return "Los datos ingresados son incorrectos.";
	        }else{
	        	return "Bienvenido cliente, " + usuario + "." + "\n------------------------\n----ELIJA UNA OPCION----\n-1.- Solicitud de saldo-"
					+ "\n-2.- Retiro de dinero-\n-3.- Depósito de dinero-\n-4.- Salir del sistema-\n------------------------";
	        }   
		}
	  public String depositoDinero(double deposito) {
			this.deposito=deposito;
			if(deposito >0) {
				sal = sal+deposito;				
				System.out.println("Su dinero en cuenta es: $" + sal);
				
				for(Cuentas clientes:clientes) {
					clientes.setSaldo(sal);
				}
				
			}else {
				return "Tiene que ingresar un numero mayor a 0";
			}
			return "Gracias!";
		}
		
		public String retiroDinero(double retiro) {
			this.retiro=retiro;
			if(retiro < sal && retiro <= limite) {
				sal-=retiro;			
				limite -= retiro;
				System.out.println("Puede retirar dinero" + "\nLe quedan :"+ sal + "\nQueda en caja: " + limite);
				
				for(Cuentas clientes:clientes) {
					clientes.setSaldo(sal);
				}
					
			}else {
				return "No puede retirar dinero, el monto ingresado es mayor a lo que dispone en cuenta";	
			}
			//Se setea a cero porque sino en un segundo pedido sigue restando el monto que se solicitó antes 
			this.retiro=0;
			retiro=0;
			return "Gracias!";
		}
		public String operaciones(int opera) {
			operacion=opera;
			if(verificacion() == 1) {
				switch(opera) {
				case 0:
					System.out.println("Bienvenido cliente, " + usuario + "." + "\n------------------------\n----ELIJA UNA OPCION----\n-1.- Solicitud de saldo-"
					+ "\n-2.- Retiro de dinero-\n-3.- Depósito de dinero-\n-4.- Salir del sistema-\n------------------------");
					break;
				case 1:
					System.out.println("Su saldo es : $"+sal);
					break;
				case 2:
						retiroDinero(retiro);
				break;
				case 3:
					depositoDinero(deposito);
					break;
			case 4:
					return "Gracias por operar con nosotros, hasta luego";
			default:
				if (operacion < 0 & operacion >4) {
					System.out.println("Numero de operacion incorrecto");
				}
			}
		}
			return  "Opcion elegida: " + opera;
	}
}
