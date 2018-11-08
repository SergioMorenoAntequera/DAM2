/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego02;
import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author windiurno
 */
public class Juego extends Canvas {
    
    public static Dimension dim, dimaux;
    private Image imaux;
    private Graphics gaux;
    Bola miBola;
    
    public Juego(Dimension d){
        miBola = new Bola(this);
        this.dim = d;
    }
    
    @Override
    public void paint(Graphics g){
        update(g);
    }
    
    @Override
    public void update(Graphics g){
        //Aqui solo entra la primera vez para poner el panel en blanco
        if(dim  == null || dimaux == null){
            dimaux = dim;
            imaux = createImage(dimaux.width, dimaux.height);
            gaux = imaux.getGraphics();
        }
        super.paint(gaux);
        Graphics2D g2d = (Graphics2D) gaux;
        miBola.paint(g2d);
        g.drawImage(imaux, 0, 0, this);
    }
    
    public void mover(){
        miBola.moverBola();
    }

    //Getter y setter
    public Bola getMiBola() {
        return miBola;
    }
    public void setMiBola(Bola miBola) {
        this.miBola = miBola;
    }
    
}
