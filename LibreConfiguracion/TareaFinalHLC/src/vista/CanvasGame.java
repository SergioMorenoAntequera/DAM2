/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import controlador.MoveEnemy;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import modelo.Enemy;
import modelo.Sleep;
import modelo.SpaceShip;

/**
 *
 * @author seran
 */
public class CanvasGame extends Canvas {
    
    Frame frameGame;
    Dimension dimaux;
    Graphics2D g2daux;
    Image imaux;
    
    Graphics gaux;
    
    public SpaceShip spaceShip;
    
    public CanvasGame(Frame fg){
        this.frameGame = fg;
        this.frameGame.add(this);
        
        this.setPreferredSize(new Dimension(fg.getWidth(), fg.getHeight()));
        this.setMinimumSize(new Dimension(fg.getWidth(), fg.getHeight()));
        this.setMaximumSize(new Dimension(fg.getWidth(), fg.getHeight()));
        this.setFocusable(true);
        
        spaceShip = new SpaceShip(this);
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
        
        //Pintamos nuestra nave
        spaceShip.paintSpaceShip(g2daux);
        
        //Pintamos los enemigos
        for(Enemy enemy : frameGame.hiloGenerarEnemigos.enemies){
            enemy.paintEnemy(g2daux);
        }
        
        g.drawImage(imaux, 0, 0, this);
    }

    //--------------------------------------------------------------------------

    @Override
    public void paint(Graphics g) {
        update(g);
    }
}
