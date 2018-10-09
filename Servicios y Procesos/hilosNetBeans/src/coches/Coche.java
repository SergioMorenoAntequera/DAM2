package coches;

import cajeras1.Cajera;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Coche extends Thread {
    
    Operario operario;
    TiposCoches tipoCoche;
    int tiempoExtra = 10;

    public Coche(String nombre, TiposCoches tipoCoche, Operario operario){
        
        super(nombre);
        this.tipoCoche = tipoCoche;
        this.operario = operario;
        
        if(this.tipoCoche == TiposCoches.MEDIANO){
            tiempoExtra += 4;
        }
        if(this.tipoCoche == TiposCoches.GRANDE){
            tiempoExtra += 4;
            tiempoExtra += 4;
        }
        
        tiempoExtra += operario.getTiempoExtra();
    }
    
    @Override
    public void run(){
        long TInicio, TFin, tiempo;
        TInicio = System.currentTimeMillis();
        
        System.out.println(super.getName() + " esta siendo lavado por el operario " + operario.getNombre());
        try {
                Thread.sleep(1000 * tiempoExtra);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cajera.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        TFin = System.currentTimeMillis();
        tiempo = TFin - TInicio;
        System.out.println("Tiempo en limpiar " + super.getName() + ": " + tiempo/1000 + " segundos");
    }

    public TiposCoches getTipoCoche() {
        return tipoCoche;
    }
    public void setTipoCoche(TiposCoches tipoCoche) {
        this.tipoCoche = tipoCoche;
    }
    
}
