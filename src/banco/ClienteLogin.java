package banco;

public class ClienteLogin{
	
	private int[] numCliente = {12345, 54321, 77777, 00000};
	private int[] nip = {11111, 22222, 12345, 00000};
	private int usuario;
	private int contrasena;

	public ClienteLogin(int cliente, int pass) {
		usuario = cliente;
		contrasena = pass;
	}
	
	private String verificacion() {
		for(int i = 0; i < numCliente.length; i++) {
			if (numCliente[i] == usuario) {
				if(nip[i] == contrasena) {
					return "BIENVENIDO CLIENTE, " + usuario;
				}else{
					return "Los datos no coinciden (Contraseņa)";
					}
				}else{
					i = i;
				}
			}
		return "Los datos son incorrectos";
		}		
	
	
	@Override
	public String toString() {
		return verificacion();
	}
}
