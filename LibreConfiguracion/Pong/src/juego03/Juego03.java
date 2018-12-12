/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego03;
import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author windiurno
 */
public class Juego03 extends Canvas {
    
    public static Dimension dim, dimaux;
    private Image imaux;
    private Graphics gaux;
    Bola03 miBola;
    Raqueta03 miRaqueta, miRaqueta2;
    
    public Juego03(Dimension d){
        miBola = new Bola03(this);
        miRaqueta = new Raqueta03(this, 300);
        miRaqueta2 =  new Raqueta03(this, 30);
        
        this.dim = d;
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                miRaqueta.teclaPulsada(e);
                miRaqueta2.teclaPulsada2(e);
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                miRaqueta.soltarTecla(e);
                miRaqueta2.soltarTecla2(e);
            }
        });
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
        miBola.pintarBola(g2d);
        miRaqueta.pintarRaqueta(g2d);
        miRaqueta2.pintarRaqueta(g2d);
        
        g.drawImage(imaux, 0, 0, this);
    }
    
    public void mover(){
        //miBola.moverBola();
        miRaqueta.moverRaqueta();
        miRaqueta2.moverRaqueta();
    }

    //Getter y setter
    public Bola03 getMiBola() {
        return miBola;
    }
    public void setMiBola(Bola03 miBola) {
        this.miBola = miBola;
    }
    
}
