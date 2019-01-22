/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej01Simple;

/**
 *
 * @author windiurno
 */
public class Hablar extends Thread {
    
    Servidor1 servidor;
    
    
    public Hablar(Servidor1 servidor){
        this.servidor = servidor;
    }
    
    @Override
    public void run(){
        
    }
}
