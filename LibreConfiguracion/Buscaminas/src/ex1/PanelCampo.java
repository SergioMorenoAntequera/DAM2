/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author windiurno
 */
public class PanelCampo extends JPanel{
    
    public GridLayout gl;
    public int nMinas, nFilas, nColumnas;
    public JButton[][] campo;
    public int[][] valorCampo;
    
    
    public PanelCampo(){
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        nFilas = 8;
        nColumnas = 8;
        gl = new GridLayout(nFilas, nColumnas);
        this.setLayout(gl);
        gl.setVgap(5);  //Espacios verticales
        gl.setHgap(5);  //Espacios horizontales
        valorCampo = new int[nFilas][nColumnas];
        campo = new JButton[nFilas][nColumnas];
        
        for (int f = 0; f < gl.getRows(); f++) {
            for (int c = 0; c < gl.getColumns(); c++) {
                valorCampo[f][c] = 0;
                campo[f][c] = new JButton(valorCampo[f][c]+"");
                campo[f][c].setPreferredSize(new Dimension(45, 45));
                campo[f][c].setBackground(Color.WHITE);
                this.add(campo[f][c]);
                //campo[f][c].addActionListener(new Control(this));
            }
        }
        this.setBackground(Color.WHITE);
    }

    public JButton[][] getCampo() {
        return campo;
    }
    public void setCampo(JButton[][] campo) {
        this.campo = campo;
    }
    public int[][] getValorCampo() {
        return valorCampo;
    }
    public void setValorCampo(int[][] valorCampo) {
        this.valorCampo = valorCampo;
    }
    public int getnMinas() {
        return nMinas;
    }
    public int getnFilas() {
        return nFilas;
    }
    public int getnColumnas() {
        return nColumnas;
    }
    
    
}
