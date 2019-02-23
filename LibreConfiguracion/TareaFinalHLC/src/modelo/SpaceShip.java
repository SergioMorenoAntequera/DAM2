/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import vista.CanvasGame;

/**
 *
 * @author seran
 */
public class SpaceShip {
    
    private double rotation;
    ImageIcon i;
    Image spaceShip;
    private boolean shooting;
    CanvasGame cv;

    public SpaceShip(CanvasGame cv) {
        this.cv = cv;
        rotation = 0;
        
        i = new ImageIcon("src/resource/ship.png");
        spaceShip = i.getImage();
        
        shooting = false;
    }
    
    public void paintSpaceShip(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.rotate(Math.toRadians(rotation), (this.cv.getWidth()/2)-i.getIconWidth()/2, this.cv.getHeight()/2-i.getIconHeight()/2);
        g2d.drawImage(spaceShip, (this.cv.getWidth()/2)-i.getIconWidth(), this.cv.getHeight()/2-i.getIconHeight(), null);
    }
    
    //--------------------------------------------------------------------------
    
    //Si nos llega un -1 gira hacia la izquierda, un 1 hacia la derecha
    public void rotateSpaceShip(int direction) {
        if (direction == 1) {
            this.rotation++;
        } else {
            if (direction == -1) {
                this.rotation--;
            } else {
                System.out.println("Direccion no valida");
            }
        }
    }

    //--------------------------------------------------------------------------

    public double getRotation() {
        return rotation;
    }
    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public boolean isShooting() {
        return shooting;
    }
    public void setShooting(boolean shooting) {
        this.shooting = shooting;
    }
    
    
    
}
