/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author windiurno
 */
public class Control implements ActionListener, MouseListener {
    
    Ventana v;
   
    public Control(Ventana v){
        this.v = v;
    }
    
    private void iniciarComponentes(){
        
    }
    
    //==============//
    //ActionListener//
    //==============//
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == v.bStart) {
            ponerMinas();
        }
        if(e.getSource() == v.bPause){
            System.out.println("quieto vaquero");
            v.pr.bPause.setEnabled(false);
        }
        if(e.getSource() == v.bExit){
            System.exit(0);
        }
        if(e.getSource() == v.pc.campo){
            
        }
    }

    public void ponerMinas() {
        //===============//
        //Colocamos minas//
        //===============//
        //Este bucle es que para cuando se le de a Start otra vez se reinicien las minas a 0
        v.pr.bPause.setEnabled(true);
        for (int f = 0; f < v.pc.campo.length; f++) {
            for (int c = 0; c < v.pc.campo[f].length; c++) {
                System.out.println("Poniendo a blanco " + f + "-" + c);
                v.pc.valorCampo[f][c] = 0;
                v.pc.campo[f][c].setText(v.pc.valorCampo[f][c]+"");
            }
        }
        //Aquí se colocan
        v.pc.nMinas = 10;
        for (int f = 0; f < v.pc.nMinas; f++) {
            boolean valido = false;
            int filaRandom, columRandom;
            
            while (!valido) {
                filaRandom = (int) (Math.random() * v.pc.nFilas);
                columRandom = (int) (Math.random() * v.pc.nColumnas);
                if (v.pc.valorCampo[filaRandom][columRandom] == 0) {
                    System.out.println("Colocando mina " + f + " en (" + filaRandom + "-" + columRandom);
                    valido = true;
                    v.pc.valorCampo[filaRandom][columRandom] = 9;
                    v.pc.campo[filaRandom][columRandom].setText(v.pc.valorCampo[filaRandom][columRandom] + "");
                }
            }
            valido = false;
        }
    }
    
    
    //=============//
    //MouseListener//
    //=============//
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    
}
