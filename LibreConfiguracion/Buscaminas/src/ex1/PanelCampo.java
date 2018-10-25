/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author windiurno
 */
public class PanelCampo extends JPanel{
    
    GridLayout gl;
    JButton[][] campo;
    

    
    public PanelCampo(){
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        
        gl = new GridLayout(8,8);
        this.setLayout(gl);
        gl.setVgap(5);
        gl.setHgap(5);
        campo = new JButton[8][8];
        
        for(int i = 0; i<gl.getRows(); i++){
            for(int j = 0; j<gl.getColumns(); j++){
                campo[i][j] = new JButton("-9");
                campo[i][j].setPreferredSize(new Dimension(60, 60));
                this.add(campo[i][j]);
            }
        }
    }
}
