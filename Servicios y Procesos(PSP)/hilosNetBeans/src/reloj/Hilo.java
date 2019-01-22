package reloj;


public class Hilo implements Runnable{
    
    int min, sec, msec;
    
    Ventana v;
    public Hilo(Ventana v){
        this.v = v;
    }
    
    @Override
    public void run() {
        v.min = 32;
        v.sec = 21;
        v.msec = 19;
    }
    
    public void dormirSegundo(int segundos){
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            System.out.println("Error al dormir");
        }
    }
    public void dormirMiliSegundo(int miliSegundos){
        try {
            Thread.sleep(miliSegundos);
        } catch (InterruptedException ex) {
            System.out.println("Error al dormir");
        }
    }
    
}
