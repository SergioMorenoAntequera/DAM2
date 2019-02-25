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
 * @author Sergio Moreno Antequera
 */
public class Enemy {
    
    int enemyID;
    int xPosition;
    int yPosition;
    int wall; //1 arriba, 2 derecha, 3 abajo, 4 izquierda
    ImageIcon i;
    Image enemy;
    
    public Enemy(int id){
        this.enemyID = id;
        getRandomPosition();
        i = new ImageIcon("src/resource/enemy.png");
        enemy = i.getImage();
    }

    //--------------------------------------------------------------------------
    
    public void paintEnemy(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(enemy, xPosition, yPosition, null);
    }
    
    //--------------------------------------------------------------------------
    
    private void getRandomPosition() {
        this.wall = (int)(Math.random()*4)+1;
        switch(this.wall){
            case 1:{
                this.xPosition = (int)(Math.random()*800)+1;
                this.yPosition = 0;
            }
            break;
            case 2:{
                this.xPosition = 700;
                this.yPosition = (int)(Math.random()*500)+1;
            }
            break;
            case 3:{
                this.xPosition = (int)(Math.random()*800)+1;
                this.yPosition = 400;
            }
            break;
            case 4:{
                this.xPosition = 0;
                this.yPosition = (int)(Math.random()*500)+1;;
            }
            break;
            default:{
                System.out.println("Aqui no debe entrar");
            }
        }
    }
    
    //--------------------------------------------------------------------------

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
