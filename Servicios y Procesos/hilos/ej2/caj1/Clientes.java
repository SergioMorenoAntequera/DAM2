package caj1;

public class Clientes{
	
	private String nombreCli;
	private int[] carritoCli;
	
	public Clientes(String nombreCli, int[] carritoCli){
		
		this.nombreCli = nombreCli;
		this.carritoCli = carritoCli;
		
	}
	
	public Clientes(){
		
	}
	
	//Getter y setter
	public String getNombreCli(){
		return nombreCli;
	}
	public int[] getCarritoCli(){
		return carritoCli;
	}
	public void setNombreCli(String NombreCli){
		this.nombreCli = nombreCli;
	}
	public void setNombreCli(int[] carritoCli){
		this.carritoCli = carritoCli;
	}
}