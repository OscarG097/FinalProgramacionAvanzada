package banco;



public class ClienteLogin {
	
	static final int[] numCliente = {12345, 54321, 77777, 00000};
	static final int[] nip = {11111, 22222, 12345, 00000};
	private int usuario;
	private int contrasena;

	
	public ClienteLogin(int cliente, int pass) {
		usuario = cliente;
		contrasena = pass;
	}
	
	 
	private int verificacion() {
		for(int i = 0; i < numCliente.length; i++) {
			if (numCliente[i] == usuario) {
				if(nip[i] == contrasena) {
					return 1;
				}else{
					return 0;
					}
				}else{
					i = i;
				}
			}
		return 0;
		}	
	
	   
	@Override
	public String toString() {
        if (verificacion() == 0){
            return "Los datos ingresados son incorrectos.";
        }else{
		return "Bienvenido cliente, " + usuario + "." + "\n------------------------\n----ELIJA UNA OPCION----\n-1.- Solicitud de saldo-"
				+ "\n-2.- Retiro de dinero-\n-3.- Depósito de dinero-\n-4.- Salir del sistema-\n------------------------";
        }
        
	}
	

	
	
	
	}

