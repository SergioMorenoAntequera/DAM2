package coches;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        long TInicio, TFin, tiempo;
        TInicio = System.currentTimeMillis();
        int tamaño=0, lavado=0;
        Coche[] coches = new Coche[4];
        Scanner sc = new Scanner(System.in);
        
        
        for(int i = 0; i<4; i++){
            System.out.println("****************");
            System.out.println("Introduce el tipo de lavado del coche " + (i+1) + ": ");
            System.out.println("1.- Normal");
            System.out.println("2.- Extra");
            System.out.println("3.- Super");
            try {
                lavado = sc.nextInt();
                if(lavado > 3 || lavado < 1){
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Error al introducir los datos");
                System.exit(0);
            }
            
            System.out.println("****************");
            System.out.println("Introduce el tamaño del coche " + (i+1) + ": ");
            System.out.println("1.- Normal");
            System.out.println("2.- Mediano");
            System.out.println("3.- Grande");
            try {
                tamaño = sc.nextInt();
                if(tamaño > 3 || tamaño < 1){
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Error al introducir los datos");
                System.exit(0);
            }
            Operario op = new Operario(lavado, "Operario " + (i+1));
            coches[i] = new Coche("Coche" + (i+1), tamaño, op);
        }
        
        
        /*Operario op1 = new Operario(TiposLavados.NORMAL, "Pedro");
        Operario op2 = new Operario(TiposLavados.EXTRA, "Lucia");
        Operario op3 = new Operario(TiposLavados.SUPER, "Pedro");
        Operario op4 = new Operario(TiposLavados.SUPER, "Lucia");
        
        Coche coche1 = new Coche("coche1", TiposCoches.NORMAL, op1); //10
        Coche coche2 = new Coche("coche2", TiposCoches.GRANDE, op2); //20
        Coche coche3 = new Coche("coche3", TiposCoches.MEDIANO, op3); //18
        Coche coche4 = new Coche("coche4", TiposCoches.GRANDE, op4);  //22*/
        
        coches[0].start();
        coches[1].start();        
        try {
            coches[0].join();
            //coche2.join();
            
        } catch (Exception e) {
        }
        coches[2].start();
         try {
            //coche1.join();
            coches[1].join();
            
        } catch (Exception e) {
        }
        coches[3].start();
        try {
            //coche3.join();
            coches[3].join();
        } catch (Exception e) {
        }
        
        TFin = System.currentTimeMillis();
        tiempo = TFin - TInicio;
        System.out.println("Tiempo en limpiar todos los coches " + tiempo/1000);
    }
    
    /*public static Operario crearOperario(int lavado) {
        Operario op1 = null;
        
        switch (lavado) {
            case 1: {
                op1 = new Operario(TiposLavados.NORMAL, "Operario" + lavado);
            }
            break;
            case 2: {
                 op1 = new Operario(TiposLavados.SUPER, "Operario " + lavado);
            }
            break;
            case 3: {
                 op1 = new Operario(TiposLavados.EXTRA, "Operario " + lavado);
            }
            break;
        }
        
        return op1;
    }*/
    
}
