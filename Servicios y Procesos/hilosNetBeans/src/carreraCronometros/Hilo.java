/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreraCronometros;

/**
 *
 * @author seran
 */
public class Hilo implements Runnable{
    
    int numeroInicial;
    Cronometro pc;

    public Hilo(Cronometro pc){
        this.pc = pc;
    }

    @Override
    public void run() {
        numeroInicial = (int)(Math.random() * 40 + 1);
        String numeroTxt = numeroInicial + "";
        
        System.out.println(numeroTxt);
        pc.txtCrono.setText("01");
    }
    

}
