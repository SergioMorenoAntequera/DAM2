/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego02;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author windiurno
 */
public class Bola {
    
    Juego game;
    static int dx = 1, dy = 1, x = 10, y = 10;
    static int tamBola = 50;
    
    public Bola(Juego game){
        this.game = game;
    }
    
    public void moverBola(){
        x += dx;
        y += dy;
        if(x > (Juego.dim.width-tamBola) || x < 0){
            dx *= -1;
        }
        //No es 350 (y-tamaño bola) porque también hay que contar la barra de arriba de la ventana
        if(y > (Juego.dim.height-tamBola) || y < 0){
            dy *= -1;
        }
    }
    
    public void paint(Graphics2D g){
        //Esto suaviza los border de los componentes dibujados con g2
        g.setColor(Color.RED);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
        
        g.fillOval(x, y, tamBola, tamBola);
    }
}
