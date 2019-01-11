/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;
import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author windiurno
 */
public class Juego extends Canvas {
    
    //Variables
    public static Dimension dim, dimaux;
    private Image imaux;
    private Graphics gaux;
    Bola miBola;
    Raqueta miRaqueta, miRaqueta2;
    Semaforo semaforo;
    
    //--------------------------------------------------------------------------
    
    //Constructores
    public Juego(Dimension d){
        miBola = new Bola(this);
        miRaqueta = new Raqueta(this, 400);
        miRaqueta2 =  new Raqueta(this, 30);
        this.semaforo = new Semaforo();
        
        this.setBackground(Color.BLACK);
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
    
    //--------------------------------------------------------------------------
    
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
        this.pintarFondo(g2d);
        
        g.drawImage(imaux, 0, 0, this);
    }
    
    //--------------------------------------------------------------------------
    
    public void mover(){
        miBola.moverBola();
        miRaqueta.moverRaqueta();
        miRaqueta2.moverRaqueta();
    }

    //--------------------------------------------------------------------------
    
    //Getter y setter
    public Bola getMiBola() {
        return miBola;
    }
    public void setMiBola(Bola miBola) {
        this.miBola = miBola;
    }
    
    //--------------------------------------------------------------------------
    
    //Metodo para pintar las lineas que hay en medio
    public void pintarFondo(Graphics2D g2d){
        g2d.setColor(Color.WHITE);
        
        int x = 0;
        for(int i = 0; i < 10; i++){
            g2d.fillRect(x, 215, 20, 5);
            x+=30;
        }
    }
    
    //--------------------------------------------------------------------------
    
    //Metodo para reiniciar la posición de la bola y para bajarle la velocidad
    public static void reset(){
        Bola.x = 150;
        Bola.y = 210;
        Ventana.vActual = 12;
    }
}
