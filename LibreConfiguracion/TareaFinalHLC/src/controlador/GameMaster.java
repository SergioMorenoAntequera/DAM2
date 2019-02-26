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
import modelo.SpaceShip;
import vista.Frame;

/**
 *
 * @author seran
 */
public class GameMaster implements ActionListener, KeyListener{
    
    Frame game;
    SpaceShip spaceShip;
    
    public GameMaster(Frame f){
        this.game = f;
        spaceShip = this.game.cv.spaceShip;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    //--------------------------------------------------------------------------
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            spaceShip.moveSpaceShip(1);
            System.out.println("DERECHA");
        }
        
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            spaceShip.moveSpaceShip(-1);
            System.out.println("IZQUIERDA");
        } 
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
