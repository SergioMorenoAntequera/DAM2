/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego03;
import juego02.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JOptionPane;

/**
 *
 * @author windiurno
 */
public class Bola03 {
    
    Juego03 game;
    static int dx = 1, dy = 1, x = 10, y = 10;
    static int tamBola = 20;
    
    public Bola03(Juego03 game){
        this.game = game;
    }
    
    public void pintarBola(Graphics2D g){
        //Esto suaviza los border de los componentes dibujados con g2
        g.setColor(Color.RED);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
        
        g.fillOval(x, y, tamBola, tamBola);
    }
    
    public void moverBola(){
        
        if(x+dx > (game.getWidth()-tamBola) || x < 0)
            dx *= -1;
        if(y+dy > (game.getHeight()-tamBola) || y < 0)
            dy *= -1;
        if(y==game.getHeight()-tamBola)
            gameOver();
        
        if(game.miRaqueta.devolverRaqueta().intersects(game.miBola.devolverPelota())){
            dy *= -1;
        }
        
        x += dx;
        y += dy;
    }
    
    public void gameOver(){
        Ventana03.terminado=true;
        JOptionPane.showMessageDialog(game, "Game Over!!!");
    }
    
    public Rectangle devolverPelota(){
        return new Rectangle(x, y, tamBola, tamBola);
    }
}
