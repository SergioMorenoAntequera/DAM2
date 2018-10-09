package coches;

public class Main {
    public static void main(String[] args){
        long TInicio, TFin, tiempo;
        TInicio = System.currentTimeMillis();
        
        Operario op1 = new Operario(TiposLavados.NORMAL, "Pedro");
        Operario op2 = new Operario(TiposLavados.EXTRA, "Lucia");
        Operario op3 = new Operario(TiposLavados.SUPER, "Pedro");
        Operario op4 = new Operario(TiposLavados.SUPER, "Lucia");
        
        Coche coche1 = new Coche("coche1", TiposCoches.NORMAL, op1); //10
        Coche coche2 = new Coche("coche2", TiposCoches.GRANDE, op2); //20
        Coche coche3 = new Coche("coche3", TiposCoches.MEDIANO, op3); //18
        Coche coche4 = new Coche("coche4", TiposCoches.GRANDE, op4);  //22
        
        coche1.start();
        coche2.start();
        
        try {
            coche1.join();
            //coche2.join();
            
        } catch (Exception e) {
        }
        coche3.start();
         try {
            //coche1.join();
            coche2.join();
            
        } catch (Exception e) {
        }
        coche4.start();
        try {
            //coche3.join();
            coche4.join();
        } catch (Exception e) {
        }
        
        TFin = System.currentTimeMillis();
        tiempo = TFin - TInicio;
        System.out.println("Tiempo en limpiar todos los coches " + tiempo/1000);
    }
}
