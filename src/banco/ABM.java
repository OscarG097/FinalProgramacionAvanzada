package banco;

public class ABM{

	private Cuentas[] clientes;
	private int numClientes;
	private int usuario;
	private int pin;
	
	//private Cuentas cuentas; variable para llamar cosas de Cuentas
	private  int operacion;
	private double deposito;
	private double sal;
	private double retiro;
	 
	 public ABM(int u, int p) {
	        usuario = u;
	        pin = p;
	        clientes = new Cuentas[10]; 
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
					}
				i=i;
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
				sal=sal+deposito;
				System.out.println("Su dinero en cuenta es :" + sal);
			}else {
				return "Tiene que ingresar un numero mayor a 0";
			}
			return "Gracias!";
		}
		
		public String retiroDinero(double retiro) {
			this.retiro=retiro;
			if(retiro < sal) {
				sal-=retiro;			
				
				System.out.println("Puede retirar dinero" + "\nLe quedan :"+ sal);
				
				/*for(int i = 0; i < clientes.length; i++) {
					
							clientes[i].setSaldo(sal);
							// hay q ver la manera de q se guarde lo q se retira
					
				}*/
				
			}else {
				//System.out.println("No puede retirar dinero el monton ingresado es mayor a lo que dispone en cuenta");
				return "No puede retirar dinero el monton ingresado es mayor a lo que dispone en cuenta";	
			}
			return "Gracias!";
			
			
		}
		/*public void verSaldo() {
			saldo=cuentas.getSaldo();
			System.out.println(saldo);
		}*/
		
		public String operaciones(int opera) {
			operacion=opera;
			if(verificacion() == 1) {
				switch(opera) {
				case 0:
					System.out.println("Bienvenido cliente, " + usuario + "." + "\n------------------------\n----ELIJA UNA OPCION----\n-1.- Solicitud de saldo-"
					+ "\n-2.- Retiro de dinero-\n-3.- Depósito de dinero-\n-4.- Salir del sistema-\n------------------------");
					break;
				case 1:
					System.out.println("Su saldo es :"+sal);
					break;
					//return "Su saldo es :" + prueba.getSaldo();
			case 2:
				//System.out.println("Cuanto quiere retirar? :");
				//return "Cuanto quiere retirar? :";
						retiroDinero(retiro);
				break;
				case 3:
					//System.out.println("Cuanto quiere depositar :");
					depositoDinero(deposito);
					//return "Cuanto quiere depositar :";
					break;
			case 4:
				//System.out.println("Gracias por operar con nosotros,hasta luego");
					return "Gracias por operar con nosotros,hasta luego";
			default :
				if (operacion < 0 & operacion >4) {
					System.out.println("Numero de operacion incorrecto");
				}
					
			}
			
			}
			return  "Opcion elegida :"+opera+":";
			//return false;
		}
		
}
