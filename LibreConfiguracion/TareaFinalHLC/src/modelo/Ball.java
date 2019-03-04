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
public class Ball {
    
    
    ImageIcon i;
    Image ball;
    int xPosition, yPosition;
    public boolean inpacted;
    
    public Ball(int xPosition){
        
        i = new ImageIcon("src/resource/ball.png");
        ball = i.getImage();
        this.inpacted = false;
        
        
        this.xPosition = xPosition;
        this.yPosition = 550;
    }
    
    public void paintBall(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(ball, xPosition, yPosition, null);
    }
    
    public Rectangle getBall(){
        return new Rectangle(this.xPosition, this.yPosition, 50, 50);
    }
    
    public void moveBall() {
        if (yPosition > -50) {
            if(this.inpacted) {
                this.yPosition = -1000;
                return;
            }
            this.yPosition -= 3;
        }  
    }
}
