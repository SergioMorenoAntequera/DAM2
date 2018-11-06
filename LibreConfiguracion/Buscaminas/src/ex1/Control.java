/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author windiurno
 */
public class Control implements ActionListener, MouseListener {
    
    Ventana v;
    int[][] valorCampo;
    JButton[][] botonesCampo;
    Semaforo semaforo;
    HiloHora hilo;
    JButton casillaPulsada;
   
    public Control(Ventana v){
        this.v = v;
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        valorCampo = v.pc.valorCampo;
        botonesCampo = v.pc.campo;
        
        hilo = new HiloHora(v.pr.tfTiempo);
    }

    //==============//
    //ActionListener//
    //==============//
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == v.bStart) {
            ponerMinas();
            ponerAvisos();
            hilo.start();
            //v.pr.bStart.setEnabled(false);
            
            //Activamos casillas
            for (int f = 0; f < botonesCampo.length; f++) {
            for (int c = 0; c < botonesCampo[f].length; c++) {
                botonesCampo[f][c].setEnabled(true);
            }
        }
        }
        if (e.getSource() == v.bPause) {
            hilo.setSeguir(false);
            v.pr.bPause.setEnabled(false);
        }
        if (e.getSource() == v.bExit) {
            System.exit(0);
        }
        //Aquí obtenemos la casilla que pulsamos comparándolas todas con el e.getsource
        casillaPulsada = (JButton) e.getSource();
        for (int f = 0; f < botonesCampo.length; f++) {
            for (int c = 0; c < botonesCampo[f].length; c++) {
                if (casillaPulsada == botonesCampo[f][c]) {
                    //Aquí ya sabemos la casilla que estamos pulsando.
                    //Ahora aqui dentro hay que ver que pasa cuando tocas mina o no
                    //0 = Despejado  ///  9 = Mina
                    //********PERDER********//
                    //======================//
                    if (valorCampo[f][c] == 9) {
                        //Y en el resto  de bombas te pone bombas
                        for (int i = 0; i < botonesCampo.length; i++) 
                            for (int j = 0; j < botonesCampo[i].length; j++) 
                               if (valorCampo[i][j] == 9){
                                   botonesCampo[i][j].setIcon(new ImageIcon("src/source/bomb.png"));
                                   botonesCampo[i][j].setEnabled(false);
                               }      
                        //Si tocas una mina te pone una explosion en el sitio donde tocaste
                        botonesCampo[f][c].setIcon(new ImageIcon("src/source/explosion.png"));
                        botonesCampo[f][c].setBackground(Color.red);
                        JOptionPane.showMessageDialog(null, "FUCKING DEAD", "Looser", JOptionPane.WARNING_MESSAGE);
                        //Falta:
                            //Hacer que se termine la partida
                            //Parar el reloj
                    }
                    //*********NEUTRAL*******//
                    //=======================//
                    if(valorCampo[f][c] > 0 && valorCampo[f][c] < 9){
                        botonesCampo[f][c].setText(valorCampo[f][c]+"");
                        botonesCampo[f][c].setEnabled(false);
                    }
                    //*********NADA**********//
                    //=======================//
                    if(valorCampo[f][c] == 0){
                        botonesCampo[f][c].setText(valorCampo[f][c]+"");
                    }
                    
                    System.out.println("Casilla f:" + f + "  c:" + c);
                    System.out.println("Valor: " + valorCampo[f][c]);
                }
            }
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
                valorCampo[f][c] = 0;
                //botonesCampo[f][c].setText(valorCampo[f][c]+"");
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
                    valido = true;
                    valorCampo[filaRandom][columRandom] = 9;
                    //botonesCampo[filaRandom][columRandom].setText(valorCampo[filaRandom][columRandom] + "");
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
                //System.out.println("ANALIZANDO ALRREDEDORES DE: f = " + f + " / c = " + c);
                //Terminamos de rodear cada casilla
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if ((f + i) <= valorCampo.length - 1 && (f + i) >= 0) {
                            if ((c + j) <= valorCampo[f].length - 1 && (c + j) >= 0) {
                                //Para no meterse en la mina que estamos mirando
                                if ((f + i) != f || c != (c + j)) {
                                    //System.out.println("Posiciones: i = " + (f+i) + " / j = " + (c+j));
                                    //Para no hacer que el valor de las minas pasen de 9
                                    if (valorCampo[f][c] == 9) {
                                        if (valorCampo[(f + i)][(c + j)] != 9) {
                                            valorCampo[(f + i)][(c + j)] += 1;
                                        }
                                    }
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
    public void mouseClicked(MouseEvent e) { //Elegir mina
        for (int i = 0; i < valorCampo.length; i++) {
            for (int j = 0; j < valorCampo[i].length; j++) {
                
                
            }
        }
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
