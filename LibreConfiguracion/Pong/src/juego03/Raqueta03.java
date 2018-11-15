/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego03;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;

/**
 *
 * @author windiurno
 */
public class Raqueta03 {
    
    Juego03 j;
    int x = 30, xd = 0;
    
    public Raqueta03(Juego03 j){
        this.j = j;
    }
    
    public void pintarRaqueta(Graphics2D g2d){
        //Esto suaviza los border de los componentes dibujados con g2
        g2d.setColor(Color.GREEN);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
        g2d.fillRect(x, 300, 60, 20);
    }
    
    public void moverRaqueta(){
        if(x >= 0 && x <= Juego03.dim.width-60){
            x += xd;
        } else {
            if(x == -1){
                x++;
            }
            if(x == Juego03.dim.width-59){
                x--;
            }
            
        }
        
    }
    
    public void teclaPulsada(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            xd = -1;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            xd = 1;
        }
    }
    
    public void soltarTecla(KeyEvent ke){
        xd = 0;
    }
    
}
