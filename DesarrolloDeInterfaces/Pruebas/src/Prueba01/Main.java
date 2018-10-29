/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba01;

/**
 *
 * @author windiurno
 */
public class Main {
   public static void main(String[] args){
       VentanaPrincipal ventana = new VentanaPrincipal();
       ventana.setTitle("Ciao programar");
       
       ventana.setVentanaPrincipal(ventana);
       
       ventana.setVisible(true);
   }
}
