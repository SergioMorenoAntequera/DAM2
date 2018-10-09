package cajeras1;

public class Main {
    
    //Nos crea varios cleintes con y se lo asignamos a las cajeras(HILOS)
    public static void main(String[] args){
        
        long TInicio, TFin, tiempo;
        TInicio = System.currentTimeMillis();
        
        Cliente cli1 = new Cliente("Pedro", new int[] {2, 3, 4, 2});
        Cliente cli2 = new Cliente("Maria", new int[] {1, 2, 5, 1});
        Cliente cli3 = new Cliente("Juan", new int[] {4, 2, 1, 3});
    
        Cajera caj1 = new Cajera("cajera1", cli1);
        Cajera caj2 = new Cajera("cajera2", cli2);
        Cajera caj3 = new Cajera("cajera3", cli3);
        
        caj1.start();
        caj2.start();
        caj3.start();
        
        try {
            caj1.join();
            caj2.join();
            caj3.join();
        } catch (Exception e) {
            System.out.println("fail");
        }
        
        TFin = System.currentTimeMillis();
        tiempo = TFin - TInicio;
        System.out.println("Tiempo total de ejecucuion: " + tiempo/1000 + " segundos");
        
    }
    
}
