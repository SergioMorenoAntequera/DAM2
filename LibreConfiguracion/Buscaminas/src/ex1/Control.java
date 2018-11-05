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
    int[][] valorCampo;
    JButton[][] botonesCampo;
   
    public Control(Ventana v){
        this.v = v;
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        valorCampo = v.pc.valorCampo;
        botonesCampo = v.pc.campo;
    }
    
    //==============//
    //ActionListener//
    //==============//
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == v.bStart) {
            ponerMinas();
            ponerAvisos();
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
    
    
    //===============//
    //Metodos creados//
    //===============//
    public void ponerMinas() {
        //===============//
        //Colocamos minas//
        //===============//
        //Este bucle es que para cuando se le de a Start otra vez se reinicien las minas a 0
        v.pr.bPause.setEnabled(true);
        
        for (int f = 0; f < botonesCampo.length; f++) {
            for (int c = 0; c < botonesCampo[f].length; c++) {
                System.out.println("Poniendo a blanco " + f + "-" + c);
                valorCampo[f][c] = 0;
                botonesCampo[f][c].setText(valorCampo[f][c]+"");
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
                if (valorCampo[filaRandom][columRandom] == 0) {
                    System.out.println("Colocando mina " + f + " en (" + filaRandom + "-" + columRandom);
                    valido = true;
                    valorCampo[filaRandom][columRandom] = 9;
                    botonesCampo[filaRandom][columRandom].setText(valorCampo[filaRandom][columRandom] + "");
                }   
            }
            valido = false;
        }
    }

    public void ponerAvisos() {
        for (int f = 0; f < valorCampo.length; f++) {
            for (int c = 0; c < valorCampo[f].length; c++) {
                //Aquí estamos recorriendo el array por dentro
                //Ahora con otros 2 for miramos al rededor de la casilla
                /*if (valorCampo[f][c] == 9) {
                    for (int i = Math.max(f - 1, 0); i < Math.min(f + 1, 8); i++) {
                        for (int j = Math.max(c - 1, 0); j < Math.min(c + 1, 8); j++) {
                            if (valorCampo[i][j] != 9) {
                                valorCampo[i][j] += 1;
                                botonesCampo[i][j].setText(valorCampo[i][j] + "");
                            }
                        }
                    }
                }*/
                //Terminamos de rodear cada casilla
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if ((f + i) <= valorCampo.length-1 && (f + i) >= 0) {
                            if ((c + j) <= valorCampo.length-1 && (c + j) >= 0) {
                                if (valorCampo[i][j] != 9) {
                                    valorCampo[i][j] += 1;
                                    botonesCampo[i][j].setText(valorCampo[i][j] + "");
                                }
                            }
                        }
                    }
                }
                
            }
        }
    }

    
    //=============//
    //MouseListener//
    //=============//
    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
