package caj1;
import java.lang.Thread;

public class Principal {

	static Clientes cli1 = new Clientes("Pedro", new int[] {2, 3, 4, 2});
	static Clientes cli2 = new Clientes("Maria", new int[] {1, 2, 5, 1});
	static Clientes cli3 = new Clientes("Juan", new int[] {4, 2, 1, 3});
	
	public static void main(String[] args){
		
		procesarCompra(cli1);
		procesarCompra(cli2);
		procesarCompra(cli3);
		
	}
	
	public static void procesarCompra(Clientes cliente) {
		
		int total = 0;
		int[] car = cliente.getCarritoCli();
		for(int i = 0; i < car.length; i++){
			
			System.out.println("Procesando articulo " + (i+1) + " en " +  car[i] + " segundos");
			total = total + car[i];
			
			dormir(car[i]);
		}
		System.out.println("Se ha termiando de procesar la compra de " + cliente.getNombreCli());
		System.out.println("");
		
	}
	
	public static void dormir(int segundos){
		try {
			Thread.sleep(segundos * 1000);
		} catch (Exception e){
		}
	}
	
	public Clientes getCli1(){
		return cli1;
	}
	public Clientes getCli2(){
		return cli2;
	}
	public Clientes getCli3(){
		return cli3;
	}
	
}

