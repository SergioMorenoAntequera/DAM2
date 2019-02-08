package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Modelo;
import vista.Vista;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author seran
 */
public class Controlador implements ActionListener{

    private Vista vista;
    private Modelo modelo;
    
    public Controlador(Vista v, Modelo m){
        vista = v;
        modelo = m;
        this.vista.bMultiplicar.addActionListener(this);
    }
    
    public void initComponentes(){
        vista.setTitle("Ejemplo MVC");
        vista.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        modelo.setNum1(Integer.parseInt(vista.tf1.getText()));
        modelo.setNum2(Integer.parseInt(vista.tf2.getText()));
        modelo.multiplicar();
        vista.tfResultado.setText(modelo.getRes()+"");
    }
    
}
