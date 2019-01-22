package caj1;

public class Cajeras extends Thread{
	
	private Cliente cli;
	public Cajeras(){
	}
	
	public Cajeras(String nombre, Cliente cli){
		super(nombre);
		this.cli = cli;
	}
	
	@Override
	public void run(){
		System.out.println("Empleazon " + );
		
	}
	
}