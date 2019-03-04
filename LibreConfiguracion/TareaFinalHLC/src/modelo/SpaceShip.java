/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import vista.CanvasGame;

/**
 *
 * @author seran
 */
public class SpaceShip {
    
    ImageIcon i;
    Image spaceShip;
    CanvasGame cv;
    
    public int xPosition;
    public int yPosition;

    public SpaceShip(CanvasGame cv) {
        this.cv = cv;
        
        i = new ImageIcon("src/resource/ship.png");
        spaceShip = i.getImage();
        
        this.xPosition = 180;
        this.yPosition = 600;
        
    }
    
    //--------------------------------------------------------------------------
    
    public void paintSpaceShip(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //Aqui es donde se gira todo
        g2d.drawImage(spaceShip, xPosition, yPosition, null);
    }
    
    //--------------------------------------------------------------------------
    
    //Si nos llega un -1 mueve hacia la izquierda, un 1 hacia la derecha
    public void moveSpaceShip(int direction) {
        if (direction == 1) {
            this.xPosition += 5;
        }
        if (direction == -1) {
            this.xPosition -= 5;
        }
    }

    //--------------------------------------------------------------------------
    
    public Rectangle getSpaceShip(){
        return new Rectangle(this.xPosition, this.yPosition, 30, 45);
    }   
}
