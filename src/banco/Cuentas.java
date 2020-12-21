package banco;

public class Cuentas {

	private int numCliente;
	private int nip;
	private int usuario;
	private int contrasena;
	private double saldo;
	
	
	public Cuentas(int numCliente,int nip,double saldo) {
		usuario=numCliente;
		contrasena=nip;
		this.saldo=saldo;
	}
	public int getNumCliente() {
		return numCliente;
	}
	public void setNumCliente(int numCliente) {
		this.numCliente = numCliente;
	}
	public int getNip() {
		return nip;
	}
	public void setSaldo(double saldo) {
		this.saldo=saldo;
	}
	public double getSaldo() {
		return saldo;
	}
	public int getUsuario() {
		return usuario;
	}
	public int getContrasena() {
		return contrasena;
	}

	
	
	
	
}
