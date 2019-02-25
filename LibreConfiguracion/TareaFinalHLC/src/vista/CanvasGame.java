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
import modelo.Enemy;
import modelo.SpaceShip;

/**
 *
 * @author seran
 */
public class CanvasGame extends Canvas {
    
    Frame frameGame;
    Dimension canvasDimensions;
    Dimension auxCanvasDimensions;
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
        Graphics2D g2d = (Graphics2D) g;
        Graphics2D g2dNave = (Graphics2D) g;
        crearCapas(g2d);

        spaceShip.paintSpaceShip(g2dNave);
        
        for(Enemy e : frameGame.hiloGenerarEnemigos.enemies){
            e.paintEnemy(g2d);
        }
        
    }

    //--------------------------------------------------------------------------
    
    //Este metodo nos permite que se vayan creando distintas capas para que
    //Se vea como se mueve en lugar de dibujar muchas
    private void crearCapas(Graphics2D g2d) {
        //Esto es para crear una imagen e ir superponiéndola
        if (canvasDimensions == null || auxCanvasDimensions == null) {
            auxCanvasDimensions = canvasDimensions;
            imaux = createImage(frameGame.getWidth(), frameGame.getHeight());
            gaux = imaux.getGraphics();
        }
        super.paint(gaux);
        
        
        g2d.drawImage(imaux, 0, 0, this);
    }
    
    //--------------------------------------------------------------------------

    @Override
    public void paint(Graphics g) {
        update(g);
    }
    
    //--------------------------------------------------------------------------
    
    
}
