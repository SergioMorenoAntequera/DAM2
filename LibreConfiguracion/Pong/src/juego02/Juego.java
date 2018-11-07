/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego02;
import java.awt.Graphics;
import java.awt.Canvas;

/**
 *
 * @author windiurno
 */
public class Juego extends Canvas {
    
    Bola miBola = new Bola(this);
    
    @Override
    public void update(Graphics g){
        super.paint(g);
    }
    
    public void mover(){
        miBola.moverBola();
    }
    
    

    public Bola getMiBola() {
        return miBola;
    }
    public void setMiBola(Bola miBola) {
        this.miBola = miBola;
    }
    
}
