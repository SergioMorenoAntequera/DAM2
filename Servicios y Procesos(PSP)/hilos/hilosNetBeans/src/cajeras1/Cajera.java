package cajeras1;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cajera extends Thread{
	
    private Cliente cli;
    public Cajera(){
    }
	
    public Cajera(String nombre, Cliente cli){
        super(nombre);
	this.cli = cli;
    }
	
    @Override
    public void run(){
        long TInicio, TFin, tiempo;
        TInicio = System.currentTimeMillis(); 
        
        System.out.println(super.getName() + " procesando compra de " + cli.getNombreCli());
        for(int i = 0; i<cli.getCarritoCli().length; i++){
            System.out.println("Articulo " + (i+1) + "(" + cli.getCarritoCli()[i] + "seg)");
            
            try {
                Thread.sleep(1000 * cli.getCarritoCli()[i]);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Cajera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        TFin = System.currentTimeMillis();
        tiempo = TFin - TInicio;
        System.out.println("Tiempo de " + super.getName() + ": " + tiempo/1000 + " segundos");
    }
}