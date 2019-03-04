/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import modelo.Ball;
import modelo.Enemy;
import modelo.SpaceShip;

/**
 *
 * @author seran
 */
public class CanvasGame extends Canvas {
    
   
    Dimension dimaux;
    public Graphics2D g2daux;
    Image imaux;
    Graphics gaux;
    
    public boolean end = false;
    
    public Frame frameGame;
    public SpaceShip spaceShip;
    public ArrayList<Ball> balls;
    
    public CanvasGame(Frame fg){
        this.frameGame = fg;
        this.frameGame.add(this);
        
        this.setPreferredSize(new Dimension(fg.getWidth(), fg.getHeight()));
        this.setMinimumSize(new Dimension(fg.getWidth(), fg.getHeight()));
        this.setMaximumSize(new Dimension(fg.getWidth(), fg.getHeight()));
        this.setFocusable(true);
        
        spaceShip = new SpaceShip(this);
        balls = new ArrayList<>();
    }

    //--------------------------------------------------------------------------
    
    @Override
    public void update(Graphics g) {
        //Estas lienas son para que no parpadee la pantalla
        if (dimaux == null || g2daux == null) {
            dimaux = new Dimension(400, 700);
            imaux = createImage(dimaux.width, dimaux.height);
            g2daux = (Graphics2D) imaux.getGraphics();
        }
        super.paint(g2daux);
        //----------------------------------------------------------------------
        
        //Pintamos la imagen de fondo
        paintBackground(g2daux);
        
        //----------------------------------------------------------------------
        
        //Pintamos nuestra nave
        spaceShip.paintSpaceShip(g2daux);
        
        //Pintamos los enemigos
        for(Enemy enemy : frameGame.hiloGenerarEnemigos.enemies){
            if(!enemy.dead){
                enemy.paintEnemy(g2daux);
            }
        }
        
        for(Ball b : balls){
            if(!b.inpacted){
                b.paintBall(g2daux);
                b.moveBall();    
            }
        }
        
        
        g.drawImage(imaux, 0, 0, this);
    }

    //--------------------------------------------------------------------------

    @Override
    public void paint(Graphics g) {
        update(g);
    }

    //----------------
    
    private void paintBackground(Graphics2D g2d) {
        ImageIcon i;
        Image backGround;
        
        i = new ImageIcon("src/resource/fondo.jpg");
        backGround = i.getImage();
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(backGround, 0, 0, null);
    }
}
