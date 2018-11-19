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
    JButton casillaPulsada;
    int banderasColocadas = 0;

    public Control(Ventana v) {
        this.v = v;
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        valorCampo = v.pc.valorCampo;
        botonesCampo = v.pc.campo;
    }

    //==============//
    //ActionListener//
    //==============//
    @Override
    public void actionPerformed(ActionEvent e) {
            
        if (e.getSource() == v.bStart) {
            for (int f = 0; f < botonesCampo.length; f++) {
                for (int c = 0; c < botonesCampo[f].length; c++) {
                    botonesCampo[f][c].setText("");
                    botonesCampo[f][c].setIcon(null);
                    botonesCampo[f][c].setBackground(new JButton().getBackground());
                    valorCampo[f][c] = 0;
                }
            }
            ponerMinas();
            ponerAvisos();
            //v.pr.bStart.setEnabled(false);

            //Activamos casillas
            for (int f = 0; f < botonesCampo.length; f++) {
                for (int c = 0; c < botonesCampo[f].length; c++) {
                    botonesCampo[f][c].setEnabled(true);
                }
            }
        }
        if (e.getSource() == v.bPause) {
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
                        //Y en el resto  de bombas te pone las marcas
                        for (int i = 0; i < botonesCampo.length; i++) {
                            for (int j = 0; j < botonesCampo[i].length; j++) {
                                if (valorCampo[i][j] == 9) {
                                    botonesCampo[i][j].setIcon(new ImageIcon("src/source/bomb.png"));
                                    botonesCampo[i][j].setEnabled(false);
                                }
                            }
                        }
                        
                        //Si tocas una mina te pone una explosion en el sitio donde tocaste
                        botonesCampo[f][c].setIcon(new ImageIcon("src/source/explosion.png"));
                        botonesCampo[f][c].setBackground(Color.red);
                        JOptionPane.showMessageDialog(null, "Has perdido!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                        //Falta:
                        //Hacer que se termine la partida
                        //Parar el reloj
                    }
                    //*********NEUTRAL*******//
                    //=======================//
                    if (valorCampo[f][c] > 0 && valorCampo[f][c] < 9) {
                        botonesCampo[f][c].setText(valorCampo[f][c] + "");
                        botonesCampo[f][c].setEnabled(false);
                    }
                    //*********NADA**********//
                    //=======================//
                    if (valorCampo[f][c] == 0) {
                        botonesCampo[f][c].setEnabled(false);
                        mirarAlrededor(f, c);
                    }

                    /*System.out.println("Casilla f:" + f + "  c:" + c);
                     System.out.println("Valor: " + valorCampo[f][c]);*/
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

    private void mirarAlrededor(int f, int c) {
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if ((f + i) <= valorCampo.length - 1 && (f + i) >= 0) {
                    if ((c + j) <= valorCampo[f].length - 1 && (c + j) >= 0) {
                        //Alredores: f =(f + i) / c = (c + j)
                        int fAux = (f + i);
                        int cAux = (c + j);

                        if (valorCampo[fAux][cAux] < 9 && valorCampo[fAux][cAux] > 0) {
                            botonesCampo[fAux][cAux].setEnabled(false);
                            botonesCampo[fAux][cAux].setText(valorCampo[fAux][cAux] + "");
                        }
                        if (valorCampo[fAux][cAux] == 0) {
                            botonesCampo[fAux][cAux].setEnabled(false);
                            //mirarAlrededor(fAux, cAux);
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
        //Poner banceritas
        casillaPulsada = (JButton) e.getSource();
        Icon iconoBandera = new ImageIcon("src/source/flag.png");
        Icon iconoBandera2 = new ImageIcon("src/source/q2.png");

        for (int f = 0; f < valorCampo.length; f++) {
            for (int c = 0; c < valorCampo[f].length; c++) {
                if (casillaPulsada == botonesCampo[f][c] && e.getButton() == MouseEvent.BUTTON3 && botonesCampo[f][c].isEnabled()) {
                    System.out.println(banderasColocadas);
                    //conseguimos la casilla
                    //Si nos quedan banderas
                    if (banderasColocadas < 10) {
                        //Si no hay nada(null) ponemos la bandera normal
                        if (botonesCampo[f][c].getIcon() == null) {
                            botonesCampo[f][c].setIcon(iconoBandera);
                            banderasColocadas++;
                        } else {
                            //Si hay la normal lo quitamos
                            if (botonesCampo[f][c].getIcon() == iconoBandera) {
                                botonesCampo[f][c].setIcon(null);
                                banderasColocadas--;
                            }
                        }
                        v.pr.tfMinas.setText(banderasColocadas+"/10");
                    }
                }
            }
        }
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
