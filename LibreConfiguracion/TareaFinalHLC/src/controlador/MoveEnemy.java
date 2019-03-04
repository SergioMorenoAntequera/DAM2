/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JOptionPane;
import modelo.Ball;
import modelo.Enemy;
import modelo.Sleep;
import vista.CanvasGame;

/**
 *
 * @author Sergio Moreno Antequera
 */
public class MoveEnemy extends Thread {

    //Este hilo se lanza cada vez que se genera un enemigo en GenerateEnemies
    public Enemy enemy;
    //Cuanto menor sea la "speed" menos tarda
    int speed;
    CanvasGame cv;
    
    //--------------------------------------------------------------------------
    
    public MoveEnemy(Enemy e, CanvasGame cv){
        this.enemy = e;
        this.speed = 10;
        this.cv = cv;
    }

    //--------------------------------------------------------------------------
    
    @Override
    public void run() {
        while (enemy.getyPosition() < 650) {
           
            for (Ball b : cv.balls) {
                if (this.enemy.getEnemy().intersects(b.getBall())) {
                    this.enemy.dead = true;
                    b.inpacted = true;
                    b.moveBall();
                    if(this.enemy.enemyID == 9){
                        JOptionPane.showMessageDialog(cv, "FELICIDADES, Has detenido la invasion", "¡¡¡HAS GANADO!!!", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                }
            }

            if (this.enemy.getEnemy().intersects(cv.spaceShip.getSpaceShip())) {
                cv.end = true;
                JOptionPane.showMessageDialog(cv.frameGame, "HAS CHOCADO CON UNA NAVE ENEMIGA", "GAME OVER", JOptionPane.ERROR_MESSAGE);

                System.exit(0);
            }
            
            if(this.enemy.dead) {
                this.enemy.yPosition = 1000;
                return;
            }
            
            if(!cv.end){
                enemy.setyPosition(enemy.getyPosition() + 1);
                Sleep.sleep(speed);
            }
            
        }
        cv.end = true;
        JOptionPane.showMessageDialog(cv.frameGame, "UNA NAVE ENEMIGA HA DESTRUIDO LA CIUDAD", "GAME OVER", JOptionPane.ERROR_MESSAGE);
        
        System.exit(0);
    }
}
