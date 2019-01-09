/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego03;
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
    
    //Variables
    Juego03 game;
    static int dx = 1, dy = 1, x, y;
    static int tamBola = 15;
    
    //--------------------------------------------------------------------------
    
    public Bola03(Juego03 game){
        this.game = game;
        this.x = 150;
        this.y = 210;
    }
    
    //--------------------------------------------------------------------------
    
    //Pintar y repintar la bola (rebotes, perder...)
    public void pintarBola(Graphics2D g) {
        g.setColor(Color.WHITE);
        
        //Esto suaviza los border de los componentes dibujados con g2
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       
        g.fillOval(x, y, tamBola, tamBola);
    }
    
    public void moverBola(){
        if(x > (game.getWidth()-tamBola) || x < 0){
            dx *= -1;
        }
        if(y > (game.getHeight()-tamBola) || y < 0){
            dy *= -1;
        }
        if(y==game.getHeight()-tamBola){
            //gameOver();
        }
        if(y==0){
            //gameOver2();
        }
        if(game.miRaqueta.getRaqueta().intersects(game.miBola.getPelota()) || game.miRaqueta2.getRaqueta().intersects(game.miBola.getPelota())){
            dy *= -1;
        }
        
        x += dx;
        y += dy;
    }
    
    //--------------------------------------------------------------------------
    
    //Metodos que saltan al acabar el juego
    public void gameOver(){
        Ventana03.terminado=true;
        JOptionPane.showMessageDialog(game, "Gana el jugador superior", "¡Game Over!", JOptionPane.PLAIN_MESSAGE);
    }
    public void gameOver2(){
        Ventana03.terminado=true;
        JOptionPane.showMessageDialog(game, "Gana el jugador inferior", "¡Game Over!", JOptionPane.PLAIN_MESSAGE);
    }
    
    //--------------------------------------------------------------------------

    //Getter de la pelota (Que es el  dibujo de un rectangulo en una posición x 
    //con el tamaño determinado)
    public Rectangle getPelota(){
        return new Rectangle(x, y, tamBola, tamBola);
    }
}
