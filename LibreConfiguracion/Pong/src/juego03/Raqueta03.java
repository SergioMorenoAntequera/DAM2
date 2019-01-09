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
import java.awt.event.KeyEvent;

/**
 *
 * @author windiurno
 */
public class Raqueta03 {
    
    //Variables
    Juego03 game;
    int x = 130, xd= 0, y;
     
    //--------------------------------------------------------------------------
    
    public Raqueta03(Juego03 game, int y){
        this.game = game;
        this.y = y;
    }
    
    //--------------------------------------------------------------------------
    
    //Pintar la raqueta(El movimineto y tal)
    public void pintarRaqueta(Graphics2D g2d){
        //Esto suaviza los border de los componentes dibujados con g2
        g2d.setColor(Color.WHITE);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
        g2d.fillRect(x, y, 60, 20);
    }
    
    public void moverRaqueta(){
        if(x >= 0 && x <= game.getWidth()-60){
            x += xd;
        } else {
            if(x == -1){
                x++;
            }
            if (x == game.getWidth() - 59) {
                x--;
            }
        }
    }

    //--------------------------------------------------------------------------
    
    //Poner el movimiento en las barras asignandolas a una tecla y que se paren
    //KeyListener de la barra de abajo
    public void teclaPulsada(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            xd = -1;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            xd = 1;
        }
    }
    //KeyListener de la barra de arriba
    public void teclaPulsada2(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            xd = -1;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            xd = 1;
        }
    }
    
    //Lo misma idea que arriba pero ahora pa que no se paren entre ellas
    public void soltarTecla(KeyEvent e){
        xd = 0;
    }
    public void soltarTecla2(KeyEvent e){
        xd = 0;
    }
    
    //--------------------------------------------------------------------------
    
    //Getter de la barra
    public Rectangle getRaqueta(){
        return new Rectangle(x, y, 60, 20);
    }
    
}
