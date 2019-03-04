/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import modelo.Ball;
import modelo.SpaceShip;
import vista.CanvasGame;
import vista.Frame;

/**
 *
 * @author seran
 */
public class Controller implements ActionListener, KeyListener{
    
    Frame game;
    CanvasGame cv;
    SpaceShip spaceShip;
    
    
    public Controller(Frame f){
        this.game = f;
        this.cv = cv;
        spaceShip = this.game.cv.spaceShip;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {}

    //--------------------------------------------------------------------------
    
    @Override
    public void keyTyped(KeyEvent e) {
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(spaceShip.xPosition <= 360){
                spaceShip.moveSpaceShip(1);
            }
            
        }
        
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (spaceShip.xPosition >= 1) {
                spaceShip.moveSpaceShip(-1);
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.game.cv.balls.add(new Ball(spaceShip.xPosition - 10));

        }
    }
}
