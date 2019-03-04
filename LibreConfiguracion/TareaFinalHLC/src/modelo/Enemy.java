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

/**
 *
 * @author Sergio Moreno Antequera
 */
public class Enemy {
    
    public int enemyID;
    int xPosition;
    public int yPosition;
    public boolean dead;
    public boolean llegado;
    ImageIcon i;
    Image enemy;
    
    
    public Enemy(int id){
        this.enemyID = id;
        dead = false;
        getRandomPosition();
        i = new ImageIcon("src/resource/enemy.png");
        enemy = i.getImage();
        llegado = false;
    }

    //--------------------------------------------------------------------------
    
    public void paintEnemy(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(enemy, xPosition, yPosition, null);
    }
    
    //--------------------------------------------------------------------------
    
    //1 arriba, 2 derecha, 3 abajo, 4 izquierda
    private void getRandomPosition() {
        xPosition = (int) (Math.random() * 300) + 1;
        yPosition = 0;
    }
    
    //--------------------------------------------------------------------------

    public Rectangle getEnemy(){
        return new Rectangle(xPosition, yPosition, 99, 50);
    }
    
    public int getxPosition() {
        return xPosition;
    }
    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }
    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }
}
