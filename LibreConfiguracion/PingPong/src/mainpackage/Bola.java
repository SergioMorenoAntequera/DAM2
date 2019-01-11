/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JOptionPane;

/**
 *
 * @author windiurno
 */
public class Bola {
    
    //Variables
    Juego game;
    public static int dx = 1, dy = 1, x, y;
    static int tamBola = 15;
    
    //--------------------------------------------------------------------------
    
    public Bola(Juego game){
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
    
    //--------------------------------------------------------------------------
    
    public void moverBola(){
        
        //Chocar con las pareces
        if(x > (game.getWidth()-tamBola) || x < 0)
            dx *= -1;
        if(y > (game.getHeight()-tamBola) || y < 0)
            dy *= -1;

        //Al quitarle el comentario al sonido el programa peta
        
        //Punto
        if (y == game.getHeight() - tamBola) {
            marcarPunto1();
            //Sonidos.SOUNDGAMEOVER.play();
        }
        if(y==0) {
            marcarPunto2();
            //Sonidos.SOUNDGAMEOVER.play();
        }
        
        //Chocar con las palas
        if(game.miRaqueta.getRaqueta().intersects(game.miBola.getPelota()) || game.miRaqueta2.getRaqueta().intersects(game.miBola.getPelota())){
            dy *= -1;
            //Sonidos.SOUNDPELOTA.play();
        }
        
        x += dx;
        y += dy;
    }
    
    //--------------------------------------------------------------------------
    
    //Metodos que saltan al un jugador marcar
    public void marcarPunto1(){
        PanelDerecha.tfPuntos1.setText(++PanelDerecha.puntos1+"");
        if(PanelDerecha.puntos1 == 5){
            Ventana.terminado = true;
            JOptionPane.showMessageDialog(game, "Gana el jugador superior", "¡Game Over!", JOptionPane.PLAIN_MESSAGE);
        }
        Juego.reset();
        
    }
    public void marcarPunto2(){
        PanelDerecha.tfPuntos2.setText(++PanelDerecha.puntos2+"");
        if(PanelDerecha.puntos2 == 5){
            Ventana.terminado = true;
            JOptionPane.showMessageDialog(game, "Gana el jugador inferior", "¡Game Over!", JOptionPane.PLAIN_MESSAGE);
        }
        this.x = 150;
        this.y = 210;
        Juego.reset();
    }
    
    //--------------------------------------------------------------------------

    //Getter de la pelota (Que es el  dibujo de un rectangulo en una posición x 
    //con el tamaño determinado)
    public Rectangle getPelota(){
        return new Rectangle(x, y, tamBola, tamBola);
    }
}
