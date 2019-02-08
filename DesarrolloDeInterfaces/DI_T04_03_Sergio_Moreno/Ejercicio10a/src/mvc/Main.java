/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import controlador.Controlador;
import modelo.Modelo;
import vista.Vista;

/**
 *
 * @author seran
 */
public class Main {
    public static void main(String[] args){
        Modelo modelo = new Modelo();
        Vista vista = new Vista(null, true);
        
        Controlador controlador = new Controlador(vista, modelo);
        
        controlador.initComponentes();
        vista.setVisible(true);
    }
}
