/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego03;
import juego02.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

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
        x += dx;
        y += dy;
        if(x > (Juego03.dim.width-tamBola) || x < 0){
            dx *= -1;
        }
        //No es 350 (y-tamaño bola) porque también hay que contar la barra de arriba de la ventana
        if(y > (Juego03.dim.height-tamBola-20) || y < 0){
            dy *= -1;
        }
    }
    
}
