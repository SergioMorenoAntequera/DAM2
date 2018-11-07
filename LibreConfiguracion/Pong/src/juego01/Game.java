/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego01;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author windiurno
 */
public class Game extends Canvas {
    
    static int dx = 1, dy = 1;
    static int x = 0, y = 0;
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        //Esto suaviza los border de los componentes dibujados con g2
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
        g2.setColor(Color.RED);

        g2.fillOval(x, y, 50, 50);
    }
    
    //===================//
    //**METODOS CREADOS**//
    //===================//
    public static void dormir(int mseg) {
        try {
            Thread.sleep(mseg);
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void mover(){
        x += dx;
        y += dy;
        if(x > 250 || x < 0){
            dx *= -1;
        }
        //No es 350 (y-tamaño bola) porque también hay que contar la barra 
        if(y > 325 || y < 0){
            dy *= -1;
        }
    }
    
    //========//
    //**MAIN**//
    //========//
    public static void main(String[] args){
        JFrame frame = new JFrame("Pong");
        Game game = new Game();
        frame.add(game);
        frame.setSize(new Dimension(300, 400));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
        while(true){
            game.dormir(5);
            game.mover();
            //Lo que hace repaint es borrar lo que había en el objeto game y volverlo a dibujar
            game.repaint();
        }                
    }
}
